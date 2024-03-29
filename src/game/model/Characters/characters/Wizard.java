package game.model.Characters.characters;

import game.model.Characters.CharacterFactory;
import game.model.Characters.Human;
import game.model.Items.items.HealingItems;
import game.model.abilities.Magic;

import java.util.ArrayList;

/**
 * Created by pikachu on 13.07.17.
 */
public class Wizard implements Human {

    private int damage = getIntelligence()*2;
    private int agility = 12;
    private int intelligence = 20;
    private int power = 10;
    private int hitPoint = getPower()*10;
    private int experience = 0;
    private int level = 0;
    private int gold = 0;

    public boolean changeLevel(){
        if (experience == ((level+1)*100)) level++;
        return true;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getPower() {
        return power;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setManaPoint(int mana) {
    }

    @Override
    public int getMagic(Magic magic) {
        return 0;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getMultiplierAgility() {
        return 0;
    }

    public int getMultiplierPower() {
        return 0;
    }

    public int getMultiplierIntelligence() {
        return 0;
    }

    @Override
    public int getGold() {
        return 0;
    }

    @Override
    public void setGold(int gold) {

    }

    @Override
    public int getMagicPoint() {
        return 0;
    }

    @Override
    public void setMagicPoint(int magicPoint) {

    }

    @Override
    public int getManaPoint() {
        return 0;
    }

    public int getDefence() {
        return 0;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int applyDamage(int damage) {
        return 0;
    }

    @Override
    public int getHitPoint() {
        return 0;
    }

    @Override
    public void setHitPoint(int hitPoint) {

    }

    @Override
    public int getMaxHitPoint() {
        return 0;
    }

    @Override
    public int getMaxManaPoint() {
        return 0;
    }

    @Override
    public ArrayList<HealingItems> getInventory() {
        return null;
    }

    @Override
    public int getLevel() {
        return 0;
    }

    public double getExperience() {
        return 0;
    }

    public void setExperience(double experience) {

    }

    public double expToNextLevel() {
        return 0;
    }

    @Override
    public void experienceDrop(double experience) {

    }

    public static CharacterFactory characterFactory = Wizard::new;
}
