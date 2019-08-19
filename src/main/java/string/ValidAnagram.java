package string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();
		char key;
		for (int i = 0; i < s.length(); i++) {
			key = s.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		Integer value;
		for (int i = 0; i < t.length(); i++) {
			key = t.charAt(i);
			value = map.get(key);
			if (value == null || value == 0) {
				return false;
			}

			map.put(key, value - 1);
		}

		return true;
	}

	public static boolean isAnagram_v2(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		int[] counter = new int[26];
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			counter[sCharArray[i] - 'a']++;
			counter[tCharArray[i] - 'a']--;
		}

		for (int c : counter) {
			if (c != 0) {
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args) {
		System.out.println(isAnagram_v2("anagram", "nagaram"));
		System.out.println(isAnagram_v2("rat", "car"));
		System.out.println(isAnagram_v2("ab", "a"));
	}
}
