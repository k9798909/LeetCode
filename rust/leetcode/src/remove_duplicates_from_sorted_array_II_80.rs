pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
    let cur_num = nums.get(0);

    if cur_num.is_none() {
        return 0;
    }

    let mut cur_num = *cur_num.unwrap();
    let mut cnt = 0;
    let mut len = nums.len();
    let mut i = 0;
    while i < len {
        let num = nums[i];

        if num == cur_num {
            if cnt == 2 {
                nums.remove(i);
                i -= 1;
                len -= 1;
            } else {
                cnt += 1;
            }
        } else {
            cur_num = num;
            cnt = 1;
        }

        i += 1;
    }

    return nums.len() as i32;
}
