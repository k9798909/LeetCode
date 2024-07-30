pub fn jump(nums: Vec<i32>) -> i32 {
    let mut cnt = 0;
    let mut start = 0;
    //用區間來做運算，第一個能跳到的點來當區間，再以區間內能跳到最遠距離的來當下一個區間開頭，最後一個不算需-1
    while start < nums.len() - 1 {
        //區間結束，因陣列重0開始故結束須加1，例 [1,1,1] end = 1 如果不加1以下for會跑不到idx 1 的。
        let end = start + (nums[start] + 1) as usize;

        //當end >= nums.len()代表可以跳到最後一個，cnt+1後直接結束。
        if end >= nums.len() {
            cnt += 1;
            break;
        }
        
        //max_jump_idx=此組跳到最大的idx;max_idx=此組能夠跳到最大的idx的idx;jump_idx=此次跳到的idx;
        let mut max_jump_idx = 0;
        let mut max_idx = 0;
        for i in start + 1..end {
            let jump_idx = i + nums[i] as usize;
            if max_jump_idx < jump_idx {
                max_jump_idx = jump_idx;
                max_idx = i;
            }
        }
        start = max_idx;
        cnt += 1;
    }
    return cnt;
}

fn main() {
    println!("Hello, world!");
}
