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

        int[][] table = new int[m + 1][n + 1];
        table[0][0] = 0;

        for (int i = 1; i < m; i++) table[i][0] = table[i - 1][0] + 1;
        for (int j = 1; j < n; j++) table[0][j] = table[0][j - 1] + 1;

        int extraCost;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (from.charAt(i) == to.charAt(j)) {
                    extraCost = 0; // match
                } else {
                    extraCost = 1; // substitution
                }

                table[i][j] = Math.min(table[i-1][j] + 1,
                                   Math.min(table[i][j-1] + 1,
                                            table[i-1][j-1] + extraCost));
            }
        }

        return table[m-1][n-1];
    }
}
