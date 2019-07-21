package linkedList;

import java.util.Arrays;
import java.util.Stack;

import static linkedList.LinkedListUtils.*;

public class AddTwoNumbersII {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode reversedL1 = ReverseLinkedList.reverseList(l1);
		ListNode reversedL2 = ReverseLinkedList.reverseList(l2);

		ListNode result = AddTwoNumbers.addTwoNumbers(reversedL1, reversedL2);
		return ReverseLinkedList.reverseList(result);
	}

	static ListNode addTwoNumbers_using_stack(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		ListNode cur = l1;
		while (cur != null) {
			stack1.push(cur.val);
			cur = cur.next;
		}

		cur = l2;
		while (cur != null) {
			stack2.push(cur.val);
			cur = cur.next;
		}

		Stack<Integer> stack3 = new Stack<>();
		int sum = 0, carry = 0;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				sum += stack1.pop();
			}
			if (!stack2.isEmpty()) {
				sum += stack2.pop();
			}

			sum += carry;
			carry = sum / 10;
			stack3.push(sum % 10);
			sum = 0;
		}
		if (carry > 0) {
			stack3.push(carry);
		}


		ListNode head = null;
		cur = null;
		while (!stack3.isEmpty()) {
			if (head == null) {
				head = new ListNode(stack3.pop());
				cur = head;
			} else {
				cur.next = new ListNode(stack3.pop());
				cur = cur.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		traversePrint(addTwoNumbers_using_stack(create(Arrays.asList(7,2,4,3)), create(Arrays.asList(5,6,4))));
		traversePrint(addTwoNumbers_using_stack(create(Arrays.asList(7,2,4,3)), create(Arrays.asList(5))));
		traversePrint(addTwoNumbers_using_stack(create(Arrays.asList(5)), create(Arrays.asList(5))));
	}
}
