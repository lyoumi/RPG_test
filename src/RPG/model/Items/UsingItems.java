package RPG.model.Items;

import RPG.model.Items.items.HealingItems;

import java.util.List;

/**
 * Created by pikachu on 14.07.17.
 */
public interface UsingItems {
    boolean add(HealingItems item);
    boolean addAll(List<HealingItems> item);
    void use(HealingItems item);
}
