package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given the root of a binary tree and an integer targetSum,
 * 
 * return the number of paths where the sum of the values along the path equals
 * targetSum.
 * 
 * The path does not need to start or end at the root or a leaf, but it must go
 * downwards (i.e., traveling only from parent nodes to child nodes).
 * 
 */
public class PathSumIII437 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        // Prefix Sum with Hash Map
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);

        return dps(root, 0L, targetSum, map);
    }

    private int dps(TreeNode root, long sum, int targetSum, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }

        sum = sum + root.val;
        int cnt = map.getOrDefault(sum - targetSum, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        cnt += dps(root.left, sum, targetSum, map);
        cnt += dps(root.right, sum, targetSum, map);
        map.put(sum, map.getOrDefault(sum, 0) - 1);
        return cnt;
    }

}
