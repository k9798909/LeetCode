fn main() {
    println!("Hello, world!");
}

pub fn search_insert(nums: Vec<i32>, target: i32) -> i32 {
    for i in 0..nums.len() {
        if nums[i] >= target {
            return i as i32;
        }
    }
    nums.len() as i32
}
