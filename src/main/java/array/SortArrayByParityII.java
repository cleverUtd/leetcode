package array;

public class SortArrayByParityII {
	public static int[] sortArrayByParityII(int[] A) {
		int[] result = new int[A.length];
		int oddIndex = 1, evenIndex = 0;
		for (int num : A) {
			if (num % 2 == 0) {
				result[evenIndex] = num;
				evenIndex += 2;
			} else {
				result[oddIndex] = num;
				oddIndex += 2;
			}
		}
		return result;
	}

	public static int[] sortArrayByParityII_2(int[] A) {
		int j = 1;
		for (int i = 0; i < A.length; i+=2) {
			if (A[i] % 2 == 1) {  // 偶数位的num是奇数，
				while (A[j] % 2 == 1) { // 找出奇数位是偶数的索引，
					j += 2;
				}

				int temp = A[i]; // 交换两个位置的数字
				A[i] = A[j];
				A[j] = temp;
			}
		}

		return A;
	}

	public static void main(String[] args) {
		ArrayUtils.print(sortArrayByParityII_2(new int[]{4,2,5,7}));
		ArrayUtils.print(sortArrayByParityII_2(new int[]{1,1,2,2}));
	}
}
