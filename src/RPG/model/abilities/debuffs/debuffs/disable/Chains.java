package RPG.model.abilities.debuffs.debuffs.disable;

import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.debuffs.DebuffMagic;

public class Chains implements DebuffMagic{

    private int damage;
    private int level;
    private int timeOFActions = 5;

    private Chains(int level){
        this.level = level + 1;
        this.damage = getLevel()*2;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getTimeOfAction() {
        return --timeOFActions;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.DEBUFF;
    }

    public static Chains getChains(int level){
        return new Chains(level);
    }
}
