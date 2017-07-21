package RPG.model.Items.items.armors;

import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;
import RPG.model.abilities.Magic;

/**
 * Created by pikachu on 17.07.17.
 */
public interface Armor extends Item {
    EquipmentItems EQUIPMENT_ITEMS();
    int getItemLevel();
    int getDefence();
    String getName();

    @Override
    Magic getMagic();
}
