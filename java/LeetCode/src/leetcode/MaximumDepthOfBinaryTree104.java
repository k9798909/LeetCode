package leetcode;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class MaximumDepthOfBinaryTree104 {
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

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftCnt =  maxDepth(root.left) + 1;
		int rightCnt =  maxDepth(root.right) + 1;
		return Math.max(leftCnt, rightCnt);
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 使用 runAsync 方法執行一個沒有返回值的異步操作
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            // 模擬一個耗時的操作
        	System.out.println("異步操作開始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 打印訊息
            System.out.println("異步操作完成");
        });
        Thread.sleep(1000);
        // 程式繼續執行其他操作
        System.out.println("繼續執行其他操作...");

        // 等待異步操作完成
        future.get();
		
	}
}
