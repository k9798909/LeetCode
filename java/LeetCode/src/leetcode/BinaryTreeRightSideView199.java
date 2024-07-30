package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView199 {
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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(1);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int level = levels.poll();

            if (levels.peek() == null || levels.peek() > level){
                result.add(node.val);
            }

            if (node.left != null) {
                queue.add(node.left);
                levels.add(level + 1);
            }

            if (node.right != null) {
                queue.add(node.right);
                levels.add(level + 1);
            }
        }

        return result;
    }

}
