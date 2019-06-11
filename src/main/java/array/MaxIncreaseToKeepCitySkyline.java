package array;

public class MaxIncreaseToKeepCitySkyline {

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] maxRow = new int[grid.length];
		int[] maxColumn = new int[grid[0].length];

		// 分别找出每一行、每一列的最大值
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > maxRow[i]) maxRow[i] = grid[i][j];
				if (grid[i][j] > maxColumn[j]) maxColumn[j] = grid[i][j];
			}
		}

		int maxIncrease = 0;
		int min;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				// 所在行与列中较小的那个最大值减去当前数值，得到改grid的increase值，将所有increase值相加则得到 max increase
				min = Math.min(maxRow[i], maxColumn[j]);
				if (min > grid[i][j]) {
					maxIncrease += min - grid[i][j];
				}
			}
		}

		return maxIncrease;
	}

	public static void main(String[] args) {
		System.out.println(maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}}));
		System.out.println(maxIncreaseKeepingSkyline(new int[][]{{1,2},{1,2}}));
	}
}
