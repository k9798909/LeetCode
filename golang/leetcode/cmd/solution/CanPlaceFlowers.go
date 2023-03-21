package solution

func CanPlaceFlowers(flowerbed []int, n int) bool {
	cnt := 0
	len := len(flowerbed)
	for i := 0; i < len && cnt < len; i++ {
		i1 := i - 1
		i3 := i + 1

		if i1 < 0 && i3 >= len {
			i3 = i
			i1 = i
		} else if i1 < 0 {
			i1 = i3
		} else if i3 >= len {
			i3 = i1
		}

		if flowerbed[i1] == 0 && flowerbed[i1] == flowerbed[i3] && flowerbed[i1] == flowerbed[i] {
			cnt++
			if flowerbed[i] == 0 {
				flowerbed[i] = 1
			} else {
				flowerbed[i] = 0
			}
		}
		i++
	}
	return cnt >= n
}
