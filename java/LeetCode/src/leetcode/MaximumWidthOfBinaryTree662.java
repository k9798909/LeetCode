package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree662 {

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

	public class MyTreeNode {
		int index;
		int level;
		TreeNode treeNode;

		public MyTreeNode(int index, int level, TreeNode treeNode) {
			this.level = level;
			this.index = index;
			this.treeNode = treeNode;
		}
	}

	/**
	 * <p>
	 * 用bfs一層一層去找
	 * </p>
	 * <p>
	 * index 算法 左:node * 2 右:node * 2 + 1
	 * </p>
	 * <p>
	 * 用nowLevel及node的nodeLevel是否換層了
	 * </p>
	 * <p>
	 * 距離是end - start + 1
	 * </p>
	 * 
	 * @param root
	 * @return
	 */
	public int widthOfBinaryTree(TreeNode root) {
		int start = 0;
		int end = 0;
		int nowLevel = 1;
		int maxLength = 1;
		Queue<MyTreeNode> queue = new LinkedList<>();
		queue.add(new MyTreeNode(1, 1, root));
		while (!queue.isEmpty()) {
			MyTreeNode node = queue.poll();
			if (nowLevel != node.level) {
				maxLength = Math.max(end - start + 1, maxLength);
				start = 0;
				end = 0;
				nowLevel = node.level;
			}

			if (node.treeNode.left != null) {
				queue.add(new MyTreeNode(node.index * 2, node.level + 1, node.treeNode.left));

				if (start == 0) {
					start = node.index * 2;
				}

				end = node.index * 2;
			}

			if (node.treeNode.right != null) {
				queue.add(new MyTreeNode(node.index * 2 + 1, node.level + 1, node.treeNode.right));

				if (start == 0) {
					start = node.index * 2 + 1;
				}

				end = node.index * 2 + 1;
			}

		}

		return maxLength;
	}

}
