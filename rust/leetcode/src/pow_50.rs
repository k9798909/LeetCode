struct Solution {}

impl Solution {
    pub fn my_pow(x: f64, n: i32) -> f64 {
        let mut x = x;
        let mut sum = 1.0;
        let mut cnt = i64::from(n).abs();
        
        while cnt > 0 {
            if cnt % 2 != 0 {
                sum *= x;
                cnt -= 1;
            } else {
                cnt /= 2;
                x *= x;
            }
        }
        if 0 > n {
            sum = 1.0 / sum;
        }

        return sum;
    }
}
