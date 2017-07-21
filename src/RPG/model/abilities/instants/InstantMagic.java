package RPG.model.abilities.instants;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;

/**
 * Created by pikachu on 18.07.17.
 */
public interface InstantMagic extends Magic{

    int getDamage();

    @Override
    int getLevel();

    @Override
    int getManaCost();

    @Override
    MagicClasses getMagicClass();
}
