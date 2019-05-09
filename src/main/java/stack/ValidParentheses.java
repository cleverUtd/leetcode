package stack;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s) {
		char[] input = s.toCharArray();
		Stack<Byte> stack = new Stack<>();
		for (char c : input) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push((byte) c);
			} else if (c == ')') {
				if (stack.isEmpty() || stack.pop() != (byte)'(') return false;
			} else if (c == '}') {
				if (stack.isEmpty() || stack.pop() != (byte)'{') return false;
			} else if (c == ']') {
				if (stack.isEmpty() || stack.pop() != (byte)'[') return false;
			} else {
				return false;
			}
		}

		if (!stack.isEmpty()) return false;
		return true;
	}


	public static boolean isValid_easier_read(String s) {
		Map<Character, Character> characterMap = new HashMap<>();
		characterMap.put(')', '(');
		characterMap.put(']', '[');
		characterMap.put('}', '{');

		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char element = s.charAt(i);

			if (characterMap.containsKey(element)) {
				if (stack.isEmpty() || stack.pop() != characterMap.get(element)) {
					return false;
				}
			} else {
				stack.push(element);
			}
		}

		return stack.isEmpty();
	}


	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("()[]{}"));
		System.out.println(isValid("(["));
		System.out.println(isValid("([)]"));
		System.out.println(isValid("{[]}"));
		System.out.println(isValid("{}}"));
		System.out.println(isValid("{}}"));
		System.out.println(isValid("[[]"));


		System.out.println(isValid_easier_read("()"));
		System.out.println(isValid_easier_read("()[]{}"));
		System.out.println(isValid_easier_read("(["));
		System.out.println(isValid_easier_read("([)]"));
		System.out.println(isValid_easier_read("{[]}"));
		System.out.println(isValid_easier_read("{}}"));
		System.out.println(isValid_easier_read("{}}"));
		System.out.println(isValid_easier_read("[[]"));
	}
}
