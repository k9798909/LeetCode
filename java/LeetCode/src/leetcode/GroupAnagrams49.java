package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String,List<String>> map = new HashMap<>();
    	List<List<String>> list = new ArrayList<>();
    	for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
			char[] array = str.toCharArray();
			Arrays.sort(array);
			String sortStr = String.valueOf(array);
			if (map.containsKey(sortStr)) {
				map.get(sortStr).add(str);
			} else {
				List<String> subList = new ArrayList<>();
				subList.add(str);
				map.put(sortStr,subList);
				list.add(subList);
			}
		}
    	return list;
    }
}
