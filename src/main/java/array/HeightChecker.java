package array;

import java.util.Arrays;

public class HeightChecker {

	public static int heightChecker(int[] heights) {
		int[] original = heights.clone();
		Arrays.sort(heights);
		int difference = 0;
		for (int i = 0; i < original.length; i++) {
			if (heights[i] != original[i]) {
				difference++;
			}
		}

		return difference;
	}


	public static void main(String[] args) {
		System.out.println(heightChecker(new int[]{1,3,1,2}));
		System.out.println(heightChecker(new int[]{1,1,4,2,1,3}));
	}
}
