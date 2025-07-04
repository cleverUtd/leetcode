package array;


public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        return solution_1(nums, val);
//        return solution_2(nums, val);
    }

    public static int solution_1(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        while (slow < nums.length && fast < nums.length) {
            // 找下一个待删除的元素
            if (nums[slow] != val) {
                slow++;
                continue;
            }

            // 从当前待删除元素开始，查找第一个不是待删除元素的位置，交换位置
            for (fast = slow + 1; fast < nums.length; fast++) {
                if (nums[fast] == val) {
                    continue;
                }
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                break;
            }
        }
        return slow;
    }

    public static int solution_2(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
        System.out.println(removeElement(new int[]{0}, 2));
        System.out.println(removeElement(new int[]{0}, 0));
        System.out.println(removeElement(new int[]{3, 3, 3, 3}, 3));
        System.out.println(removeElement(new int[]{3, 3, 3, 3}, 3));
        System.out.println(removeElement(new int[]{3, 3, 1, 1}, 3));
        System.out.println(removeElement(new int[]{3, 3, 3, 1}, 3));
    }
}
