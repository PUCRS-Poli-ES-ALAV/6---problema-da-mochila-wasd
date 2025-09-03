package knapsack;

import java.util.ArrayList;

public class Solves {
    public static int iterations = 0;
    public static int instructions = 0; 

    public static void resetCounters() {
        iterations = 0;
        instructions = 0;
    }

    public static int bruteforce (ArrayList<MyObj> items, MyBackpack backpack, int index) {
        iterations++;
        instructions += 2;
        if (index == items.size()) {
            instructions++;
            return 0;
        }

        instructions += 3;
        MyObj current = items.get(index);

        instructions += 4;
        int maxValue = bruteforce(items, backpack, index + 1);

        instructions += 3;
        if (backpack.add(current.getWeight()) != -1) {
            instructions += 5;
            int valueWithItem = current.getValue() + bruteforce(items, backpack, index + 1);

            instructions ++;
            if (valueWithItem > maxValue) {
                maxValue = valueWithItem;
                instructions++;
            }

            instructions += 2;
            backpack.remove(current.getWeight());
        }

        instructions ++;
        return maxValue;
    }
}
