import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuzicong on 19/4/2017.
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
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
}
