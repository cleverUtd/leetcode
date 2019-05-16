package stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

	private Queue<Integer> queue1 = new LinkedList<>();
	private Queue<Integer> queue2 = new LinkedList<>();
	private int top;

	/**
	 * 用两个queue实现，push O(1), pop O(n)
	 */
	public void push(int x) {
		queue1.add(x);
		top = x;
	}

	public int pop() {
		while (queue1.size() > 1) {
			top = queue1.remove();
			queue2.add(top);
		}
		int val = queue1.remove();

		Queue<Integer> temp = queue2;
		queue2 = queue1;
		queue1 = temp;
		return val;
	}

	public int top() {
		return top;
	}


	/**
	 * 用1个queue实现，push O(n), pop O(1)
	 */
	public void push_v2(int x) {
		queue1.add(x);
		int size = queue1.size();
		while (size > 1) {
			queue1.add(queue1.remove());
			size--;
		}
	}

	public int pop_v2() {
		return queue1.remove();
	}

	public int top_v2() {
		return queue1.element();
	}


	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue1.size() == 0;
	}


	public static void main(String[] args) {
		ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
		stack.push(1);
		stack.push(2);
		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.empty());
		System.out.println(stack.pop());
		System.out.println(stack.empty());

		stack.push(1);
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.empty());
	}
}
