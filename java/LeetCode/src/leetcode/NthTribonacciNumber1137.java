package leetcode;

/**
 * The Tribonacci sequence Tn is defined as follows:
 * 
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 */
public class NthTribonacciNumber1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int[] sequence = new int[n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        sequence[2] = 1;
        for (int i = 3; i < sequence.length; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2] + sequence[i - 3];
        }
        return sequence[n];
    }
}
