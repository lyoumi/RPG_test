package game.model.traders.traders;

import lib.RandomUniqueValue;
import game.model.Characters.Human;
import game.model.Items.items.HealingItems;
import game.model.Items.items.Item;
import game.model.Items.items.heal.healHitPoint.BigHPBottle;
import game.model.Items.items.heal.healManaPoint.BigFlower;
import game.model.Items.items.weapons.weapons.LegendaryArcherBow;
import game.model.traders.Trader;
import game.model.traders.TradersFactory;

import java.util.*;

/**
 * Класс-реализация торговца.
 */
public class SimpleTrader implements Trader{

    /**
     * Создаем экземпляр класса для генерации случайного значения типа int.
     */
    private RandomUniqueValue randomUniqueValue = new RandomUniqueValue();

    /**
     * Мар, содержащая id предмета и предметы экипировки.
     */
    private Map<Integer, Item> priceListEquipmentObjects;

    /**
     * Мар, содержащая id предмета и предметы для восстановления здоровья/маны.
     */
    private Map<Integer, HealingItems> priceListHealingObjects;

    /**
     * Объект типа {@link Human} хранящий в себе имплементацию конкретного персонажа.
     */
    private Human human;

    /**
     * Конструктор, инициализирующий map'ы предметов и объект.
     * Также вызывается метод заполняющий map'ы объектами.
     *
     * @param human
     *              character implementation of {@link Human}
     */
    private SimpleTrader(Human human){
        priceListEquipmentObjects = new LinkedHashMap<>();
        priceListHealingObjects = new LinkedHashMap<>();
        this.human = human;

        generatePriceList();
    }

    /**
     * Метод, заполняющий map'ы предметами и их id.
     */
    private void generatePriceList(){
        priceListEquipmentObjects.put(randomUniqueValue.nextUniqueInt(), LegendaryArcherBow.itemsFactory.createNewItem(human));
        priceListHealingObjects.put(randomUniqueValue.nextUniqueInt(), BigFlower.healingItemsFactory.getHealingItem());
        priceListHealingObjects.put(randomUniqueValue.nextUniqueInt(), BigHPBottle.healingItemsFactory.getHealingItem());
    }

    @Override
    public Item getEquipmentItem(int id) {
        Item item = priceListEquipmentObjects.get(id);
        priceListEquipmentObjects.remove(id);
        return item;
    }

    @Override
    public List<HealingItems> getHealItems(int count, int id) {
        List<HealingItems> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(priceListHealingObjects.get(id));
        }
        return list;
    }

    @Override
    public Map<Integer, Item> getPriceListEquipmentObjects() {
        return priceListEquipmentObjects;
    }

    @Override
    public Map<Integer, HealingItems> getPriceListHealingObjects() {
        return priceListHealingObjects;
    }

    public static TradersFactory tradersFactory = SimpleTrader::new;
}
