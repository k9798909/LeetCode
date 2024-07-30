package leetcode;

/**
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
 * 
 * Search for a node to remove.
 * If the node is found, delete the node.
 * 
 * BST 是 Binary Search Tree（二元搜尋樹）的縮寫。它是一種特殊的二元樹結構，具有以下特性：
 * 
 * 每個節點最多有兩個子節點：稱為左子節點和右子節點。
 * 左子節點的值小於根節點的值：即所有左子樹中的節點值都小於其父節點的值。
 * 右子節點的值大於根節點的值：即所有右子樹中的節點值都大於其父節點的值。
 * 每個節點的左右子樹也是二元搜尋樹：即這些特性在整個樹中都成立。
 */
public class DeleteNodeInABST450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val == key) {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 找到右子樹的最小節點
                TreeNode tempNode = root.right;
                while (tempNode.left != null) {
                    tempNode = tempNode.left;
                }

                deleteNode(root, tempNode.val);
                tempNode.right = root.right;
                tempNode.left = root.left;
                return tempNode;
            }
        }

        return root;

    }

}
