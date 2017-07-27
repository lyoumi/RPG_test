package RPG.model.Monsters.equipment;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;
import RPG.model.Monsters.equipment.equipment.MonsterEquipment;

import java.util.HashMap;
import java.util.Map;

public interface MonsterEquipmentFactory {
    MonsterEquipment getMonsterEquipment();
}
