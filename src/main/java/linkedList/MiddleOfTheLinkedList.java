package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static linkedList.LinkedListUtils.ListNode;
import static linkedList.LinkedListUtils.create;

public class MiddleOfTheLinkedList {

	public static ListNode middleNode(ListNode head) {
		List<ListNode> list = new ArrayList<>(100);
		ListNode cur = head;
		while (cur != null) {
			list.add(cur);
			cur = cur.next;
		}

		return list.get(list.size() / 2);
	}

	public static ListNode middleNode_fast_slow_pointer(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		System.out.println(middleNode_fast_slow_pointer(create(Arrays.asList(1,2,3,4,5))));
		System.out.println(middleNode_fast_slow_pointer(create(Arrays.asList(1,2,3,4,5,6))));
	}
}
