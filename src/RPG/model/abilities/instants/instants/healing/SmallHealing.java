package RPG.model.abilities.instants.instants.healing;

import RPG.model.Characters.Human;
import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.MagicFactory;
import RPG.model.abilities.instants.InstantMagic;

public class SmallHealing implements InstantMagic{

    private int maxHitPoint;

    private SmallHealing(int maxHitPoint){
        this.maxHitPoint = maxHitPoint;
    }

    @Override
    public int getDamage() {
        return maxHitPoint/4;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public int getManaCost() {
        return 40;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.INSTANT;
    }

    public static MagicFactory magicFactory = SmallHealing::new;
}
