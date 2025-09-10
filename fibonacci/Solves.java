package fibonacci;

import java.util.ArrayList;

public class Solves {
    public static int iterations = 0;
    public static int instructions = 0;

    public static void resetCounters() {
        iterations = 0;
        instructions = 0;
    }

    public static int fibo_rec(int n) {
        iterations++;

        instructions++;
        if (n <= 1) {
            instructions++;
            return n;
        }

        int a = fibo_rec(n-1);
        instructions += 3;
        int b = fibo_rec(n-2);
        instructions += 3;

        instructions += 2;
        return a+b;
    }

    public static int fibo(int n) {
        ArrayList<Integer> al = new ArrayList<>();
        instructions++;

        al.add(0);
        instructions++;
        al.add(1);
        instructions++;

        instructions++;
        for (int i = 2; i <= n; i++) {
            instructions += 2;
            iterations++;
            al.add(al.get(i-1) + al.get(i-2));
            instructions += 6;
        }

        instructions += 2;
        return al.getLast();
    }

    public static int memoized_fibo (ArrayList<Integer> al, int n) {
        instructions ++;
        for (int i = 0; i <= n; i++) {
            iterations++;
            instructions += 2;
            al.add(-1);
            instructions++;
        }

        instructions += 2;
        return lookup_fibo(al, n);
    }

    public static int lookup_fibo (ArrayList<Integer> al, int n) {
        iterations++;
        instructions++;
        if (al.get(n) >= 0) {
            instructions += 2;
            return al.get(n);
        }

        instructions++;
        if (n <= 1) {
            instructions ++;
            al.set(n, n);
        }
        else {
            al.set(n, lookup_fibo(al, n - 1) + lookup_fibo(al, n - 2));
            instructions += 6;
        }

        instructions += 2;
        return al.get(n);
    }
}
