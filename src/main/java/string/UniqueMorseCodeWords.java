package string;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {


	static String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

	public static int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < word.length(); j++) {
				sb.append(morse[word.charAt(j) - 'a']);
			}
			set.add(sb.toString());
		}

		return set.size();
	}

	public static void main(String[] args) {
		System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
	}
}
