package array;

import java.util.LinkedList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

	public static List<Integer> findDuplicates(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while ((nums[i] - 1) != i) {
				if ((nums[nums[i] - 1] - 1) == (nums[i] - 1)) {
					break;
				} else {
					int temp = nums[i];
					nums[i] = nums[temp - 1];
					nums[temp - 1] = temp;
				}
			}
		}

		List<Integer> duplicateNumbers = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i) {
				duplicateNumbers.add(nums[i]);
			}
		}
		return duplicateNumbers;
	}



	public static List<Integer> findDuplicates_v2(int[] nums) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			if (nums[num - 1] < 0) {
				result.add(num);
			} else {
				nums[num - 1] *= -1;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
		System.out.println(findDuplicates_v2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
	}
}
