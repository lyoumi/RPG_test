package RPG.classes.Characters;

import RPG.classes.Items.Items;
import RPG.classes.abilities.Magic;

import java.util.ArrayList;

/**
 * Created by pikachu on 13.07.17.
 */
public interface Human {

    int getManaPoint();

    int getDefence();

    int getDamage();

    int applyDamage(int damage);

    int getHitPoint();

    void setHitPoint(int hitPoint);

    int getMaxHitPoint();

    ArrayList<Items> getInventory();

    void experienceDrop(double experience);

    int getLevel();

    void setDamage(int damage);

    boolean setMana(int mana);

    int getMagic(Magic magic);
}
