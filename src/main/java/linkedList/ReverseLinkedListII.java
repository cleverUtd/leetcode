package linkedList;

import java.util.Arrays;

import static linkedList.LinkedListUtils.*;

public class ReverseLinkedListII {


	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n) {
			return head;
		}

		ListNode pre = null, cur = head;
		ListNode start = null, startPre = null, end = null, endNext = null;
		int position = 1;
		// 1. 定位m,n区间的起止位置
		while (cur != null) {
			if (position == m) {
				start = cur;
				startPre = pre;
			} else if (position == n) {
				end = cur;
				endNext = cur.next;
				break;
			}

			pre = cur;
			cur = cur.next;
			position++;
		}

		if (start == null) {
			return head;
		}

		// 2. 倒置m,n区间内链表
		cur = start.next;
		pre = start;
		ListNode next;
		while (cur != endNext) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		// 3. 修改m，n边界处的listNode的next方向
		if (startPre != null) {
			startPre.next = end;
		}
		start.next = endNext;

		if (m == 1) {
			return end;
		}
		return head;
	}


	public static void main(String[] args) {
		ListNode head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 2, 4);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 1, 5);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 1, 1);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 3, 3);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 1, 2);
		traversePrint(head);

		head = create(Arrays.asList(1,2,3,4,5));
		head = reverseBetween(head, 2, 5);
		traversePrint(head);

		head = create(Arrays.asList(1,2));
		head = reverseBetween(head, 1, 2);
		traversePrint(head);
	}
}
