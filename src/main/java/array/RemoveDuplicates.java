package array;

/**
 * 26.remove-duplicates-from-sorted-array
 *
 * @author 刘梓聪
 * @email liuzicong@aulton.com
 * @date 2025/6/5 14:33
 * @Copyright Copyright(c) aulton Inc.AllRightsReserved.
 **/
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 1;
        for (int fast = slow; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                continue;
            }
            nums[slow] = nums[fast];
            slow++;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{1, 1}));
        System.out.println(removeDuplicates(new int[]{1, 2}));
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
