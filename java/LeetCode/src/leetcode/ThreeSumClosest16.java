package leetcode;

import java.util.Arrays;

public class ThreeSumClosest16 {
    public static int threeSumClosest(int[] nums, int target) {
    	int num = nums[0] + nums[1] + nums[2];
    	for (int i = 0; i < nums.length - 2 ; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = nums[i] + nums[j] + nums[k];
					if (temp == target) {
						return temp;
					}
					
					if (Math.abs(num - target) > Math.abs(temp - target)) {
						num = temp;
					}
				}
			}
		}
        return num;
    }
    
    public static int threeSumClosest2(int[] nums, int target) {
    	Arrays.sort(nums);
    	int num = nums[0] + nums[1] + nums[2];
    	
		for (int i = 0; i < nums.length - 2; i++) {
	    	int j = i + 1;
	    	int k = nums.length - 1;
	    	
	    	while(k > j) {
				int temp = nums[i] + nums[j] + nums[k];
				if (temp == target) {
					return temp;
				}

				if (Math.abs(num - target) > Math.abs(temp - target)) {
					num = temp;
				}
				
				if (temp > target) {
					k--;
				} else if (temp < target) {
					j++;
				}
	    	}
			
		}
        return num;
    }
    
	public static void main(String[] args) {
		System.out.println(threeSumClosest2(new int[] { 4,0,5,-5,3,3,0,-4,-5 }, -2));
	}
    
}
