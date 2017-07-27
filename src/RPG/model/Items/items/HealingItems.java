package RPG.model.Items.items;

import RPG.model.Characters.Human;
import RPG.model.Items.items.heal.HealingItemsList;

public interface HealingItems {
    int getPrice();
    HealingItemsList getHealingItemClass();
    void use(Human human);
}
