package game.model.Items.items.weapons;

import game.model.Items.EquipmentItems;
import game.model.Items.items.Item;
import game.model.abilities.Magic;

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
    int getPrice();
}
