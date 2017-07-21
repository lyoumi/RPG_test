package RPG.model.abilities.debuffs.debuffs.damage;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.MagicFactory;
import RPG.model.abilities.debuffs.DebuffMagic;

public class BurningJoe implements DebuffMagic {

    private int level;
    private int damage;
    private int timeOfAction = 5;

    private BurningJoe(int level){
        this.level = level + 1;
        this.damage = getLevel()*3;
    }

    @Override
    public int getTimeOfAction() {
        return --timeOfAction;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getManaCost() {
        return 30;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.DEBUFF;
    }

    public static BurningJoe getBurningJoe(int level){
        return new BurningJoe(level);
    }

    public static MagicFactory magicFactory = new MagicFactory() {
        @Override
        public DebuffMagic magicFactory(int level) {
            return new BurningJoe(level);
        }
    };
}
