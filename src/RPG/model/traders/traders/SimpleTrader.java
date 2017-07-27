package RPG.model.traders.traders;

import RPG.lib.RandomUniqueValue;
import RPG.model.Characters.Human;
import RPG.model.Items.items.HealingItems;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.heal.healHitPoint.BigHPBottle;
import RPG.model.Items.items.heal.healManaPoint.BigFlower;
import RPG.model.Items.items.weapons.weapons.LegendaryArcherBow;
import RPG.model.traders.Trader;
import RPG.model.traders.TradersFactory;

import java.util.*;

public class SimpleTrader implements Trader{

    private RandomUniqueValue randomUniqueValue = new RandomUniqueValue();

    private Map<Integer, Item> priceListEquipmentObjects;
    private Map<Integer, HealingItems> priceListHealingObjects;
    private Human human;
    private Random random = new Random();
    private List<Integer> idList = new ArrayList<>();
    private final int bowKey;
    private final int healHPKey;
    private final int healMPKey;

    private SimpleTrader(Human human){
        priceListEquipmentObjects = new LinkedHashMap<>();
        priceListHealingObjects = new LinkedHashMap<>();
        this.human = human;

        bowKey = randomUniqueValue.nextUniqueInt();
        healHPKey = randomUniqueValue.nextUniqueInt();
        healMPKey = randomUniqueValue.nextUniqueInt();

        generatePriceList();
    }

    private void generatePriceList(){
        priceListEquipmentObjects.put(randomUniqueValue.nextUniqueInt(), LegendaryArcherBow.itemsFactory.createNewItem(human));
        priceListHealingObjects.put(randomUniqueValue.nextUniqueInt(), BigFlower.healingItemsFactory.getHealingItem());
        priceListHealingObjects.put(randomUniqueValue.nextUniqueInt(), BigHPBottle.healingItemsFactory.getHealingItem());
    }

    @Override
    public Item getEquipmentItem() {
        priceListEquipmentObjects.remove(bowKey);
        return LegendaryArcherBow.itemsFactory.createNewItem(human);
    }

    @Override
    public List<HealingItems> getHealItems(int count, HealingItems item) {
        List<HealingItems> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(item);
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
