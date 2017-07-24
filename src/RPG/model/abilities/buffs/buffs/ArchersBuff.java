package RPG.model.abilities.buffs.buffs;

import RPG.model.Characters.Human;
import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.buffs.BuffMagic;

/**
 * Created by pikachu on 18.07.17.
 */
public class ArchersBuff implements BuffMagic {

    private Human human;
    private final int agility = 6;
    private final int power = 5;
    private final int intelligence = 4;

    private ArchersBuff(Human human){
        this.human = human;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getLevel() {
        return human.getLevel();
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.BUFF;
    }

    public static Magic getMagic(Human human) {
        return new ArchersBuff(human);
    }
}
