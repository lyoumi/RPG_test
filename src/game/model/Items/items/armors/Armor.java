package game.model.Items.items.armors;

import game.model.Items.EquipmentItems;
import game.model.Items.items.Item;
import game.model.abilities.Magic;

/**
 * Created by pikachu on 17.07.17.
 */
public interface Armor extends Item {
    int getItemLevel();
    int getDefence();
    String getName();
    EquipmentItems EQUIPMENT_ITEMS();
    Magic getBuff();
    int getPrice();
}
