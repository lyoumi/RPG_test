package RPG.model.Items.items;

import RPG.model.Items.EquipmentItems;
import RPG.model.abilities.Magic;

/**
 * Created by pikachu on 17.07.17.
 */
public interface Item {
    EquipmentItems EQUIPMENT_ITEMS();
    Magic getMagic();
}
