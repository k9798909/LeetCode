pub fn array_sign(nums: Vec<i32>) -> i32 {
    let mut negative_cnt = 0;
    for num in nums {
        if num == 0 {
            return 0;
        } else if num < 0 {
            negative_cnt += 1;
        }
    }

    match negative_cnt % 2 == 0 {
        true => 1,
        false => -1,
    }
}
