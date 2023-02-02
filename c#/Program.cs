using System;

namespace LeetCode // Note: actual namespace depends on the project name.
{
    internal class Program
    {
        

        static void Main(string[] args)
        {
            Console.WriteLine(MyAtoi("21474836460"));
        }

        public static int MyAtoi(string s)
        {
            s = s.Trim();

            if (s.Length == 0) {
                return 0;
            }

            var fs = s[..1];

            if ("-".Equals(fs) || "+".Equals(fs))
            {
                s = s[1..];

                if (s.Length == 0)
                {
                    return 0;
                }
            }
            else 
            {
                fs = "";
            }

            var arr = s.ToCharArray();
            s = "";
            foreach(var c in arr) 
            {
                var ci = (int)c;
                if (ci >= 48 && ci <= 57)
                {
                    s += c;
                }
                else {
                    if (s.Length == 0) {
                        s = "0";
                    }
                    break;
                }
            }

            double rtnVal = double.Parse(fs + s);

            if (int.MaxValue <= rtnVal) {
                    return int.MaxValue;
            }

            if (int.MinValue >= rtnVal)
            {
                return int.MinValue;
            }

            return (int) rtnVal;
        }

    }
}