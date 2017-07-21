package RPG.model.Monsters;

import RPG.model.Characters.Human;
import RPG.model.Items.Items;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.armors.IronChest;
import RPG.model.Items.items.armors.boots.IronBoots;
import RPG.model.Items.items.armors.helmets.IronHelmet;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.Items.items.weapons.weapons.Sword;
import RPG.model.abilities.debuffs.DebuffMagic;
import RPG.model.abilities.debuffs.debuffs.BurningJoe;

import java.util.*;

/**
 * Created by pikachu on 13.07.17.
 */
public class Demon implements Monster {

    private static final List<Items> itemsList = Arrays.asList(Items.values());
    private static final int sizeOfItems = itemsList.size();
    private static final Random random = new Random();

    private int HERO_LEVEL;
    private Human human;

    private int damage;
    private int hitPoint;
    private LinkedList<Items> inventory = new LinkedList<>();

    private DebuffMagic debuffMagic;

    public Demon(Human human){
        this.human = human;
        HERO_LEVEL = human.getLevel();
        hitPoint = (HERO_LEVEL+1)*70;
        damage = (HERO_LEVEL+1)*20;
    }



    private boolean isBuffed(){
        if (Objects.equals(debuffMagic, null)) return false;
        else return debuffMagic.getTimeOfAction() > 0;
    }

    public int getExperience(){
        int experience = 100;
        return experience;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int applyDamage(int applyDamage) {
        if (isBuffed()) {
            System.out.println("He's in flame!");
            return applyDamage + debuffMagic.getDamage();
        }
        else return applyDamage;
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
        switch (random.nextInt(5)){
            case 0: return new Sword(human);
            case 1: return new IronChest(human);
            case 2: return new IronHelmet(human);
            case 3: return new IronBoots(human);
            case 4: return new Bow(human);
            default: return null;
        }
    }

    @Override
    public boolean setDebuff() {
        debuffMagic = BurningJoe.getBurningJoe(HERO_LEVEL);
        return true;
    }

    public String toString(){
        return "Name: " + Demon.class.getSimpleName() + "; Damage: " + getDamage() + "; HitPoint: " + getHitPoint();
    }
}