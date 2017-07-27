package RPG.model.Items.items.armors.boots;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.ItemsFactory;
import RPG.model.Items.items.armors.Armor;
import RPG.model.abilities.Magic;
import RPG.model.abilities.buffs.buffs.ArchersBuff;

import java.util.Random;

/**
 * Created by pikachu on 17.07.17.
 */
public class IronBoots implements Armor{

    private int defence;
    private int itemLevel;
    private Magic magic;
    private Human human;
    private final int price;

    private Random random = new Random();

    private IronBoots(Human human){
        this.human = human;
        this.itemLevel = random.nextInt(human.getLevel() + 1);
        this.price = 100*getItemLevel();
        this.defence = getItemLevel() * 10 + 5;
        this.magic = ArchersBuff.magicFactory.getMagicFactory(human.getLevel());
    }

    @Override
    public EquipmentItems EQUIPMENT_ITEMS() {
        return EquipmentItems.LEGS;
    }

    @Override
    public int getItemLevel() {
        return itemLevel;
    }

    @Override
    public int getDefence() {
        return defence;
    }

    @Override
    public String getName() {
        return IronBoots.class.getSimpleName();
    }

    @Override
    public Magic getBuff() {
        return magic;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return IronBoots.class.getSimpleName() + ": DEF +" + getDefence();
    }

    public static ItemsFactory itemsFactory = IronBoots::new;
}
