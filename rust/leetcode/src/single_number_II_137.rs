use std::collections::HashMap;

pub fn single_number(nums: Vec<i32>) -> i32 {
    let mut map = HashMap::new();
    for num in nums {
        if map.contains_key(&num) {
            map.insert(num, false);
        } else {
            map.insert(num, true);
        }
    }

    for (key, value) in map.iter() {
        if *value {
            return *key;
        }
    }

    return 0;
}
