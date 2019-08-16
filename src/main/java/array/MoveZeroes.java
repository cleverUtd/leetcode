package array;

public class MoveZeroes {


	public static void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - 1; j++) {
				if (nums[j] != 0) {
					continue;
				}
				if (nums[j] == 0 && nums[j+1] == 0) {
					continue;
				}
				int temp = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = temp;
			}
		}
	}

	public static void moveZeroes_v2(int[] nums) {
		for (int lastNonZero = 0, cur = 0; cur < nums.length; cur++) {
			if (nums[cur] != 0) {
				int temp = nums[cur];
				nums[cur] = nums[lastNonZero];
				nums[lastNonZero] = temp;
				lastNonZero++;
			}
		}
	}




	public static void main(String[] args) {
		int[][] caseNums = new int[][] {
				{1,2,3,4,5},
				{0,1,0,3,12},
				{0,0,0,0,1},
				{1,0,0,0,1}
		};
		for (int[] caseNum : caseNums) {
			moveZeroes_v2(caseNum);
			ArrayUtils.print(caseNum);
		}
	}
}
