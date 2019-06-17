package string;

import java.util.Stack;

public class RemoveOutermostParentheses {

	public static String removeOuterParentheses_usingStack(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		int remain = 0;
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '(') {
				stack.push(c);
			}

			if (c == ')') {
				while (stack.size() > 1) {
					remain++;
					result.append(stack.pop());
				}

				if (remain > 0) {
					result.append(c);
					remain--;
				} else if (stack.size() == 1) {
					stack.pop();
				}
			}
		}

		return result.toString();
	}

	public static String removeOuterParentheses(String S) {
		StringBuilder result = new StringBuilder();
		int opened = 0;
		char[] c = S.toCharArray();
		for (char value : c) {
			if (value == '(' && opened++ > 0) {
				result.append(value);
			}
			if (value == ')' && opened-- > 1) {
				result.append(value);
			}
		}

		return result.toString();
	}


	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses("()()"));
		System.out.println(removeOuterParentheses("((()())(()()))"));
	}
}
