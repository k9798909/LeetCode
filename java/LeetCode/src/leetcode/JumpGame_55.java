package leetcode;

public class JumpGame_55 {
	//dp
	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (nums[0] >= nums.length - 1) {
			return true;
		}
		boolean[] isCanJump = new boolean[len];
		isCanJump[len - 1] = true;
		for (int i = len - 2; 0 <= i; i--) {
			int jump = nums[i];
			for (int j = 0; j < jump; j++) {
				if (i + j >= len || isCanJump[i + j + 1]) {
					isCanJump[i] = true;
					break;
				}
			}
		}
		return isCanJump[0];
	}
	
	//貪婪演算 超越值=len-1 如果最大跳躍可以大於等於超越值，將此值設定成要超越的對象，如果跑完最大超越值等於0則代表可以跑完
	public boolean canJump2(int[] nums) {
		int len = nums.length;
		int cross = len-1;
		for (int i = len - 2; 0 <= i; i--) {
			if (cross <= i + nums[i]) {
				cross = i;
			}
		}
		return cross == 0;
	}
	
}
