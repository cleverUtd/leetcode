package slidingWindow;

import java.util.*;

/**
 * Created by liuzicong on 19/4/2017.
 */
public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		char[] chars = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int maxlen = 0;
		for (int i = 0; i < chars.length; i++) {
			for (int j = i; j < chars.length; j++) {
				if (set.contains(chars[j])) {
					if (set.size() > maxlen) {
						maxlen = set.size();
					}
					set.clear();
					break;
				} else {
					set.add(chars[j]);
					if (set.size() > maxlen) {
						maxlen = set.size();
					}
				}
			}
		}
		return maxlen;
	}

	public static int lengthOfLongestSubstring_optimized(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>(); // 记录字符串当前的最新位置
		int maxLen = 0, i = 0, j = 0;
		while (j < s.length()) {
			if (!map.containsKey(chars[j]) || i > map.get(chars[j])) {
				maxLen = Math.max(maxLen, j - i + 1);
			} else {
				i = Math.max(map.get(chars[j]) + 1, i);
			}
			map.put(chars[j], j++);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring_optimized("abcabcbb"));
		System.out.println(lengthOfLongestSubstring_optimized("bbbbb"));
		System.out.println(lengthOfLongestSubstring_optimized("pwwkew"));
		System.out.println(lengthOfLongestSubstring_optimized(" "));
		System.out.println(lengthOfLongestSubstring_optimized(""));
		System.out.println(lengthOfLongestSubstring_optimized("abba"));
		System.out.println(lengthOfLongestSubstring_optimized("tmmzuxt"));
	}
}
