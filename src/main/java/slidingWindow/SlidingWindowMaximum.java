package slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0 || nums.length < k) {
			return new int[0];
		}

		// 用一个双端队列保存窗口内的数
		Deque<Integer> deque = new ArrayDeque<>();
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < nums.length; i++) {
			// 保证队头的数是窗口内最大，待加入窗口的数字如果比队列中的数大，则先丢弃窗口内的数，再添加新数
			 while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
			 	deque.removeLast();
			 }

			 deque.addLast(i);
			 // 队头数已经不属于当前窗口，丢弃掉
			 if (deque.getFirst() + k == i) {
			 	deque.removeFirst();
			 }

			 // 每个窗口期取出队头即当前窗口最大的数
			 if (i + 1 >= k) {
			 	result[i + 1 - k] = nums[deque.getFirst()];
			 }
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1,1,1}, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{3,2,1,-1,-1,-1}, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[]{}, 0)));
	}
}
