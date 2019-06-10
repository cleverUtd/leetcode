package array;

import java.util.Arrays;

public class ArrayPartitionI {

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i+=2) {
			sum += nums[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[]{1,1,1,1}));
		System.out.println(arrayPairSum(new int[]{1,4,3,2}));
	}
}
