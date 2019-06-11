package hashTable;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

	public static int numJewelsInStones(String J, String S) {
		Set<Character> jewels = new HashSet<>(J.length());
		for (int i = 0; i < J.length(); i++) {
			jewels.add(J.charAt(i));
		}

		int ownJewelsCount = 0;
		for (int i = 0; i < S.length(); i++) {
			if (jewels.contains(S.charAt(i)))
				ownJewelsCount++;
		}

		return ownJewelsCount;
	}

	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA", "aAAbbbb"));
		System.out.println(numJewelsInStones("z", "ZZ"));
	}
}
