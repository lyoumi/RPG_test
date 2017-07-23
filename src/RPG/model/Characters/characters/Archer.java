package RPG.model.Characters.characters;

import RPG.model.Characters.CharacterFactory;
import RPG.model.Characters.Human;
import RPG.model.Items.Equipment;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.Items;
import RPG.model.Items.UsingItems;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.Armor;
import RPG.model.Items.items.weapons.Weapons;
import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.buffs.BuffMagic;
import RPG.model.abilities.instants.instants.combat.FireBall;
import RPG.model.abilities.instants.instants.InstantMagic;
import RPG.model.abilities.instants.instants.combat.IceChains;
import RPG.model.abilities.instants.instants.healing.SmallHealing;

import java.util.*;

/**
 * Created by pikachu on 13.07.17.
 */
public class Archer implements Human, UsingItems, Equipment{

    private int agility = 22;
    private int intelligence = 13;
    private int power = 11;
    private double experience = 0;
    private int level = 0;
    private int baseDamage = getAgility()*getMultiplierAgility();
    private int hitPoint = getPower()*getMultiplierPower();
    private int mana = getIntelligence()*getMultiplierIntelligence();
    private ArrayList<Items> inventory = new ArrayList<>();
    private Map<EquipmentItems, Item> equipmentItems = new HashMap<>();
    private Weapons weapon;
    private Armor armor;
    private int defence;
    private Magic magic;

    private int getMultiplierAgility() {
        return 2;
    }

    private int getMultiplierPower() {
        return 11;
    }

    private int getMultiplierIntelligence() {
        return 6;
    }

    private boolean expToNextLevelReady(){
        return getExperience() >= ((level+1)*150);
    }

    private double getExperience() {
        return experience;
    }

    private void setExperience(double experience) {
        this.experience += experience;
        changeLevel();
    }

    private double expToNextLevel() {
        return (((getLevel()+1)*1500) - getExperience());
    }

    private boolean changeLevel(){
        if (expToNextLevelReady()) {
            level++;
            System.out.println("Congratulation with level: " + level);
            System.out.println();
            setAgility(getAgility()+3);
            setIntelligence(getIntelligence()+2);
            setPower(getPower()+2);
            updateStats();
            System.out.println(this);
            return true;
        } else return false;
    }

    private int getAgility() {
        return agility + getSummaryAdditionAgility();
    }

    private int getSummaryAdditionAgility(){
        int additionAgility = 0;
        if(!Objects.equals(equipmentItems, null)){
            for (Map.Entry<EquipmentItems, Item> entry :
                    equipmentItems.entrySet()) {
                if (!Objects.equals(entry.getValue().getMagic(), null)){
                    if (entry.getValue().getMagic().getMagicClass().equals(MagicClasses.BUFF)){
                        magic = entry.getValue().getMagic();
                        BuffMagic magic = (BuffMagic) this.magic;
                        additionAgility += magic.getAgility();
                    }
                }
            }
        }
        return additionAgility;
    }

    private void setAgility(int agility) {
        this.agility = agility;
    }

    private int getIntelligence() {
        return intelligence + getSummaryAdditionIntelligence();
    }

    private int getSummaryAdditionIntelligence(){
        int additionIntelligence = 0;
        if (!Objects.equals(equipmentItems, null)){
            for (Map.Entry<EquipmentItems, Item> entry :
                    equipmentItems.entrySet()) {
                if (!Objects.equals(entry.getValue().getMagic(), null)){
                    if (entry.getValue().getMagic().getMagicClass().equals(MagicClasses.BUFF)){
                        magic = entry.getValue().getMagic();
                        BuffMagic magic = (BuffMagic) this.magic;
                        additionIntelligence += magic.getIntelligence();
                    }
                }
            }
        }
        return additionIntelligence;
    }

    private void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    private boolean setMana(int mana) {
        this.mana = mana;
        return true;
    }

    private int notEnoughOfMana(){
        System.out.println("Not enough mana!");
        return 0;
    }

    private int getPower() {
        return power + getSummaryAdditionPower();
    }

    private int getSummaryAdditionPower(){
        int additionPower = 0;
        if(!Objects.equals(equipmentItems, null)){
            for (Map.Entry<EquipmentItems, Item> entry : equipmentItems.entrySet()) {
                if (!Objects.equals(entry.getValue().getMagic(), null)){
                    if (entry.getValue().getMagic().getMagicClass().equals(MagicClasses.BUFF)){
                        magic = entry.getValue().getMagic();
                        BuffMagic magic = (BuffMagic) this.magic;
                        additionPower += magic.getPower();
                    }
                }
            }
        }
        return additionPower;
    }

    private void setPower(int power) {
        this.power = power;
    }

    private int getDefence() {
        defence = 0;
        for (Map.Entry<EquipmentItems, Item> entry :
                equipmentItems.entrySet()) {
            if (!entry.getValue().EQUIPMENT_ITEMS().equals(EquipmentItems.HANDS)) {
                defence += ((Armor) entry.getValue()).getDefence();
            }
        }
        return defence;
    }

    private void updateStats(){
        setHitPoint(getPower()*10);
        setDamage(getAgility()*getMultiplierAgility());
        setMana(getAgility()*getMultiplierIntelligence());
    }

