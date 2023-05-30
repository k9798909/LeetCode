pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
    let mut ans: Vec<i32> = Vec::new();
    let mut x_start = 0;
    let mut x_end = matrix[0].len();
    let mut y_start = 0;
    let mut y_end: usize = matrix.len();

    while x_start < x_end && y_start < y_end {
        
        for i in x_start..x_end {
            ans.push(matrix[y_start][i]);
        }

        for i in y_start + 1..y_end {
            ans.push(matrix[i][x_end - 1]);
        }

        if y_end - y_start != 1 {
            for i in (x_start..x_end - 1).rev() {
                ans.push(matrix[y_end - 1][i]);
            }
        }

        if x_end - x_start != 1 {
            for i in (y_start + 1..y_end - 1).rev() {
                ans.push(matrix[i][x_start]);
            }
        }

        x_start += 1;
        x_end -= 1;
        y_start += 1;
        y_end -= 1;
    }

    ans
}
