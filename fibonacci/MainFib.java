package fibonacci;

import java.util.ArrayList;

public class MainFib {
    public static void main(String[] args) {
        int[] arr = {4, 8, 16, 32};
        for (int i : arr)
            System.out.printf("fibo_rec(%d): %d, iteracoes = %d, instrucoes = %d\n",
            i, Solves.fibo_rec(i), Solves.iterations, Solves.instructions);
        System.out.println();
        Solves.resetCounters();
        for (int i : arr)
            System.out.printf("fibo(%d): %d, iteracoes = %d, instrucoes = %d\n",
            i, Solves.fibo(i), Solves.iterations, Solves.instructions);
        System.out.println();
        Solves.resetCounters();
        for (int i : arr) 
            System.out.printf("memoized_fibo(%d): %d, iteracoes = %d, instrucoes = %d\n",
            i, Solves.memoized_fibo(new ArrayList<Integer>(), i), Solves.iterations, Solves.instructions);
    }
}
