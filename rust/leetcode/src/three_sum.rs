fn main() {
    let vec: Vec<i32> = [-4, -1, -1, 0, 1, 2].to_vec();
    println!("Hello, world!{:?}", three_sum(vec));
}

pub fn three_sum(nums: Vec<i32>) -> Vec<Vec<i32>> {
    let mut nums = nums;
    nums.sort();

    let mut vec: Vec<Vec<i32>> = Vec::new();

    if nums.len() < 3 {
        return vec;
    }

    let mut i = 0;
    while i < nums.len() - 2 {
        let mut j = i + 1;
        let mut k = nums.len() - 1;
        while j < k {
            let sum = nums[i] + nums[j] + nums[k];

            if sum == 0 {
                vec.push(vec![nums[i], nums[j], nums[k]]);
                j += 1;
                while j < k && nums[j] == nums[j - 1] {
                    j += 1;
                }
                k -= 1;
                while j < k && nums[k] == nums[k + 1] {
                    k -= 1;
                }
            } else if sum > 0 {
                k -= 1;
                while j < k && nums[k] == nums[k + 1] {
                    k -= 1;
                }
            } else if sum < 0 {
                j += 1;
                while j < k && nums[j] == nums[j - 1] {
                    j += 1;
                }
            }
        }
        i += 1;

        while i < nums.len() && nums[i - 1] == nums[i] {
            i += 1;
        }
    }
    vec
}
