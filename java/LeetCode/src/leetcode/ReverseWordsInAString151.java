package leetcode;

public class ReverseWordsInAString151 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].trim().isEmpty()) {
                sb.append(" ");
                sb.append(words[i]);
            }
        }
        sb.delete(0,1);
        return sb.toString();
    }
}
