package RPG.model.Monsters.equipment;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.armors.IronChest;
import RPG.model.Items.items.armors.boots.IronBoots;
import RPG.model.Items.items.armors.helmets.IronHelmet;
import RPG.model.Items.items.weapons.weapons.Sword;

import java.util.HashMap;

public class MonsterEquipment {


    HashMap<EquipmentItems, Item> initEquipment(Human human){
        HashMap<EquipmentItems, Item> equipment = new HashMap<>();
        equipment.put(Sword.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), Sword.itemsFactory.createNewItem(human));
        equipment.put(IronHelmet.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronHelmet.itemsFactory.createNewItem(human));
        equipment.put(IronChest.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronChest.itemsFactory.createNewItem(human));
        equipment.put(IronBoots.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronBoots.itemsFactory.createNewItem(human));
        return equipment;
    }

    public static MonsterEquipmentFactory monsterEquipmentFactory = new MonsterEquipment()::initEquipment;
}
