package leetcode;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path
 * from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
 *
 */
public class CountGoodNodesInBinaryTree1448 {

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

    int cnt = 0;

    public int goodNodes(TreeNode root) {
        dps(root, root.val);
        return cnt;
    }

    public void dps(TreeNode root, int maxNum) {
        if (root.val >= maxNum) {
            cnt++;
            maxNum = root.val;
        }

        if (root.left != null) {
            dps(root.left, maxNum);
        }

        if (root.right != null) {
            dps(root.right, maxNum);
        }
    }
}
