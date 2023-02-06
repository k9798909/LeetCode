package leetCode;

public class ContainerWithMostWater {
    public static int maxArea1(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	
    	int r = 0;
    	
    	for (int i = 0; i < height.length; i++) {
    		if (height[i] == 0) {
    			continue;
    		}
    		
    		for (int j = r / height[i] + 1; j < height.length; j++) {
    			int max = Integer.max(height[i],height[j]);
    			int min = Integer.min(height[i],height[j]);
    			if (max >= min) {
    				int t = (j - i) * min;
    				if( r < t ) {
    					r = t;
    				}
    			}
    		}
		}
    	
        return r;
    }
    
    public static int maxArea2(int[] height) {
    	if (height == null || height.length == 0) {
    		return 0;
    	}
    	
    	int r = 0;
    	int i = 0;
    	int j = height.length-1;
    	
		while (i < j) {
			int min = Math.min(height[i], height[j]);
			int t = (j - i) * min;
			if (r < t) {
				r = t;
			}
			
			//比較完大小留下大的一方，因為比較面積不需要看小的一放，慢慢縮小
			if (height[i] >= height[j]) {
				j--;
			} else {
				i++;
			}

		}
    	
        return r;
    }
    

    
    public static void main(String[] args) {
    	System.out.println(maxArea2(new int[] {4,4,2,11,0,11,5,11,13,8}));
	}
}
