pub fn search_matrix(matrix: Vec<Vec<i32>>, target: i32) -> bool {
    for x_vec in matrix {
        if target <= x_vec[x_vec.len() - 1] {
            return x_vec.contains(&target);
        }
    }
    false
}
