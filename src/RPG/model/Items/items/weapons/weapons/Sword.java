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
public class Sword implements Weapons {

    private int damage;
    private int level;
    private Human human;
    private Magic magic;

    private Random random = new Random();

    private Sword(Human human){
        this.human = human;
        this.level = random.nextInt(human.getLevel() + 1);
        this.damage = this.getItemLevel() * 5 + 5;
        this.magic = ArchersBuff.magicFactory.getMagicFactory(human.getLevel());
    }

    @Override
    public Magic getBuff() {
        return magic;
    }

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getItemLevel() {
        return level;
    }

    @Override
    public EquipmentItems EQUIPMENT_ITEMS() {
        return EquipmentItems.HANDS;
    }

    @Override
    public String getName() {
        return Sword.class.getSimpleName();
    }

    public String toString(){
        return Sword.class.getSimpleName() + ": ATK +" + getDamage();
    }

    public static ItemsFactory itemsFactory = Sword::new;
}
