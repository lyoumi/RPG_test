package RPG.model.Monsters;

import RPG.model.Items.Items;
import RPG.model.Items.items.Item;

import java.util.LinkedList;

/**
 * Created by pikachu on 13.07.17.
 */
public interface Monster {
    int getExperience();
    int getDamage();
    int applyDamage(int applyDamage);
    int getHitPoint();
    void setHitPoint(int hitPoint);
    LinkedList<Items> getInventory();
    Item getDroppedItems();
    boolean setDebuff();
}
