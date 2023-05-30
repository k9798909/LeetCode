struct Solution {}

impl Solution {
    pub fn climb_stairs(n: i32) -> i32 {
        match n {
            1 => return 1,
            2 => return 2,
            _ => {
                let mut vec = vec![0; n as usize];
                vec[0] = 1;
                vec[1] = 2;
                for i in 2..vec.len() {
                    vec[i] = vec[i - 1] + vec[i - 2];
                }
                return *vec.last().unwrap();
            }
        }
    }
}
