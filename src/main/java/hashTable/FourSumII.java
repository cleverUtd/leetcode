package hashTable;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {

	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

		if (A.length == 0) {
			return 0;
		}

		Map<Integer, Integer> ab = new HashMap<>();

		int sum;
		for (int a : A) {
			for (int b : B) {
				sum = a + b;
				ab.put(sum, ab.getOrDefault(sum, 0) + 1);
			}
		}

		int output = 0;
		for (int c : C) {
			for (int d : D) {
				output += ab.getOrDefault(-(c + d), 0);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		System.out.println(fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
		System.out.println(fourSumCount(new int[]{}, new int[]{}, new int[]{}, new int[]{}));
	}
}
