package RPG.model.Items.items.armors.helmets;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.armors.Armor;
import RPG.model.abilities.Magic;
import RPG.model.abilities.buffs.buffs.ArchersBuff;

/**
 * Created by pikachu on 17.07.17.
 */
public class IronHelmet implements Armor{

    private int defence;
    private int itemLevel;
    private Human human;
    private Magic magic;

    public IronHelmet(Human human){
        this.human = human;
        this.itemLevel = human.getLevel() + 1;
        this.defence = getItemLevel() * 10 + 5;
        this.magic = ArchersBuff.getMagic(human);
    }

    @Override
    public EquipmentItems EQUIPMENT_ITEMS() {
        return EquipmentItems.HEAD;
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
        return IronHelmet.class.getSimpleName();
    }

    @Override
    public Magic getMagic() {
        return magic;
    }

    public String toString(){
        return IronHelmet.class.getSimpleName() + ": DEF +" + getDefence();
    }
}
