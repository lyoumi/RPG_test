package RPG.controller;

import RPG.model.Characters.*;
import RPG.model.Items.Equipment;
import RPG.model.Items.Items;
import RPG.model.Items.UsingItems;
import RPG.model.Items.items.Item;
import RPG.model.Monsters.Demon;
import RPG.model.Monsters.Devil;
import RPG.model.Monsters.Monster;
import RPG.model.abilities.Magic;
import RPG.model.abilities.instants.instants.FireBall;

import java.io.IOException;
import java.util.*;

/**
 * Created by pikachu on 13.07.17.
 */
public class PlayerController {

    private static Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final List<Items> itemsList = new ArrayList<>(Arrays.asList(Items.values()));
    private static final int sizeOfItems = itemsList.size();

    /**
     * Основно метод контроля персонажа
     * В этом методе проверяется количество здоровья персонажа и, в случае его смерти, останавливает игру
     * В конце каждого хода пользователю предлагается на выбор использовать имеющиеся предметы,
     * отправить героя добывать ресурсы и опыт, продолжить приключение или же остановить игру.
     *
     * @param human
     *          Character implementation {@link Human}
     */
    private synchronized void beginGame(Human human){

        System.out.println(human);

        while (true) {

            Monster monster = spawn(human);
            System.out.println("\nBattle began with " + monster);

            String resultOfBattle = manualBattle(human, monster);

            if (human.getHitPoint() <= 0) {
                System.err.println("YOU ARE DEAD");
                exit();
            } else if (monster.getHitPoint() <= 0) {
                System.out.println(resultOfBattle + "\n");
                drop(human, monster, false);
            }
            System.out.println("What's next: use item for heal, walking for find new items, auto-battle for check your fortune, stop for break adventures or continue....");

            choice:
            while (true) {
                String s = scanner.nextLine();
                switch (s) {
                    case "use item":
                        useItem(human);
                        break choice;
                    case "walking":
                        String endOfWalk = walking(human);
                        System.out.println(endOfWalk);
                        break choice;
                    case "auto-battle":
                        autoBattle(human);
                        break choice;
                    case "continue":
                        break choice;
                    case "stop":
                        exit();
                        break;
                    default:
                        System.out.println("Pls, make the correct choice....");
                        break;
                }
            }
        }
    }

