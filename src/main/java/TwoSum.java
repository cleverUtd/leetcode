/**
 * Created by liuzicong on 19/4/2017.
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int[] nums = new int[2];
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if((numbers[i] + numbers[j]) == target) {
                    nums[0] = i;
                    nums[1] = j;
                }
            }
        }
        return nums;
    }

	public static void main(String[] args) {
		int[] nums = {2,11,15,7};
		int[] result = twoSum(nums, 9);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
