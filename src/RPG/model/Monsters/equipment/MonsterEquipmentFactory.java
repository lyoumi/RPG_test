package RPG.model.Monsters.equipment;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;

import java.util.HashMap;
import java.util.Map;

public interface MonsterEquipmentFactory {
    HashMap<EquipmentItems, Item> getMonsterEquipment(Human human);
}
