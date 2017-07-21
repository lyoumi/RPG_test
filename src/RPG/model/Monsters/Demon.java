package RPG.model.Monsters;

import RPG.model.Characters.Human;
import RPG.model.Items.Items;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.armors.IronChest;
import RPG.model.Items.items.armors.boots.IronBoots;
import RPG.model.Items.items.armors.helmets.IronHelmet;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.Items.items.weapons.weapons.Sword;
import RPG.model.abilities.Magic;
import RPG.model.abilities.debuffs.DebuffMagic;
import RPG.model.abilities.debuffs.debuffs.damage.BurningJoe;
import RPG.model.abilities.debuffs.debuffs.disable.Chains;
import RPG.model.abilities.instants.instants.InstantMagic;

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
        hitPoint = (HERO_LEVEL+1)*7000;
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
        if (isBuffed() && Objects.equals(debuffMagic.getClass().getSimpleName(), "Chains")){
            System.out.println("He in ice");
            return 0;
        }
        else return damage;

    }

    @Override
    public int applyDamage(int applyDamage) {
        if (isBuffed())
            if (debuffMagic.getClass().getSimpleName().contentEquals("BurningJoe") ) {
                System.out.println("He's in flame!");
                return applyDamage + debuffMagic.getDamage();
            } else return applyDamage;
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
    public boolean setDebuff(Magic magic) {
        if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.FireBall.toString()))
            debuffMagic = (DebuffMagic) BurningJoe.magicFactory.getMagicFactory(HERO_LEVEL);
        else if (Objects.equals(magic.getClass().getSimpleName(), InstantMagic.IceChains.toString()))
            debuffMagic = (DebuffMagic) Chains.magicFactory.getMagicFactory(HERO_LEVEL);
        return true;
    }

    public String toString(){
        return "Name: " + Demon.class.getSimpleName() + "; Damage: " + getDamage() + "; HitPoint: " + getHitPoint();
    }
}
