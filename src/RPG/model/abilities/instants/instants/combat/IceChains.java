package RPG.model.abilities.instants.instants.combat;

import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.MagicFactory;
import RPG.model.abilities.instants.InstantMagic;

public class IceChains implements InstantMagic{

    private int damage = 30;
    private int level;
    private int manaCost;
    
    private IceChains(int level){
        this.level = level + 1;
        this.manaCost = level * 3;
    }

    
    
    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage() {
        this.damage += 30;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getManaCost() {
        return manaCost;
    }

    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.INSTANT;
    }

    public static MagicFactory magicFactory = IceChains::new;
}
