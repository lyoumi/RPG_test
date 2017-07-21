package RPG.model.abilities.instants.instants.combat;

import RPG.model.abilities.Magic;
import RPG.model.abilities.MagicClasses;
import RPG.model.abilities.instants.InstantMagic;

public class FireBall implements InstantMagic {
    private int level;
    private int damage;
    private int manaCost;

    private FireBall(int level){
        this.level = level + 1;
        this.damage = getLevel() * 5;
        this.manaCost = getLevel() * getCostMultiplier();
    }

    /**
     * Множитель затрат маны (мана на заклинание рассчитывается по формуле Множитель*(Уроень героя+1))
     * @return
     */
    private int getCostMultiplier() {
        return 3;
    }

    /**
     * Возвращается урон вметсе с уроном от дебафа
     *
     * @return
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * Возаращается уровень способности, соответствующий текущему уровню героя + 1 из {@link RPG.controller.PlayerController}
     *
     * @return
     */
    @Override
    public int getLevel() {
        return level;
    }

    /**
     * Возвращается мана, требуемая на выполнение заклинания
     *
     * @return
     */
    @Override
    public int getManaCost() {
        return manaCost;
    }

    /**
     * Возвращается тип заклинания из {@link MagicClasses}
     *
     * @return
     */
    @Override
    public MagicClasses getMagicClass() {
        return MagicClasses.INSTANT;
    }

    public static Magic getMagic(int level) {
        return new FireBall(level);
    }
}
