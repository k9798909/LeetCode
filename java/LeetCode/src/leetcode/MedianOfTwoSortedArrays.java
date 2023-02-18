package leetcode;

public class MedianOfTwoSortedArrays {
	public static void main(String[] args) {
//		int[] nums1 = new int[] { 1, 2 };
//		int[] nums2 = new int[] { 3, 4 };
//		int[] nums1 = new int[] { 2, 2, 4, 4 };
//		int[] nums2 = new int[] { 2, 2, 4, 4 };
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2 };

		System.out.println(findMedianSortedArrays2(nums1, nums2));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] nums3 = new int[nums1.length + nums2.length];
		int nums1Length = 0;
		int nums2Length = 0;

		for (int i = 0; i < nums3.length; i++) {
			if (nums1.length == nums1Length) {
				nums3[i] = nums2[nums2Length++];
			} else if(nums2.length == nums2Length) {
				nums3[i] = nums1[nums1Length++];
			} else if(nums1[nums1Length] < nums2[nums2Length]) {
				nums3[i] = nums1[nums1Length++];
			} else if(nums1[nums1Length] >= nums2[nums2Length]) {
				nums3[i] = nums2[nums2Length++];
			}
		}

		int middle = ((nums3.length) / 2) - 1;
		if ((nums3.length) % 2 == 0) {
			return (nums3[middle] + nums3[middle + 1]) / 2.0;
		} else {
			return nums3[middle + 1];
		}

	}
	
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		int maxLength = ((nums1.length + nums2.length) / 2) + 1;
		int[] nums3 = new int[maxLength];
		int nums1Length = 0;
		int nums2Length = 0;

		for (int i = 0; i < maxLength; i++) {
			if (nums1.length == nums1Length) {
				nums3[i] = nums2[nums2Length++];
			} else if(nums2.length == nums2Length) {
				nums3[i] = nums1[nums1Length++];
			} else if(nums1[nums1Length] < nums2[nums2Length]) {
				nums3[i] = nums1[nums1Length++];
			} else if(nums1[nums1Length] >= nums2[nums2Length]) {
				nums3[i] = nums2[nums2Length++];
			}
		}
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			return (nums3[maxLength - 1] + nums3[maxLength - 2]) / 2.0;
		} else {
			return nums3[maxLength - 1];
		}
		
		
	}
	

}
