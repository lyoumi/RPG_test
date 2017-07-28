package game.model.Monsters.monsters;

import game.model.Characters.Human;
import game.model.Items.EquipmentItems;
import game.model.Items.items.HealingItems;
import game.model.Items.items.Item;
import game.model.Monsters.Monster;
import game.model.Monsters.MonsterFactory;
import game.model.Monsters.equipment.equipment.MonsterEquipment;
import game.model.abilities.Magic;
import game.model.abilities.debuffs.DebuffMagic;
import game.model.abilities.debuffs.debuffs.damage.BurningJoe;
import game.model.abilities.debuffs.debuffs.disable.Chains;
import game.model.abilities.instants.instants.InstantMagic;

import java.util.*;

/**
 * Created by pikachu on 13.07.17.
 */
public class Demon implements Monster {

    private static Random random = new Random();
    private static int sizeOfItems;
    private static List<HealingItems> itemsList;

    private int level;
    private Human human;

    private int damage;
    private int hitPoint;
    private LinkedList<HealingItems> inventory = new LinkedList<>();
    private Map<EquipmentItems, Item> equipmentOfDemon;

    private final int experience = 100;
    private final int gold = 50;

    private DebuffMagic debuffMagic;

    private Demon(Human human){
        this.human = human;
        level = human.getLevel() + 1;
        hitPoint = level *35;
        damage = level *10;
        setEquipmentOfDemon(human);
        itemsList = MonsterEquipment.monsterEquipmentFactory.getMonsterEquipment().initializeItemList();
        sizeOfItems = itemsList.size();
    }


    private void setEquipmentOfDemon(Human human) {
        this.equipmentOfDemon = MonsterEquipment.monsterEquipmentFactory.getMonsterEquipment().initEquipment(human);
    }

    private boolean isBuffed() {
        return !Objects.equals(debuffMagic, null);
    }

    public int getExperience(){
        return experience;
    }

    @Override
    public int getDamageForBattle() {
        if (isBuffed() && Objects.equals(debuffMagic.getClass().getSimpleName(), "Chains")){
            int turn = debuffMagic.getTimeOfAction();
            System.out.println(turn);
            if (turn > 0){
                System.out.println("He's in ice!");
                return 0;
            }else return damage;
        }
        else return damage;

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
                    return applyDamage + debuffMagic.getDamage();
                }else return applyDamage;
        }
        else return applyDamage;
    }

    @Override
    public int getHitPoint() {
        if (hitPoint < 0) return 0;
        else return hitPoint;
    }

    @Override
    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    @Override
    public LinkedList<HealingItems> getInventory() {
        inventory.add(itemsList.get(random.nextInt(sizeOfItems)));
        return inventory;
    }

    public Map<EquipmentItems, Item> getDroppedItems(){
        return equipmentOfDemon;
    }

    @Override
    public boolean setDebuff(Magic magic) {
        if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.FireBall.toString()))
            debuffMagic = (DebuffMagic) BurningJoe.magicFactory.getMagicFactory(level);
        else if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.IceChains.toString()))
            debuffMagic = (DebuffMagic) Chains.magicFactory.getMagicFactory(level);
        return true;
    }

    @Override
    public boolean isDead() {
        return getHitPoint() == 0;
    }

    @Override
    public int getDroppedGold() {
        return gold;
    }

    public String toString(){
        return "Name: " + Demon.class.getSimpleName() + "; Damage: " + getDamage() + "; HitPoint: " + getHitPoint();
    }

    public static MonsterFactory monsterFactory = Demon::new;
}
