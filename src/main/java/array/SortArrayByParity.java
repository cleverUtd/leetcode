package array;

public class SortArrayByParity {

	public static int[] sortArrayByParity(int[] A) {
		int temp;
		// 利用双指针
		for (int i = 0, j = A.length - 1;;) {
			while (A[i] % 2 == 0) {  // i从前往后遍历，找到奇数
				i++;
				if (i == A.length) {
					return A;
				}
			}

			while (A[j] % 2 == 1) { // j从后往前遍历，找偶数
				j--;
				if (j < 0) {
					return A;
				}
			}

			if (i < j) {  // i<j代表此时i位置的奇数位于j位置上的偶数之前，所以需要交换
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			} else {
				break;
			}
		}

		return A;
	}


	public static void print(int[] A) {
		for (int i : A) {
			System.out.print(i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(sortArrayByParity(new int[]{3,1,2,4}));
		print(sortArrayByParity(new int[]{3,3,3,3}));
		print(sortArrayByParity(new int[]{3}));
		print(sortArrayByParity(new int[]{0,0,0,0}));
		print(sortArrayByParity(new int[]{1,2,3,4,5}));
		print(sortArrayByParity(new int[]{2,2,2,3}));
		print(sortArrayByParity(new int[]{2,3,2,3}));
		print(sortArrayByParity(new int[]{1,1,2,2}));
	}
}
