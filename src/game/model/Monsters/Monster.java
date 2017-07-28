package game.model.Monsters;

import game.model.Items.EquipmentItems;
import game.model.Items.items.HealingItems;
import game.model.Items.items.Item;
import game.model.abilities.Magic;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by pikachu on 13.07.17.
 */

/**
 * Базовый интерфейс для создания монстров.
 */
public interface Monster {
    int getExperience();
    int getDamageForBattle();
    int applyDamage(int applyDamage);
    int getHitPoint();
    void setHitPoint(int hitPoint);
    LinkedList<HealingItems> getInventory();
    Map<EquipmentItems, Item> getDroppedItems();
    boolean setDebuff(Magic magic);
    boolean isDead();
    int getDroppedGold();
}
