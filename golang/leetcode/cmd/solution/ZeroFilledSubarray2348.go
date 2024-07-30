package solution

func ZeroFilledSubarray(nums []int) int64 {
	cnt, total, ans := 0, 0, int64(0)
	for _, num := range nums {
		if num == 0 {
			// 4+3+2+1 3+2+1 2+1 1
			cnt += 1
			total += cnt
		} else {
			ans += int64(total)
			cnt = 0
			total = 0
		}
	}
	ans += int64(total)
	return ans
}
