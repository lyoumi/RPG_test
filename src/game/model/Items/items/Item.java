package game.model.Items.items;

import game.model.Items.EquipmentItems;
import game.model.abilities.Magic;

/**
 * Created by pikachu on 17.07.17.
 */

/**
 * Базовый интерфейс для создания предметов.
 */
public interface Item {
    EquipmentItems EQUIPMENT_ITEMS();
    Magic getBuff();
    int getPrice();
}
