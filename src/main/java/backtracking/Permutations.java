package backtracking;

import java.util.LinkedList;
import java.util.List;

public class Permutations {


		public static List<List<Integer>> permute(int[] nums) {
			List<List<Integer>> permuteList = new LinkedList<>();
			if (nums.length == 0) {
				return permuteList;
			}
			dfs(permuteList,  nums, 0);
			return permuteList;
		}


		private static void dfs(List<List<Integer>> permuteList, int[] nums, int cur) {

			if (cur == nums.length) {
				List<Integer> temp = new LinkedList<>();
				for (int num : nums) {
					temp.add(num);
				}
				permuteList.add(temp);
				return;
			}

			for (int i = cur; i < nums.length; i++) {
				swap(nums, cur, i);
				dfs(permuteList, nums, cur + 1);
				swap(nums, cur, i);
			}
		}

		private static void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}

	public static void main(String[] args) {
		System.out.println(permute(new int[]{1, 2, 3}));
	}
}
