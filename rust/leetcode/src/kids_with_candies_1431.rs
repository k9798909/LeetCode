
pub fn kids_with_candies(candies: Vec<i32>, extra_candies: i32) -> Vec<bool> {
    let len = candies.len();
    let mut result = vec![false; len];
    let mut max_candie = 0;
    for &candie in candies.iter() {
        if max_candie < candie {
            max_candie = candie;
        }
    }

    for i in 0..len {
        result[i] = max_candie <= candies[i] + extra_candies;
    }

    result
}
