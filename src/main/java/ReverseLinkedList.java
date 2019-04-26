import java.util.Arrays;
import java.util.List;

public class ReverseLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

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


	private static ListNode create(List<Integer> initialList) {
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

	private static void traversePrint(ListNode head) {
		ListNode cur = head;
		while (cur != null) {
			System.out.print(cur.val + "->");
			cur = cur.next;
		}
		System.out.println("NULL");
	}

}


