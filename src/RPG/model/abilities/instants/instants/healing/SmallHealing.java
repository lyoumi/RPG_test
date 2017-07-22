package RPG.model.abilities.instants.instants.healing;

import RPG.model.Characters.Human;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.MagicFactory;
import RPG.model.abilities.instants.InstantMagic;

public class SmallHealing implements InstantMagic{

    private Human human;

    private SmallHealing(Human human){
        this.human = human;
    }

    @Override
    public int getDamage() {
        return human.getMaxHitPoint()/4;
    }

    @Override
    public int getLevel() {
        return human.getLevel();
    }

    @Override
    public int getManaCost() {
        return 40;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.INSTANT;
    }

    public static SmallHealing getSmallHealing(Human human){
        return new SmallHealing(human);
    }
}
