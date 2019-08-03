package linkedList;

import java.util.Arrays;

import static linkedList.LinkedListUtils.*;

public class RemoveNthNodeFromEndOfList {

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode fast = dummy, slow = dummy;
		for (int i = 0; i < n + 1; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		traversePrint(removeNthFromEnd(create(Arrays.asList(1,2,3,4,5)), 2));
		traversePrint(removeNthFromEnd(create(Arrays.asList(1,2)), 1));
		traversePrint(removeNthFromEnd(create(Arrays.asList(1,2)), 2));
	}
}
