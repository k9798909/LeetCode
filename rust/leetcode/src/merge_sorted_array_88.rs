pub fn merge(nums1: &mut Vec<i32>, m: i32, nums2: &mut Vec<i32>, n: i32) {
    let mut nums3: Vec<i32> = vec![];

    for i in 0..m as usize {
        nums3.push(nums1[i]);
    }

    let mut nums2_i = 0;
    let mut nums3_i = 0;
    for i in 0..nums1.len() {
        if nums2_i >= nums2.len() {
            nums1[i] = nums3[nums3_i];
            nums3_i += 1;
        } else if nums3_i >= nums3.len() {
            nums1[i] = nums2[nums2_i];
            nums2_i += 1;
        } else if nums2[nums2_i] <= nums3[nums3_i] {
            nums1[i] = nums2[nums2_i];
            nums2_i += 1;
        } else if nums2[nums2_i] > nums3[nums3_i] {
            nums1[i] = nums3[nums3_i];
            nums3_i += 1;
        }
    }
}
