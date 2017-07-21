package RPG.model.Items.items.armors.armors;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.armors.Armor;
import RPG.model.abilities.Magic;
import RPG.model.abilities.buffs.buffs.ArchersBuff;

/**
 * Created by pikachu on 17.07.17.
 */
public class IronChest implements Armor {

    private int defence;
    private int itemLevel;
    private Human human;
    private Magic magic;

    public IronChest(Human human){
        this.human = human;
        this.itemLevel = human.getLevel() + 1;
        this.defence = this.getItemLevel() * 10 + 5;
        this.magic = ArchersBuff.getMagic(human);
    }

    @Override
    public EquipmentItems EQUIPMENT_ITEMS() {
        return EquipmentItems.ARMOR;
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
        return IronChest.class.getSimpleName();
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    public String toString(){
        return IronChest.class.getSimpleName() + ": DEF +" + getDefence();
    }
}
