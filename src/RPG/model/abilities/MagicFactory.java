package RPG.model.abilities;

import RPG.model.abilities.debuffs.DebuffMagic;

public interface MagicFactory {
    DebuffMagic magicFactory(int level);
}
