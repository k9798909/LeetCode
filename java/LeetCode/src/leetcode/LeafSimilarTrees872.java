package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeafSimilarTrees872 {

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


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList<>();
        List<Integer> root2List = new ArrayList<>();
        dps(root1List,root1);
        dps(root2List,root2);
        root1List.stream().forEach(System.out::println);
        root2List.stream().forEach(System.out::println);
        return root1List.equals(root2List);
    }


    public void dps(List<Integer> list, TreeNode root) {
        if (root.left != null) {
            dps(list, root.left);
        }

        if (root.right != null) {
            dps(list, root.right);
        }

        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }


}
