package RPG.model.Characters;

import RPG.model.Items.Items;
import RPG.model.abilities.Magic;

import java.util.ArrayList;

/**
 * Created by pikachu on 13.07.17.
 */
public interface Human {

    int getManaPoint();

    int getDamage();

    int applyDamage(int damage);

    int getHitPoint();

    void setHitPoint(int hitPoint);

    int getMaxHitPoint();

    ArrayList<Items> getInventory();

    void experienceDrop(double experience);

    int getLevel();

    void setDamage(int damage);

    int getMagic(Magic magic);
}
