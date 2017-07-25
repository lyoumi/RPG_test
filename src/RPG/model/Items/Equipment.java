package RPG.model.Items;

import RPG.model.Items.items.Item;

import java.util.Map;

/**
 * Created by pikachu on 14.07.17.
 */
public interface Equipment {
    void equip(Item item);
    void unEquip();
    Map<EquipmentItems, Item> showEquipment();
}
