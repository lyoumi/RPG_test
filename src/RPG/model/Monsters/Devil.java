package RPG.model.Monsters;

import RPG.model.Characters.Human;
import RPG.model.Items.Items;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.abilities.Magic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Devil implements Monster{

    private static final List<Items> itemsList = Arrays.asList(Items.values());
    private static final int sizeOfItems = itemsList.size();
    private static final Random random = new Random();

    private int HERO_LEVEL;
    private Human human;

    private int damage;
    private int hitPoint;
    private int experience = 100;
    private LinkedList<Items> inventory = new LinkedList<>();

    public Devil(Human human){
        this.human = human;
        HERO_LEVEL = human.getLevel();
        hitPoint = (HERO_LEVEL+1)*500;
        damage = (HERO_LEVEL+1)*100;
    }

    @Override
    public int getExperience() {
        return 100000;
    }

    @Override
    public int getDamageForBattle() {
        return damage;
    }

    @Override
    public int applyDamage(int applyDamage) {
        return applyDamage;
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

    @Override
    public Item getDroppedItems() {
        return new Bow(human);
    }

    @Override
    public boolean setDebuff(Magic magic) {
        return false;
    }

    public String toString(){
        return Devil.class.getSimpleName() +": HP " + getHitPoint() + "; ATK +" + getDamageForBattle();
    }
}