    @Override
    public void experienceDrop(double experience){
        setExperience(experience);
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getMagic(Magic magic) {
        if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.FireBall.toString())) {
            FireBall fireBall = (FireBall) magic;
            if(getManaPoint() >= fireBall.getManaCost()){
                setMana(getManaPoint()-fireBall.getManaCost());
                return fireBall.getDamage();
            } else return notEnoughOfMana();
        }else if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.SmallHealing.toString())){
            SmallHealing healing = (SmallHealing) magic;
            if (getManaPoint() >= healing.getManaCost()){
                setMana(getManaPoint()-healing.getManaCost());
                return healing.getDamage();
            } else if(Objects.equals(magic.getClass().getSimpleName(), InstantMagic.IceChains.toString())){
                IceChains iceChains = (IceChains) magic;
                if(getManaPoint() >= iceChains.getManaCost()){
                    setMana(getManaPoint()-iceChains.getManaCost());
                    return iceChains.getDamage();
                } else return notEnoughOfMana();
            }
            else return notEnoughOfMana();
        }else return 0;
    }

    private int getBaseDamage(){
        return baseDamage;
    }

    @Override
    public int getDamage() {
        if (equipmentItems.containsKey(EquipmentItems.HANDS)) return getBaseDamage() + weapon.getDamage();
        else return getBaseDamage();
    }

    @Override
    public int getManaPoint() {
        return mana;
    }

    @Override
    public void setDamage(int damage) {
        this.baseDamage = damage;
    }

    @Override
    public int applyDamage(int damage)  {
        int applyingDamage = damage - getDefence();
        if (applyingDamage < 0) return 0;
        else return applyingDamage;
    }

    @Override
    public int getHitPoint() {
        return hitPoint;
    }

    @Override
    public void setHitPoint(int hitPoint) {
        if (hitPoint > getMaxHitPoint()) this.hitPoint = getMaxHitPoint();
        else this.hitPoint = hitPoint;
    }

    @Override
    public int getMaxHitPoint() {
        return getPower()*getMultiplierPower();
    }

    @Override
    public ArrayList<Items> getInventory() {
        return inventory;
    }

    @Override
    public boolean add(Items item) {
        return inventory.add(item);
    }

    @Override
    public void use(Items item) {
        if (item.equals(Items.SmallHPBottle)) {
            setHitPoint(getHitPoint()+((getPower()*getPower())/2));
            System.out.println(item + " used");
            getInventory().remove(item);
        }
        if (item.equals(Items.MiddleHPBottle)) {
            setHitPoint(getHitPoint() + ((getPower()*getPower())*3/4));
            System.out.println(item + " used");
            getInventory().remove(item);
        }
        if (item.equals(Items.BigHPBottle)) {
            setHitPoint(getPower()*getMultiplierPower());
            System.out.println(item + " used");
            getInventory().remove(item);
        }
        if (item.equals(Items.SmallFlower)){
            setMana(getManaPoint() + (getIntelligence()*getMultiplierIntelligence()));
            System.out.println(item + " used");
            getInventory().remove(item);
        }
        if (item.equals(Items.MiddleFlower)){
            setMana(getManaPoint() + (getIntelligence()*getMultiplierIntelligence()*3/4));
            System.out.println(item + " used");
            getInventory().remove(item);
        }
        if (item.equals(Items.BigFlower)){
            setMana(getIntelligence()*getMultiplierIntelligence());
            System.out.println(item + " used");
            getInventory().remove(item);
        }
    }

    @Override
    public void equip(Item item) {
        if (item.EQUIPMENT_ITEMS().equals(EquipmentItems.HANDS)){
            weapon = (Weapons) item;
            Weapons usingWeapon = (Weapons) equipmentItems.get(EquipmentItems.HANDS);
            if (equipmentItems.containsKey(item.EQUIPMENT_ITEMS())){
                if (weapon.getDamage() > usingWeapon.getDamage()){
                    System.err.println(weapon.getName() + " equipped");
                    equipmentItems.put(weapon.EQUIPMENT_ITEMS(), weapon);
                    updateStats();
                }
            } else {
                System.err.println(weapon.getName() + " equipped");
                equipmentItems.put(weapon.EQUIPMENT_ITEMS(), weapon);
                updateStats();
            }
        } else {
            armor = (Armor) item;
            Armor usingArmor = (Armor)equipmentItems.get(item.EQUIPMENT_ITEMS());
            if (equipmentItems.containsKey(item.EQUIPMENT_ITEMS())){
                if (armor.getDefence() > usingArmor.getDefence()){
                    System.err.println(armor.getName() + " equipped");
                    equipmentItems.put(armor.EQUIPMENT_ITEMS(), armor);
                    updateStats();
                }
            } else {
                System.err.println(armor.getName() + " equipped");
                equipmentItems.put(armor.EQUIPMENT_ITEMS(), armor);
                updateStats();
            }
        }
    }

    @Override
    public void unEquip() {

    }

    public String toString(){
        return "Class: " + Archer.class.getSimpleName() +
                "; HP " + String.valueOf(getHitPoint()) +
                "; MP " + getManaPoint() +
                "; Lvl: " + String.valueOf(getLevel()) +
                "; Exp to next level: " + expToNextLevel() +
                "; DMG: " + getDamage() +
                "; DEF: " + getDefence();
    }

    public static CharacterFactory characterFactory = Archer::new;
}
