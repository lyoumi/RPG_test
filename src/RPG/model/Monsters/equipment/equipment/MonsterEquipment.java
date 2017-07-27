package RPG.model.Monsters.equipment.equipment;

import RPG.model.Characters.Human;
import RPG.model.Items.EquipmentItems;
import RPG.model.Items.items.HealingItems;
import RPG.model.Items.items.Item;
import RPG.model.Items.items.armors.armors.IronChest;
import RPG.model.Items.items.armors.boots.IronBoots;
import RPG.model.Items.items.armors.helmets.IronHelmet;
import RPG.model.Items.items.heal.SmallHPBottle;
import RPG.model.Items.items.heal.healHitPoint.BigHPBottle;
import RPG.model.Items.items.heal.healHitPoint.MiddleHPBottle;
import RPG.model.Items.items.heal.healManaPoint.BigFlower;
import RPG.model.Items.items.heal.healManaPoint.MiddleFlower;
import RPG.model.Items.items.heal.healManaPoint.SmallFlower;
import RPG.model.Items.items.weapons.weapons.Bow;
import RPG.model.Items.items.weapons.weapons.LegendaryArcherBow;
import RPG.model.Items.items.weapons.weapons.Sword;
import RPG.model.Monsters.equipment.MonsterEquipmentFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class MonsterEquipment {

    private Random random = new Random();

    public HashMap<EquipmentItems, Item> initEquipment(Human human){
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

    public List<HealingItems> initializeItemList(){
        List<HealingItems> itemsList = new ArrayList<>();
        itemsList.add(BigHPBottle.healingItemsFactory.getHealingItem());
        itemsList.add(BigFlower.healingItemsFactory.getHealingItem());
        itemsList.add(MiddleHPBottle.healingItemsFactory.getHealingItem());
        itemsList.add(MiddleFlower.healingItemsFactory.getHealingItem());
        itemsList.add(SmallHPBottle.healingItemsFactory.getHealingItem());
        itemsList.add(SmallFlower.healingItemsFactory.getHealingItem());

        return  itemsList;
    }

    public static MonsterEquipmentFactory monsterEquipmentFactory = MonsterEquipment::new;
}
