package stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

	private Stack<Integer> s1 = new Stack<>();
	private Stack<Integer> s2 = new Stack<>();

	/** Initialize your data structure here. */
	public ImplementQueueUsingStacks() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		s1.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		if (!s2.isEmpty()) {
			return s2.pop();
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		return s2.pop();
	}

	/** Get the front element. */
	public int peek() {
		if (!s2.isEmpty()) {
			return s2.peek();
		}

		while (!s1.isEmpty()) {
			s2.push(s1.pop());
		}

		return s2.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	public static void main(String[] args) {
		ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

		queue.push(1);
		queue.push(2);
		queue.push(3);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		queue.push(4);
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}
}
