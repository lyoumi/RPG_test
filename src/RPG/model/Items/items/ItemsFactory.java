package RPG.model.Items.items;

import RPG.model.Characters.Human;

public interface ItemsFactory {
    Item createNewItem(Human human);
}
