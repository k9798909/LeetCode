package leetcode;

import java.util.Stack;

public class SimplifyPath71 {
	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] split = path.split("/");
		for (String str : split) {
			if (".".equals(str) || str.isBlank()) {
				continue;
			}
			if ("..".equals(str)) {
				if (!stack.isEmpty()) {
					stack.pop();	
				} 
				continue;
			}
			stack.push(str);
		}
		
		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty()) {
			sb.append("/");
		} else {
			for (String str : stack) {
				sb.append("/");
				sb.append(str);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(simplifyPath("/../..ga/b/.f..d/..../e.baaeeh./.a"));
		
	}
}
