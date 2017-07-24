package RPG.model.Items.items.weapons.weapons;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.ItemsFactory;
import RPG.model.Items.items.weapons.Weapons;
import RPG.model.abilities.Magic;
import RPG.model.abilities.buffs.buffs.ArchersBuff;

import java.util.Random;

/**
 * Created by pikachu on 17.07.17.
 */
public class Bow implements Weapons {
    private int damage;
    private int itemLevel;
    private Human human;
    private Magic magic;

    private Random random = new Random();

    private Bow(Human human){
        this.human = human;
        this.itemLevel = random.nextInt(human.getLevel() + 1);
        this.damage = getLevel() * 7 + 5;
        this.magic = ArchersBuff.getMagic(human);
    }

    @Override
    public Magic getBuff() {
        return magic;
    }

    @Override
    public EquipmentItems EQUIPMENT_ITEMS() {
        return EquipmentItems.HANDS;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getLevel() {
        return itemLevel;
    }

    @Override
    public String getName() {
        return Bow.class.getSimpleName();
    }

    @Override
    public String toString(){
        return Bow.class.getSimpleName() + ": " + " ATK +" + getDamage();
    }

    public static ItemsFactory itemsFactory = Bow::new;
}
