import java.util.Arrays;

public class Test {


	public static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static boolean isSwap(int[] array, int from, int i) {
		if (from != i) {
			for (int j = from; j < i; j++) {
				if (array[j] == array[i]) {
					return false;
				}
			}
		}

		return true;
	}

	public static void permutation_recursive(int[] arr, int from, int end) {
		if (from == end) {
			System.out.println(Arrays.toString(arr));
		}

		for (int i = from; i <= end; i++) {
			if (!isSwap(arr, from, i)) continue;
			swap(arr, from, i);
			permutation_recursive(arr, from + 1, end);
			swap(arr, from, i);
		}
	}

	public static void permutation_dictionary_order() {
		
	}

	public static void main(String[] args) {
		permutation_recursive(new int[]{1, 2, 3}, 0, 2);
	}
}
