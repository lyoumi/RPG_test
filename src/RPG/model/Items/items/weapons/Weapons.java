package RPG.model.Items.items.weapons;

import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;
import RPG.model.abilities.Magic;

/**
 * Created by pikachu on 17.07.17.
 */
public interface Weapons extends Item {
    EquipmentItems EQUIPMENT_ITEMS();
    int getDamage();
    int getItemLevel();
    String getName();

    @Override
    Magic getBuff();

    @Override
    default int getPrice() {
        return 0;
    }
}
