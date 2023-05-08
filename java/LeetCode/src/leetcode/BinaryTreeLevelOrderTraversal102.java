package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
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

	public static class LevelTreeNode {
		int level;
		TreeNode treeNode;

		public LevelTreeNode(int level, TreeNode treeNode) {
			super();
			this.level = level;
			this.treeNode = treeNode;
		}
	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> rtnList = new ArrayList<>();
		
		if (root == null) {
			return rtnList;
		}
		
		Queue<LevelTreeNode> queue = new LinkedList<>();
		queue.add(new LevelTreeNode(1, root));
		int lastlyLevel = 0;
		while (!queue.isEmpty()) {
			LevelTreeNode levelTreeNode = queue.poll();

			if (lastlyLevel != levelTreeNode.level) {
				rtnList.add(new ArrayList<>());
				lastlyLevel++;
			}

			rtnList.get(rtnList.size() - 1).add(levelTreeNode.treeNode.val);

			if (levelTreeNode.treeNode.left != null) {
				queue.add(new LevelTreeNode(levelTreeNode.level + 1, levelTreeNode.treeNode.left));
			}

			if (levelTreeNode.treeNode.right != null) {
				queue.add(new LevelTreeNode(levelTreeNode.level + 1, levelTreeNode.treeNode.right));
			}
		}

		return rtnList;
	}
}
