package array;

import java.util.Arrays;

public class SquaresOfASortedArray {

	public static int[] sortedSquares(int[] A) {
		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}

		Arrays.sort(A);
		return A;
	}


	public static void print(int[] A) {
		for (int i : A) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(sortedSquares(new int[]{-4,-1,0,3,10}));
		print(sortedSquares(new int[]{-7,-3,2,3,11}));
	}
}