    /**
     * Данный метод описывает автоматизированное поведение героя
     * В данном методе герой в цикле while() получает 0.0000001 опыта и случайно выпадающие предметы
     * Остановка цикла происходит при вводе с клавиатуры 0
     *
     * @param human
     *          Character implementation {@link Human}
     * @return
     *          String result of walking
     */
    private String walking(Human human){
        try{
            while (System.in.available()==0) {
                human.experienceDrop(0.0000001);
                if (random.nextInt(10000000) == 999999) {
                    Items item = itemsList.get(random.nextInt(sizeOfItems));
                    System.out.println("I found " + item);
                    human.getInventory().add(item);
                }
                if (human.getInventory().size() > ((human.getLevel()+1)*10)) break;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "The walk is over. Your stats: " + human;
    }

    /**
     * Метод симулирующий бой между героем и монстром
     * В ходе боя игрок может покинуть бой для дальнейшего приключения, или же использовать имеющиеся у него веши
     * @param human
     *              Character implementation {@link Human}
     * @param monster
     *              Monster implementation {@link Monster}
     */
    private synchronized String manualBattle(Human human, Monster monster){
        battle:
        while ((human.getHitPoint() > 0) && (monster.getHitPoint() > 0)) {
            punch(human, monster);
            System.out.println(human);

            System.out.println("Choose next turn: use item for heal, use magic for addition damage, leave battle for alive or continue....");

            choice:
            while (true){
                String s = scanner.nextLine();
                switch(s){
                    case "use item":
                        useItem(human);
                        break choice;
                    case "use magic":
                        System.out.println("\n" + monster);
                        Magic magic = FireBall.getMagic(human.getLevel());
                        monster.setDebuff();
                        monster.setHitPoint(monster.getHitPoint() - monster.applyDamage(human.getMagic(magic)));
                        System.out.println(monster.getClass().getSimpleName() + " caught fire for " + human.getMagic(magic) + " getDamage");
                        System.out.println(monster + "\n");
                        break choice;
                    case "continue":
                        break choice;
                    case "leave":
                        break battle;
                    default:
                        System.out.println("Pls, make the correct choice....");
                        break;
                }
            }
        }
        return "The manualBattle is over. Your stats: " + human;
    }

    /**
     * Режим автоматического ведения боя. В случае с малым количеством здоровья персонаж будет способен
     * самостоятельно восстановить здоровье, а в случае отсутствия предметов для восстановления
     * отправится в путешествие для их поиска (walking())
     *
     * @param human
     *          Character implementation {@link Human}
     */
    private void autoBattle(Human human){
        try{
            while (System.in.available()==0){
                if (human.getInventory().isEmpty()) {
                    System.out.println("I need go walk.... Pls, wait some time, I will be back\n" + human);
                    String walkingResults = walking(human);
                    System.out.println(walkingResults);
                }
                if (random.nextInt(10000000) == 9999999){
                    Monster monster = spawn(human);
                    if (Objects.equals(monster.getClass().getSimpleName(), Devil.class.getSimpleName()))
                        System.out.println(monster);
                    while ((human.getHitPoint() > 0) && (monster.getHitPoint() > 0)){
                        autoHeal(human);
                        punch(human, monster);
                        if (Objects.equals(monster.getClass().getSimpleName(), Devil.class.getSimpleName()))
                            System.out.println(human);
                    }
                    human.getInventory().trimToSize();

                    if (human.getHitPoint() <= 0) {
                        System.err.println("YOU ARE DEAD");
                        exit();
                    } else if (monster.getHitPoint() <= 0) {
                        if (Objects.equals(monster.getClass().getSimpleName(), Devil.class.getSimpleName()))
                            System.err.println("DEVIL HAS FALLEN");
                        drop(human, monster, true);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Метод, реализующий удар монстра и героя. Возвращает true после удара
     * @param human
     *          Character implementation of {@link Human}
     * @param monster
     *          Monster implementation of {@link Monster}
     * @return
     *          boolean result of punch
     */
    private boolean punch(Human human, Monster monster){
        System.out.println(monster);
        monster.setHitPoint((monster.getHitPoint() - monster.applyDamage(human.getDamage())));
        human.setHitPoint((human.getHitPoint() - human.applyDamage(monster.getDamage())));
        System.out.println(monster);
        return true;
    }

    /**
     * Метод предназначенный для автоматического восполнения здоровья
     * Возвращает true в случае успешного восполнения здоровья и false в случае если этого не произошло
     * @param human
     *          Character implementation of {@link Human}
     * @return
     *          boolean result of heal
     */
    private boolean autoHeal(Human human){
        if ((human.getHitPoint() < (human.getMaxHitPoint()/10)) && (human.getHitPoint() < 30) && (human.getInventory().contains(Items.BigHPBottle))) {
            ((UsingItems)human).use(Items.BigHPBottle);
            System.out.println(human);
            return true;
        }else if ((human.getHitPoint() < (human.getMaxHitPoint()/4)) && (human.getHitPoint() < 50) && (human.getInventory().contains(Items.MiddleHPBottle))) {
            ((UsingItems)human).use(Items.MiddleHPBottle);
            System.out.println(human);
            return true;
        }else if ((human.getHitPoint() < (human.getMaxHitPoint()/2)) && (human.getHitPoint() < 80) && (human.getInventory().contains(Items.SmallHPBottle))) {
            ((UsingItems)human).use(Items.SmallHPBottle);
            System.out.println(human);
            return true;
        }else return false;
    }

    /**
     * Пользователю предлагается использовать один из имеющихся у него предметов,
     * предвартельно ознакомив его с содержимым инвентаря. Доступ к предмету осществляется по индексу.
     * <p>
     * После ввода индекса осуществляется проверка на наличие этого предмета в инвентаре, после чего вызывается
     * метод use() из класса персонажа.
     *
     * @return
     *          boolean result of using item
     */
    private boolean useItem(Human human) {
        System.out.println("Use your items? " + human.getInventory() + "\nPls, select by index....");
        int position = scanner.nextInt();
        if (human.getInventory().contains(human.getInventory().get(--position))){
            ((UsingItems) human).use(human.getInventory().get(--position));
            return true;
        } else {
            System.out.println("Item not found");
            return false;
        }
    }

    /**
     * После смерти монстра выпадает случайный премет из списка Item.
     * У игрока есть возможность поднять этот предмет и переместить в свой инвентарь
     * <p>
     * Входные параметры:
     *
     * @param human
     *              Character implementation of {@link Human}
     * @param monster
     *              Monster implementation {@link Monster}
     *
     * @return
     *              boolean result
     */
    private boolean drop(Human human, Monster monster, boolean autoDrop) {
        if (autoDrop){

            human.experienceDrop(monster.getExperience());

            ((UsingItems) human).add(monster.getInventory().pollLast());
            ((Equipment)human).equip(monster.getDroppedItems());

            return true;
        } else{

            human.experienceDrop(monster.getExperience());
            System.out.println("You can add to your inventory " + monster.getInventory());
            if (scanner.nextInt() == 1) ((UsingItems) human).add(monster.getInventory().pollLast());

            Item droppedItems = monster.getDroppedItems();
            System.out.println("Equipment " + droppedItems);
            if (scanner.nextInt() == 1) ((Equipment)human).equip(droppedItems);

            return true;
        }
    }

    /**
     * Метод, отвечающий за генерацию монстра
     * @param human
     *          Character implementation of {@link Human}
     * @return
     *          New implementation of {@link Monster} with incremented human level
     *
     */
    private Monster spawn(Human human) {
        if (random.nextInt(100) == 99) return new Devil(human);
        return new Demon(human);
    }


    /**
     * End of game
     */
    private void exit(){
        System.out.println("\nGAME OVER\n");
    }

    public static void main(String[] args){
        PlayerController playerController = new PlayerController();
        System.out.println("Hello in Middle-Earth....");
        System.out.println("Choose your class: archer, berserk, wizard....");
        switch (scanner.nextLine()) {
            case "archer": {
                playerController.beginGame(new Archer());
                break;
            }
            case "berserk": {
                playerController.beginGame(new Berserk());
                break;
            }
            case "wizard": {
                playerController.beginGame(new Wizard());
                break;
            }
        }
    }
}