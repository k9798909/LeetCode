package leetcode;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 * 
 * Find the node in the BST that the node's value equals val and return the
 * subtree rooted with that node. If such a node does not exist, return null.
 * 
 * BST 是 Binary Search Tree（二元搜尋樹）的縮寫。它是一種特殊的二元樹結構，具有以下特性：
 * 
 * 每個節點最多有兩個子節點：稱為左子節點和右子節點。
 * 左子節點的值小於根節點的值：即所有左子樹中的節點值都小於其父節點的值。
 * 右子節點的值大於根節點的值：即所有右子樹中的節點值都大於其父節點的值。
 * 每個節點的左右子樹也是二元搜尋樹：即這些特性在整個樹中都成立。
 */
public class SearchInABinarySearchTree700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

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
}