package knapsack;

import java.util.ArrayList;

public class Solves {
    public static int bruteforce (ArrayList<MyObj> items, MyBackpack backpack, int index) {
        if (index == items.size()) {
            return 0;
        }

        MyObj current = items.get(index);

        int maxValue = bruteforce(items, backpack, index + 1);

        if (backpack.add(current.getWeight()) != -1) {
            int valueWithItem = current.getValue() + bruteforce(items, backpack, index + 1);
            
            if (valueWithItem > maxValue) maxValue = valueWithItem;
            backpack.remove(current.getWeight());
        }

        return maxValue;
    }
}
