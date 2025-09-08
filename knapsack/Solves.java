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

    public static int backpackPD (int n, int c, ArrayList<MyObj> itens) {
        // n = numero de itens
        // c = capacidade da mochila
        int[][] maxTab = new int[n+1][c+1];
        instructions++;
        for (int i = 0; i < n+1; i++) {
            iterations++;
            maxTab[i][0] = 0;
            instructions++;
        }
        for (int j = 0; j < c+1; j++) {
            iterations++;
            maxTab[0][j] = 0;
            instructions++;
        }

        instructions++;
        for (int i  = 1; i <= n; i++) {
            instructions += 2;
            iterations++;

            instructions++;
            for (int j = 1; j <= c; j++) {
                iterations++;
                instructions += 2;

                instructions += 4;
                if (itens.get(i-1).getWeight() <= j) {
                    maxTab[i][j] = Math.max(
                        maxTab[i-1][j],
                        itens.get(i-1).getValue() + maxTab[i-1][j - itens.get(i-1).getWeight()]
                        );
                    instructions += 13;
                } else {
                    maxTab[i][j] = maxTab[i-1][j];
                    instructions += 3;
                }
            }
        }
        
        instructions += 2;
        return maxTab[n][c];
    }
}
