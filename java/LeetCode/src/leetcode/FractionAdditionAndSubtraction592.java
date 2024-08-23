package leetcode;

/**
 * Given a string expression representing an expression of fraction addition and
 * subtraction, return the calculation result in string format.
 * 
 * The final result should be an irreducible fraction. If your final result is
 * an integer, change it to the format of a fraction that has a denominator 1.
 * So in this case, 2 should be converted to 2/1.
 */
public class FractionAdditionAndSubtraction592 {

    public String fractionAddition(String expression) {
        if (expression.charAt(0) != '-' && expression.charAt(0) != '+') {
            expression = "+" + expression;
        }

        // 分子、分母、擷取字串的開始
        int numerator = 0, denominator = 0, beg = 0;
        char[] chars = expression.toCharArray();

        for (int i = 1; i < chars.length; i++) {
            String numString = null;
            if (chars[i] == '+' || chars[i] == '-') {
                numString = expression.substring(beg, i);
                beg = i;
            } else if (i == chars.length - 1) {
                numString = expression.substring(beg, i + 1);
            } else {
                continue;
            }

            if (numerator == 0 && denominator == 0) {
                char operation = numString.charAt(0);
                String[] split = numString.substring(1).split("/");
                numerator = operation == '+' ? Integer.parseInt(split[0]) : -Integer.parseInt(split[0]);
                denominator = Integer.parseInt(split[1]);
                continue;
            }

            char operation = numString.charAt(0);
            String[] split = numString.substring(1).split("/");

            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);

            if (operation == '+') {
                numerator = numerator * b + a * denominator;
            } else {
                numerator = numerator * b - a * denominator;
            }

            denominator = denominator * b;
        }

        if (numerator == 0) {
            denominator = 1;
        } else {
            int gcd = GCD(Math.abs(numerator), denominator);
            numerator = numerator / gcd;
            denominator = denominator / gcd;
        }

        return String.format("%d/%d", numerator, denominator);
    }

    /**
     * 找到最大公因數，輾轉相除法
     * 
     * @param a
     * @param b
     * @return
     */
    private int GCD(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int remainder = max % min;
        return remainder == 0 ? min : GCD(min, remainder);
    }
}