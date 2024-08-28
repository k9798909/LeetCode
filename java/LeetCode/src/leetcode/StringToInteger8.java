package leetcode;

public class StringToInteger8 {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        char fc = s.charAt(0);
        int negative = fc == '-' ? -1 : 1;
        if (fc == '-' || fc == '+') {
            s = s.substring(1);
        }

        char[] arr = s.toCharArray();
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int ci = (int) arr[i];
            if (ci >= 48 && ci <= 57) {
                sum = sum * 10 + ((ci - 48) * negative);
                if (Integer.MAX_VALUE <= sum) {
                    return Integer.MAX_VALUE;
                }

                if (Integer.MIN_VALUE >= sum) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        return (int) sum;
    }
}
