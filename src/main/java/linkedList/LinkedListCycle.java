package linkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static linkedList.LinkedListUtils.ListNode;
import static linkedList.LinkedListUtils.create;

public class LinkedListCycle {


	public static boolean hasCycle_hashTable(ListNode head) {
		ListNode cur = head;
		Set<ListNode> addressSet = new HashSet<>();
		while (cur != null) {
			if (addressSet.contains(cur)) {
				return true;
			}

			addressSet.add(cur);
			cur = cur.next;
		}

		return false;
	}

	public static boolean hasCycle_twoPointers(ListNode head) {
		ListNode low = head, fast = head;
		while (fast != null && fast.next != null) {
			low = low.next;
			fast = fast.next.next;
			if (low == fast) {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		ListNode head = create(Arrays.asList(3,2,0,-4));
		tailConnetTo(head, 1);
		System.out.println(hasCycle_hashTable(head));

		head = create(Arrays.asList(1,2));
		tailConnetTo(head, 0);
		System.out.println(hasCycle_hashTable(head));

		head = create(Arrays.asList(1));
		tailConnetTo(head, 0);
		System.out.println(hasCycle_hashTable(head));


		head = create(Arrays.asList(3,2,0,-4));
		tailConnetTo(head, 1);
		System.out.println(hasCycle_twoPointers(head));

		head = create(Arrays.asList(1,2));
		tailConnetTo(head, 0);
		System.out.println(hasCycle_twoPointers(head));

		head = create(Arrays.asList(1));
		tailConnetTo(head, 0);
		System.out.println(hasCycle_twoPointers(head));

		head = create(Arrays.asList(1));
		tailConnetTo(head, -1);
		System.out.println(hasCycle_twoPointers(head));
	}



	private static void tailConnetTo(ListNode head, int index) {
		if (index == -1) {
			return;
		}
		int i = 0;
		ListNode cur = head;
		ListNode indexNode = null;
		while (cur.next != null) {
			if (i == index) {
				indexNode = cur;
			}

			cur = cur.next;
			i++;
		}

		cur.next = indexNode;
	}


}
