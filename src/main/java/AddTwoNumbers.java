public class AddTwoNumbers {

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int num1 = 0, i = 1;
		ListNode node = l1;
		do {
			num1 = node.val * i + num1;
			i = i * 10;
			node = node.next;
		} while (node != null);


		int num2 = 0, j = 1;
		node = l2;
		do {
			num2 = node.val * j + num2;
			j = j * 10;
			node = node.next;
		} while (node != null);


		int result = num1 + num2;
		ListNode headNode = new ListNode(result % 10);
		node = headNode;
		while ((result = result / 10) != 0) {
			node.next = new ListNode(result % 10);
			node = node.next;
		}

		return headNode;
	}
}
