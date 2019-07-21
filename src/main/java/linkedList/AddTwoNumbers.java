package linkedList;
import static linkedList.LinkedListUtils.*;

public class AddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode node1 = l1;
		ListNode node2 = l2;
		ListNode head = null, succ = null;
		int newVal, val1, val2, sum;
		do {
			val1 = node1 == null ? 0 : node1.val;
			val2 = node2 == null ? 0 : node2.val;
			sum = val1 + val2 + carry;
			if (sum >= 10) {
				carry = 1;
				newVal = sum % 10;
			} else {
				carry = 0;
				newVal = sum;
			}

			ListNode newNode = new ListNode(newVal);
			if (succ == null) {
				head = newNode;
			} else {
				succ.next = newNode;
			}
			succ = newNode;

			node1 = node1 != null ? node1.next : null;
			node2 = node2 != null ? node2.next : null;
		} while (node1 != null || node2 != null);

		if (carry == 1) {
			succ.next = new ListNode(carry);
		}
		return head;
	}
}
