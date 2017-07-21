package RPG.model.abilities.temporaries;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;

/**
 * Created by pikachu on 18.07.17.
 */
public interface TemporaryMagic extends Magic {

    int getDamage();

    @Override
    int getLevel();

    @Override
    int getManaCost();

    @Override
    MagicClasses getMagicClass();
}
