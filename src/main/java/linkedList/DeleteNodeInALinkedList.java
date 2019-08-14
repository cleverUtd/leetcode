package linkedList;

import static linkedList.LinkedListUtils.*;

public class DeleteNodeInALinkedList {

	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {

	}
}
