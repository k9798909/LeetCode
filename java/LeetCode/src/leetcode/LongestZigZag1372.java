package leetcode;

public class LongestZigZag1372 {
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

	public int rtn = 0;
	
	//深度優先，root進入左右邊，如果進入左邊時代表下一個進入右邊時，cnt加1，而進入左邊時步數需重新計算，如果下一個節點是null代表已經走完，而cnt代表此ZigZag最大值
	public int longestZigZag(TreeNode root) {
		dps(root, false, 0);
		dps(root, true, 0);
		return rtn;
	}

	public void dps(TreeNode root,boolean isRight,int cnt) {
		if (root == null) {
			return;
		}
		
		if (cnt >= rtn) {
			rtn = cnt;
		}
		
		if (isRight) {
			dps(root.left, false, cnt + 1);
			dps(root.right, true, 1);
		} else {
			dps(root.left, false, 1);
			dps(root.right, true, cnt + 1);
		}
	}

}
