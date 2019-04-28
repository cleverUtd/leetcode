package linkedList;

import java.util.List;

public class LinkedListUtils {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}


	public static ListNode create(List<Integer> initialList) {
		if (initialList == null || initialList.size() == 0) {
			return null;
		}
		ListNode head = new ListNode(initialList.get(0));
		ListNode cur = head;
		for (int i = 1; i < initialList.size(); i++) {
			cur.next = new ListNode(initialList.get(i));
			cur = cur.next;
		}
		return head;
	}

	public static void traversePrint(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.println("NULL");
	}

}
