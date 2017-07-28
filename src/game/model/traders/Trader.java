package game.model.traders;

import game.model.Items.items.HealingItems;
import game.model.Items.items.Item;

import java.util.List;
import java.util.Map;

/**
 * Базовый интерфейс для реализации классов торговцев.
 */
public interface Trader {

    Item getEquipmentItem(int id);
    List<HealingItems> getHealItems(int count, int id);
    Map<Integer, Item> getPriceListEquipmentObjects();
    Map<Integer, HealingItems> getPriceListHealingObjects();
}
