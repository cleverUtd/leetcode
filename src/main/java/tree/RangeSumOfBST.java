package tree;

import java.util.*;

import static tree.BinarySearchTree.*;

public class RangeSumOfBST {


	public static int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null) return 0;
		int sum = 0;
		if (root.val > L) {
			sum += rangeSumBST(root.left, L, R);
		}
		if (root.val < R) {
			sum += rangeSumBST(root.right, L, R);
		}
		if (L <= root.val && root.val <= R) {
			sum += root.val;
		}

		return sum;
	}

	public static int rangeSumBST_BFS(TreeNode root, int L, int R) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		int sum = 0;
		while (!queue.isEmpty()) {
			root = queue.remove();
			if (L <= root.val && root.val <= R) {
				sum += root.val;
			}

			if (L < root.val && root.left != null) {
				queue.add(root.left);
			}
			if (root.val < R && root.right != null) {
				queue.add(root.right);
			}
		}
		return sum;
	}



	public static void main(String[] args) {
		System.out.println(rangeSumBST_BFS(createBST(new int[]{10,5,15,3,7,18}), 7, 15));
		System.out.println(rangeSumBST_BFS(createBST(new int[]{10,5,15,3,7,13,18,1,6}), 6, 10));
	}
}
