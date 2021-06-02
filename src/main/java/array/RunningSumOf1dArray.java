package array;

public class RunningSumOf1dArray {

    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

    public static void main(String[] args) {
        ArrayUtils.print(runningSum(new int[]{1,2,3,4}));
        ArrayUtils.print(runningSum(new int[]{1,1,1,1,1}));
        ArrayUtils.print(runningSum(new int[]{3,1,2,10,1}));
    }
}
