package levenshtein;

public class Solves {
    public static long iterations = 0;
    public static long instructions = 0;
    
    public static void resetCounters() {
        iterations = 0;
        instructions = 0;
    }

    public static int bruteforce(String from, String to) {
        // i = [0..m), where m = from.length()
        // j = [0..n), where n = to.length()

        return bruteforceRec(from, to, 0, 0);
    }

    private static int bruteforceRec(String from, String to, int i, int j) {
        iterations++;

        // base cases
        if (i >= from.length() && j >= to.length()) {
            instructions += 6;
            return 0;
        }
        else if (i >= from.length()) {
            instructions += 10;
            return to.length() - j;
        }
        else if (j >= to.length()) {
            instructions += 12;
            return from.length() - i;
        }
        
        // recursive cases

        // match
        if (from.charAt(i) == to.charAt(j)) {
            instructions += 7;
            return bruteforceRec(from, to, i + 1, j + 1);
        }

        instructions += 3;
        
        // substitution
        int substitution = 1 + bruteforceRec(from, to, i + 1, j + 1);
        // insertion
        int insertion = 1 + bruteforceRec(from, to, i, j + 1);
        // deletion
        int deletion = 1 + bruteforceRec(from, to, i + 1, j);

        instructions += 13;
        
        // return minimum of the three
        instructions += 3;
        return Math.min(substitution, Math.min(insertion, deletion));
    }

    public static int distEdProgDina(String from, String to) {
        int m = from.length();
        int n = to.length();
        instructions += 4;

        int[][] table = new int[m + 1][n + 1];
        instructions += 4;

        instructions ++;
        for (int i = 0; i < m; i++) {
            iterations++;
            table[i][0] = 0;
            instructions += 3;
        }

        instructions ++;
        for (int j = 0; j < n; j++) {
            iterations++;
            table[0][j] = 0;
            instructions += 3;
        }

        instructions ++;
        for (int i = 1; i <= m; i++) {
            iterations++;
            table[i][0] = table[i - 1][0] + 1;
            instructions += 5;
        }

        instructions ++;
        for (int j = 1; j <= n; j++) {
            iterations++;
            table[0][j] = table[0][j - 1] + 1;
            instructions += 5;
        }

        int extraCost;

        instructions ++;
        for (int i = 1; i <= m; i++) {
            iterations++;
            instructions ++;
            for (int j = 1; j <= n; j++) {
                iterations++;
                instructions += 2;
                if (from.charAt(i - 1) == to.charAt(j - 1)) {
                    instructions += 6;
                    extraCost = 0; // match
                } else {
                    instructions += 7;
                    extraCost = 1; // substitution
                }

                instructions += 9;
                table[i][j] = Math.min(table[i-1][j] + 1,
                                   Math.min(table[i][j-1] + 1,
                                            table[i-1][j-1] + extraCost));
            }
        }

        instructions ++;
        return table[m][n];
    }

}
