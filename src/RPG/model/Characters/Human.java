package RPG.model.Characters;

import RPG.model.Items.items.HealingItems;
import RPG.model.abilities.Magic;

import java.util.ArrayList;

/**
 * Created by pikachu on 13.07.17.
 */
public interface Human {

    int getGold();

    void setGold(int gold);

    int getMagicPoint();

    void setMagicPoint(int magicPoint);

    int getManaPoint();

    int getDamage();

    int applyDamage(int damage);

    int getHitPoint();

    void setHitPoint(int hitPoint);

    int getMaxHitPoint();

    int getMaxManaPoint();

    boolean setManaPoint(int mana);

    ArrayList<HealingItems> getInventory();

    void experienceDrop(double experience);

    int getLevel();

    void setDamage(int damage);

    int getMagic(Magic magic);
}
