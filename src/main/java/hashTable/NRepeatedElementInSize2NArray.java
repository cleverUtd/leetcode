package hashTable;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElementInSize2NArray {

	public static int repeatedNTimes(int[] A) {
		Map<Integer, Integer> map = new HashMap<>(A.length);
		for (int a : A) {
			if (map.containsKey(a))
				return a;
			map.put(a, 1);
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(repeatedNTimes(new int[]{1,2,3,3}));
		System.out.println(repeatedNTimes(new int[]{2,1,2,5,3,2}));
		System.out.println(repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
	}
}
