package array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {


	public static int majorityElement_hash(int[] nums) {
		int majority = nums.length / 2;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Integer count = map.get(num);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}

			if (count > majority) {
				return num;
			}
			map.put(num, count);
		}

		return -1;
	}

	public static int majorityElement_Boyer_Moore_Voting(int[] nums) {
		int count = 0, candidate = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
				count++;
			} else if (candidate == num) {
				count++;
			} else {
				count--;
			}
		}
		return candidate;
	}

	public static void main(String[] args) {
		System.out.println(majorityElement_Boyer_Moore_Voting(new int[]{3, 2, 3}));
		System.out.println(majorityElement_Boyer_Moore_Voting(new int[]{2, 2, 1, 1, 1, 2, 2}));
	}
}
