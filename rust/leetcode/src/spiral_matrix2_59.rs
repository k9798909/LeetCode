pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
    let len = n as usize;
    let mut ans = vec![vec![0; len]; len];
    let mut x_start = 0;
    let mut x_end = len;
    let mut y_start = 0;
    let mut y_end = len;
    let mut cnt = 1;

    while cnt <= n * n {
        for i in x_start..x_end {
            ans[y_start][i] = cnt;
            cnt += 1;
        }

        for i in y_start + 1..y_end {
            ans[i][x_end - 1] = cnt;
            cnt += 1;
        }

        for i in (x_start..x_end - 1).rev() {
            ans[y_end - 1][i] = cnt;
            cnt += 1;
        }

        for i in (y_start + 1..y_end - 1).rev() {
            ans[i][x_start] = cnt;
            cnt += 1;
        }

        x_start += 1;
        x_end -= 1;
        y_start += 1;
        y_end -= 1;
    }
    ans
}
