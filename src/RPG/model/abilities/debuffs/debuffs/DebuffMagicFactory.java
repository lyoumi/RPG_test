package RPG.model.abilities.debuffs.debuffs;

import RPG.model.abilities.debuffs.DebuffMagic;

public interface DebuffMagicFactory {
    DebuffMagic magicFactory(int level);
}
