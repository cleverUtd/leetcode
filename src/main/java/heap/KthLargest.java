package heap;

import java.util.PriorityQueue;

public class KthLargest {

	private PriorityQueue<Integer> queue;
	private int k;

	public KthLargest(int k, int[] nums) {
		queue = new PriorityQueue<>(k);
		this.k = k;
		for (int num : nums) {
			add(num);
		}
	}

	public int add(int val) {
		if (queue.size() < k) {
			queue.add(val);
		} else if (val >= queue.peek()) {
			queue.remove();
			queue.add(val);
		}

		return queue.peek();
	}

	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
		System.out.println(kthLargest.add(3));
		System.out.println(kthLargest.add(5));
		System.out.println(kthLargest.add(10));
		System.out.println(kthLargest.add(9));
		System.out.println(kthLargest.add(4));
	}
}
