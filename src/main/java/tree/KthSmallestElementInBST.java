package tree;

import java.util.Stack;

import static tree.BSTUtils.TreeNode;
import static tree.BSTUtils.createBST;

public class KthSmallestElementInBST {

	public static int kthSmallest_dfs(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}

		int leftTreeSize = calTreeSize(root.left);
		if (leftTreeSize + 1 == k) {
			return root.val;
		} else if(leftTreeSize >= k) {
			return kthSmallest_dfs(root.left, k);
		} else {
			return kthSmallest_dfs(root.right, k - leftTreeSize - 1);
		}
	}

	private static int calTreeSize(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + calTreeSize(root.left) + calTreeSize(root.right);
	}


	public static int kthSmallest_in_order_traverse(TreeNode root, int k) {
		if (root == null) {
			return -1;
		}

		Stack<TreeNode> stack = new Stack<>();
		while (true) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) {
				return root.val;
			}
			root = root.right;
		}
	}

	public static void main(String[] args) {
		System.out.println(kthSmallest_in_order_traverse(createBST(new int[]{1,2,3,4,5}), 3));
		System.out.println(kthSmallest_in_order_traverse(createBST(new int[]{1,2,3,4,5}), 1));
		System.out.println(kthSmallest_in_order_traverse(createBST(new int[]{5,4,3,2,1}), 1));
		System.out.println(kthSmallest_in_order_traverse(createBST(new int[]{5,4,3,2,1}), 5));
		System.out.println(kthSmallest_in_order_traverse(createBST(new int[]{10, 5, 25, 1, 30}), 4));
	}
}
