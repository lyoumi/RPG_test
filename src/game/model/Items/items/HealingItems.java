package game.model.Items.items;

import game.model.Characters.Human;
import game.model.Items.items.heal.HealingItemsList;

public interface HealingItems {
    int getPrice();
    HealingItemsList getHealingItemClass();
    void use(Human human);
}
