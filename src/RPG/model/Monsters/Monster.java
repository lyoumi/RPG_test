package RPG.model.Monsters;

import RPG.model.Items.EquipmentItems;
import RPG.model.Items.Items;
import RPG.model.Items.items.Item;
import RPG.model.abilities.Magic;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by pikachu on 13.07.17.
 */
public interface Monster {
    int getExperience();
    int getDamageForBattle();
    int applyDamage(int applyDamage);
    int getHitPoint();
    void setHitPoint(int hitPoint);
    LinkedList<Items> getInventory();
    Map<EquipmentItems, Item> getDroppedItems();
    boolean setDebuff(Magic magic);
    boolean isDead();
}
