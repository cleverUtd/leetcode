package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {


	public static int[][] merge(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return intervals;
		}

		Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

		List<int[]> mergeResultList = new ArrayList<>();
		mergeResultList.add(new int[]{intervals[0][0], intervals[0][1]});
		for (int[] interval : intervals) {
			int[] last = getLast(mergeResultList);
			if (interval[0] <= last[1]) {
				// 当前区间的开始位置小于上一区间的终点位置，表示有重叠部分，合并区间
				last[1] = Math.max(interval[1], last[1]);
			} else {
				// 没有重叠，直接添加新区间
				mergeResultList.add(new int[]{interval[0], interval[1]});
			}
		}
		return mergeResultList.toArray(new int[mergeResultList.size()][]);
	}

	private static int[] getLast(List<int[]> list) {
		return list.get(list.size() - 1);
	}


	private static void print(int[][] intervals) {
		for (int[] interval : intervals) {
			System.out.println(Arrays.toString(interval));
		}
		System.out.println();
	}

	public static void main(String[] args) {
		print(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
		print(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {9, 11}}));
		print(merge(new int[][]{{1, 10}, {2, 6}, {8, 10}, {9, 11}}));
		print(merge(new int[][]{{1, 10}, {2, 6}, {8, 10}, {11, 12}}));
		print(merge(new int[][]{}));
	}
}
