package leetcode;

public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int placeNum = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            int rightPos = i + 1;
            int leftPos = i - 1;
            boolean rightPlace = rightPos >= flowerbed.length || flowerbed[rightPos] == 0;
            boolean leftPlace = leftPos < 0 || flowerbed[leftPos] == 0;

            if (rightPlace && leftPlace && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                placeNum++;
            }
        }

        return placeNum >= n;
    }
}
