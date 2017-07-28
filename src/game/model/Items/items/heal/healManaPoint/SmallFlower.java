package game.model.Items.items.heal.healManaPoint;

import game.model.Characters.Human;
import game.model.Items.items.HealingItems;
import game.model.Items.items.heal.HealingItemsFactory;
import game.model.Items.items.heal.HealingItemsList;

public class SmallFlower implements HealingItems{

    private final int price;

    private SmallFlower(){
        this.price = 100;
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
        human.setManaPoint(human.getManaPoint() + human.getMaxManaPoint()/4);
    }

    public static HealingItemsFactory healingItemsFactory = SmallFlower::new;

    public String toString(){
        return SmallFlower.class.getSimpleName();
    }
}
