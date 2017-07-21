package RPG.model.abilities.buffs;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;

/**
 * Created by pikachu on 18.07.17.
 */
public interface BuffMagic extends Magic{

    int getAgility();

    int getPower();

    int getIntelligence();

    @Override
    int getLevel();

    @Override
    int getManaCost();

    @Override
    MagicClasses getMagicClass();
}
