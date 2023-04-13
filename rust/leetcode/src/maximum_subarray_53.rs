// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6       
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

//如果是負得直接比大小就好了並將sum設置為0。
use std::cmp;
pub fn max_sub_array(nums: Vec<i32>) -> i32 {
    let mut ans = i32::MIN;
    let mut sum = 0;
    for num in nums {
        if 0 > sum {
            sum = 0;
        }
        sum += num;
        ans = cmp::max(sum, ans);
    }
    ans
}
