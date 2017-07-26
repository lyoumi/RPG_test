package RPG.model.abilities.buffs;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;

import java.util.Map;

/**
 * Created by pikachu on 18.07.17.
 */
public interface BuffMagic extends Magic{

    Map<BuffClasses, Integer> getEffect();

    @Override
    int getLevel();

    @Override
    int getManaCost();

    @Override
    MagicClasses getMagicClass();
}
