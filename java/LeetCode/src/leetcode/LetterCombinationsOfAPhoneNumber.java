package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
	
	
	
    public List<String> letterCombinations(String digits) {
    	Map<Character,String[]> map = new HashMap<>();
		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });
		
		List<String> list = new ArrayList<>();
		for (char c : digits.toCharArray()) {
			//找出符合的字串陣列，第一次的話直接加進list不走下面的遞加
			String[] array = map.get(c);
			if (list.isEmpty()) {
				list.addAll(Arrays.asList(array));
				continue;
			}
			
			//用上一次的結果去遞加，並加進一個新的list
			List<String> tempList = list;
			list = new ArrayList<>();
			for (String s1 : tempList) {
				for (String s2 : array) {
					list.add(s1 + s2);
				}
			}
			
		}
		
		
        return list;
    }
}
