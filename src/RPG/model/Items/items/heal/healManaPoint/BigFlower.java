package RPG.model.Items.items.heal.healManaPoint;

import RPG.model.Characters.Human;
import RPG.model.Items.items.HealingItems;
import RPG.model.Items.items.heal.HealingItemsFactory;
import RPG.model.Items.items.heal.HealingItemsList;

public class BigFlower implements HealingItems {

    private final int price;

    private BigFlower(){
        this.price = 200;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public HealingItemsList getHealingItemClass() {
        return HealingItemsList.SmallFlower;
    }

    @Override
    public void use(Human human) {
        human.setManaPoint(human.getMaxManaPoint());
    }

    public static HealingItemsFactory healingItemsFactory = BigFlower::new;

    public String toString(){
        return BigFlower.class.getSimpleName();
    }
}
