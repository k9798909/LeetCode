class Solution(object):
    def __init__(self):
        self.roman = {"I":1,
                      "V": 5,
                      "IV": 4,
                      "IX": 9,
                      "X": 10,
                      "XL": 40,
                      "XC": 90,
                      "L": 50,
                      "C": 100,
                      "CD": 400,
                      "CM": 900,
                      "D": 500,
                      "M": 1000}

        self.sp = ("IV", "IX", "XL", "XC", "CD", "CM")

    def romanToInt(self, s):
        sum = 0
        for sp in self.sp:
            count = s.count(sp)
            for i in range(count):
                sum += self.roman[sp]

            s = s.replace(sp, "")
        for i in range(len(s)):
            sum += self.roman[s[i]]
        return sum


s = Solution()
print(s.romanToInt("MCMXCIV"))
