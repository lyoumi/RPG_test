package RPG.model.traders;

import RPG.model.Items.items.HealingItems;
import RPG.model.Items.items.Item;

import java.util.List;
import java.util.Map;

public interface Trader {

    Item getEquipmentItem();
    List<HealingItems> getHealItems(int count, HealingItems item);
    Map<Integer, Item> getPriceListEquipmentObjects();
    Map<Integer, HealingItems> getPriceListHealingObjects();
}
