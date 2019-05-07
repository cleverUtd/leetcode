import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzicong on 19/4/2017.
 */
public class SingleNumber {

	public static int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}

		int num = 0;

		Set<Integer> set = map.keySet();
		for (Integer in : set) {
			int n = map.get(in);
			if (n == 1) {
				num = in;
			}
		}
		return num;
	}


	/**
	 * 利用异或运算：两个操作数的位中，相同则结果为0，不同则结果为1
	 *
	 * a ^ 0 = a
	 * a ^ a = 0
	 * a ^ b ^ a = (a ^ a) ^ b = 0 ^ b = b
	 */
	public static int singleNumber_bitManipulation(int[] nums) {
		int result = 0;
		for (int num : nums) {
			result = result ^ num;
		}
		return result;
	}


	public static void main(String[] args) {
		System.out.println(singleNumber_bitManipulation(new int[]{4,1,2,1,2}));
		System.out.println(singleNumber_bitManipulation(new int[]{1}));
	}
}
