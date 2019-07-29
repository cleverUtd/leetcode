package linkedList;

import java.util.Arrays;

import static linkedList.LinkedListUtils.*;

public class MergeTwoSortedLists {

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = dummyHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if (l1 != null) {
			p.next = l1;
		} else if (l2 != null) {
			p.next = l2;
		}

		return dummyHead.next;
	}

	public static ListNode mergeTwoLists_recursive(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode l3;
		if (l1.val <= l2.val) {
			l3 = l1;
			l3.next = mergeTwoLists_recursive(l1.next, l2);
		} else {
			l3 = l2;
			l3.next = mergeTwoLists_recursive(l1, l2.next);
		}

		return l3;
	}




	public static void main(String[] args) {
		traversePrint(mergeTwoLists_recursive(create(Arrays.asList(1, 2, 4)), create(Arrays.asList(1, 3, 4))));
		traversePrint(mergeTwoLists_recursive(create(null), create(null)));
		traversePrint(mergeTwoLists_recursive(create(Arrays.asList(1,3,5,7)), create(Arrays.asList(2,4))));
	}
}
