package RPG.model.abilities.debuffs.debuffs.damage;

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
        timeOfAction -= 1;
//        System.out.println(timeOfAction);
        return timeOfAction;
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
//        System.out.println("He in flames");
        return damage;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.DEBUFF;
    }

    public static MagicFactory magicFactory = BurningJoe::new;
}
