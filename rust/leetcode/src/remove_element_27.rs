fn main() {
    println!("Hello, world!");
}

pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
    let mut count = 0;
    let mut point = 0;
    let mut remove = false;
    for i in 0 .. nums.len() {
        if nums[i] == val {
            count = count + 1;
            if !remove {
                point = i;
            }
            remove = true;

        } else if remove {
            nums[point] = nums[i];
            point = point + 1;
        }
    }
    return nums.len() as i32 - count;
}


