package RPG.model.Monsters.monsters;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.Items;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.Armor;
import RPG.model.Items.items.weapons.Weapons;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.Items.items.weapons.weapons.LegendaryArcherBow;
import RPG.model.Monsters.Monster;
import RPG.model.Monsters.MonsterFactory;
import RPG.model.Monsters.equipment.MonsterEquipment;
import RPG.model.abilities.Magic;
import RPG.model.abilities.debuffs.DebuffMagic;
import RPG.model.abilities.debuffs.debuffs.damage.BurningJoe;
import RPG.model.abilities.debuffs.debuffs.disable.Chains;
import RPG.model.abilities.instants.instants.InstantMagic;
import RPG.model.abilities.instants.instants.combat.FireBall;

import java.util.*;

public class LegionnaireOfDarkness implements Monster {
    private static final List<Items> itemsList = Arrays.asList(Items.values());
    private static final int sizeOfItems = itemsList.size();
    private static final Random random = new Random();

    private int HERO_LEVEL;
    private Human human;

    private int damage;
    private int hitPoint;
    private LinkedList<Items> inventory = new LinkedList<>();

    private Map<EquipmentItems, Item> equipmentOfDemon;

    private DebuffMagic debuffMagic;

    private LegionnaireOfDarkness(Human human){
        this.human = human;
        HERO_LEVEL = human.getLevel();
        hitPoint = (HERO_LEVEL+1)*70;
        damage = (HERO_LEVEL+1)*20;
        setEquipmentOfDemon(human);
    }

    private void setEquipmentOfDemon(Human human) {
        this.equipmentOfDemon = MonsterEquipment.monsterEquipmentFactory.getMonsterEquipment(human);
    }

    private boolean isBuffed() {
        return !Objects.equals(debuffMagic, null);
    }

    public int getExperience(){
        return 1000;
    }

    @Override
    public int getDamageForBattle() {
        Weapons weapon = (Weapons)equipmentOfDemon.get(EquipmentItems.HANDS);
        if (isBuffed() && Objects.equals(debuffMagic.getClass().getSimpleName(), "Chains")){
            int turn = debuffMagic.getTimeOfAction();
            System.out.println(turn);
            if (turn > 0){
                System.out.println("He's in ice!");
                return 0;
            }else return damage + weapon.getDamage() + getMagicDamage();
        } else return damage + weapon.getDamage() + getMagicDamage();

    }

    private int getMagicDamage(){
        boolean chance = random.nextBoolean();
        if (chance){
            FireBall fireBall = (FireBall) FireBall.magicFactory.getMagicFactory(human.getLevel());
            return fireBall.getDamage();
        } else return 0;
    }

    private int getDamage(){
        return damage;
    }

    @Override
    public int applyDamage(int applyDamage) {
        if (isBuffed() && debuffMagic.getClass().getSimpleName().contentEquals("BurningJoe")){
            int turn = debuffMagic.getTimeOfAction();
            System.out.println(turn);
            if (turn > 0){
                System.out.println("He's in flame!");
                return applyDamage + debuffMagic.getDamage() - getDefence();
            }else return applyDamage - getDefence();
        }
        else return applyDamage - getDefence();
    }

    private int getDefence() {
        int defence = 0;
        for (Map.Entry<EquipmentItems, Item> entry :
                equipmentOfDemon.entrySet()) {
            if (!entry.getValue().EQUIPMENT_ITEMS().equals(EquipmentItems.HANDS)) {
                defence += ((Armor) entry.getValue()).getDefence();
            }
        }
        return defence;
    }

    @Override
    public int getHitPoint() {
        return hitPoint;
    }

    @Override
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    @Override
    public LinkedList<Items> getInventory() {
        inventory.add(itemsList.get(random.nextInt(sizeOfItems)));
        return inventory;
    }

    public Item getDroppedItems(){
        if (random.nextInt(10) == 9) return LegendaryArcherBow.itemsFactory.createNewItem(human);
        else {
            switch (random.nextInt(5)){
                case 0: return equipmentOfDemon.get(EquipmentItems.HANDS);
                case 1: return equipmentOfDemon.get(EquipmentItems.ARMOR);
                case 2: return equipmentOfDemon.get(EquipmentItems.HEAD);
                case 3: return equipmentOfDemon.get(EquipmentItems.LEGS);
                case 4: return Bow.itemsFactory.createNewItem(human);
                default: return null;
            }
        }
    }

    @Override
    public boolean setDebuff(Magic magic) {
        if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.FireBall.toString()))
            debuffMagic = (DebuffMagic) BurningJoe.magicFactory.getMagicFactory(HERO_LEVEL);
        else if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.IceChains.toString()))
            debuffMagic = (DebuffMagic) Chains.magicFactory.getMagicFactory(HERO_LEVEL);
        return true;
    }

    public String toString(){
        return "Name: " + LegionnaireOfDarkness.class.getSimpleName() + "; Damage: " + getDamage() + "; HitPoint: " + getHitPoint();
    }

    public static MonsterFactory monsterFactory = LegionnaireOfDarkness::new;
}
