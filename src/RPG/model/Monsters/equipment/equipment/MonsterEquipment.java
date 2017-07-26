package RPG.model.Monsters.equipment.equipment;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.armors.IronChest;
import RPG.model.Items.items.armors.boots.IronBoots;
import RPG.model.Items.items.armors.helmets.IronHelmet;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.Items.items.weapons.weapons.LegendaryArcherBow;
import RPG.model.Items.items.weapons.weapons.Sword;
import RPG.model.Monsters.equipment.MonsterEquipmentFactory;

import java.util.HashMap;
import java.util.Random;

public class MonsterEquipment {

    private Random random = new Random();

    HashMap<EquipmentItems, Item> initEquipment(Human human){
        HashMap<EquipmentItems, Item> equipment = new HashMap<>();
        int i = random.nextInt(10);
        if(i == 9)
            equipment.put(Sword.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), LegendaryArcherBow.itemsFactory.createNewItem(human));
        else if ((i > 0) && (i < 3))
            equipment.put(Sword.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), Bow.itemsFactory.createNewItem(human));
        else
            equipment.put(Sword.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), Sword.itemsFactory.createNewItem(human));
        equipment.put(IronHelmet.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronHelmet.itemsFactory.createNewItem(human));
        equipment.put(IronChest.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronChest.itemsFactory.createNewItem(human));
        equipment.put(IronBoots.itemsFactory.createNewItem(human).EQUIPMENT_ITEMS(), IronBoots.itemsFactory.createNewItem(human));
        return equipment;
    }

    public static MonsterEquipmentFactory monsterEquipmentFactory = new MonsterEquipment()::initEquipment;
}
