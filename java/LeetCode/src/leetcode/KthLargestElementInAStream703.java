package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream703 {
	static class KthLargest {
		Queue<Integer> queue = new PriorityQueue<>();
		int k;

		public KthLargest(int k, int[] nums) {
			for (int i = 0; i < nums.length; i++) {
				queue.add(nums[i]);
			}
			while (queue.size() > k) {
				queue.poll();
			}
			this.k = k;
		}

		public int add(int val) {
			queue.add(val);
			if (queue.size() > k) {
				queue.poll();
			}
			return queue.peek();
		}
	}
}
