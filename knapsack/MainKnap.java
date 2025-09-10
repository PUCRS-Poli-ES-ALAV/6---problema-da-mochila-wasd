package knapsack;

import java.util.ArrayList;

/* 
 * Given a set of items, each with a weight and a value,
 * determine which items to include in the collection so that
 * the total weight is less than or equal to a given limit
 * and the total value is as large as possible.
*/

public class MainKnap {
    public static void main(String[] args) {
        long start;
        System.out.println("Teste 1 - bruteforcing");
        MyBackpack b1 = new MyBackpack(165);
        ArrayList<MyObj> items = new ArrayList<>();
        
        int[] weights = {23, 31, 29, 44, 53, 38, 63, 85, 89, 82};
        int[] values = {92, 57, 49, 68, 60, 43, 67, 84, 87, 72};
        int[] weights2 = {56, 59, 80, 64, 75, 17};
        int[] values2 = {50, 50, 64, 46, 50, 05};

        for (int i = 0; i < weights.length; i++) {
            MyObj item = new MyObj(weights[i], values[i]);
            items.add(item);
        }
        start = System.currentTimeMillis();
        System.out.printf("%d, iteracoes = %d, instrucoes = %d, tempo = %dms\n",
        Solves.bruteforce(items, b1, 0), Solves.iterations, Solves.instructions, System.currentTimeMillis() - start);

        System.out.println("---------------\nTeste 2 - bruteforcing");
        Solves.resetCounters();
        MyBackpack b2 = new MyBackpack(190);
        items.clear();


        for (int i = 0; i < weights2.length; i++) {
            MyObj item = new MyObj(weights2[i], values2[i]);
            items.add(item);
        }

        start = System.currentTimeMillis();
        System.out.printf("%d, iteracoes = %d, instrucoes = %d, tempo = %dms\n",
        Solves.bruteforce(items, b2, 0), Solves.iterations, Solves.instructions, System.currentTimeMillis() - start);






        System.out.println("---------------\nTeste 1 - PD");
        Solves.resetCounters();
        items.clear();
        b1.free();

        for (int i = 0; i < weights.length; i++) {
            MyObj item = new MyObj(weights[i], values[i]);
            items.add(item);
        }

        start = System.currentTimeMillis();
        System.out.printf("%d, iteracoes = %d, instrucoes = %d, tempo = %dms\n",
        Solves.backpackPD(weights.length, b1.getCapacity() , items), Solves.iterations, Solves.instructions, System.currentTimeMillis() - start);

        System.out.println("---------------\nTeste 2 - PD");
        Solves.resetCounters();
        items.clear();
        b2.free();

        for (int i = 0; i < weights2.length; i++) {
            MyObj item = new MyObj(weights2[i], values2[i]);
            items.add(item);
        }

        start = System.currentTimeMillis();
        System.out.printf("%d, iteracoes = %d, instrucoes = %d, tempo = %dms\n",
        Solves.backpackPD(weights2.length, b2.getCapacity(), items), Solves.iterations, Solves.instructions, System.currentTimeMillis() - start);
    }
    
}
