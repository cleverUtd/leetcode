package linkedList;

import java.util.Arrays;

import static linkedList.LinkedListUtils.*;

public class ReverseLinkedList {

	public static ListNode reverseList(ListNode head) {
		ListNode pre = null, cur = head, next;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	public static void main(String[] args) {
		ListNode head = create(Arrays.asList(1,2));
		head = reverseList(head);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3));
		head = reverseList(head);
		traversePrint(head);

		head = create(Arrays.asList(1));
		head = reverseList(head);
		traversePrint(head);

		head = create(null);
		head = reverseList(head);
		traversePrint(head);
	}

}


