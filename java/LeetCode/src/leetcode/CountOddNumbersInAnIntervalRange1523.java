package leetcode;

public class CountOddNumbersInAnIntervalRange1523 {
    public int countOdds(int low, int high) {
        int result = low % 2 + high % 2;
        return (high - low - result) / 2 + result;
    }
}
