package RPG.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUniqueValue {

    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();

    public RandomUniqueValue(){
    }

    public int nextUniqueInt(){
        int value;
        while (true){
            value = random.nextInt(10000);
            if (!list.isEmpty()) {
                if (!list.contains(value)) {
                    list.add(value);
                    break;
                }
            } else {
                list.add(value);
                break;
            }
        }
        return value;
    }
}
