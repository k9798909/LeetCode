package leetcode;

import java.util.*;

/**
 * Given a 0-indexed n x n integer matrix grid,
 * <p>
 * return the number of pairs (ri, cj) such that row ri and column cj are equal.
 * <p>
 * A row and column pair is considered equal
 * <p>
 * if they contain the same elements in the same order (i.e., an equal array).
 * <p>
 * 給定一個 0 索引的 n x n 整數矩陣網格，傳回行 ri 和列 cj 相等的對 (ri, cj) 的數量。
 * <p>
 * 如果行和列對包含相同順序的相同元素（即相等的陣列），則它們被視為相等。
 *
 */
public class EqualRowAndColumnPairs2352 {

    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            String rowsStr = arrayToString(grid[i]);
            rows.put(rowsStr, rows.getOrDefault(rowsStr, 0) + 1);
        }
        int cnt = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int[] cols = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                cols[j] = grid[j][i];
            }
            String colsStr = arrayToString(cols);
            if (rows.containsKey(colsStr)) {
                cnt += rows.get(colsStr);
            }
        }
        return cnt;
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }
}
