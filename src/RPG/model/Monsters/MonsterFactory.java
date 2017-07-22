package RPG.model.Monsters;

import RPG.model.Characters.Human;

public interface MonsterFactory {
    Monster createNewMonster(Human human);
}
