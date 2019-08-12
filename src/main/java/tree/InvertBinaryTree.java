package tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static tree.Tree.TreeNode;

public class InvertBinaryTree {

	public static TreeNode invertTree_recursive(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.left == null && root.right == null) {
			return root;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree_recursive(root.left);
		invertTree_recursive(root.right);

		return root;
	}

	public static TreeNode invertTree_loop(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = root;
		queue.add(cur);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur == null) {
				continue;
			}
			if (cur.left == null && cur.right == null) {
				continue;
			}

			TreeNode temp = cur.left;
			cur.left = cur.right;
			cur.right = temp;

			queue.add(cur.left);
			queue.add(cur.right);
		}

		return root;
	}

	public static void main(String[] args) {
		BinaryTree.traversePrintBFS(invertTree_loop(BinaryTree.create(Arrays.asList(4,2,7,1,3,6,9))));
		BinaryTree.traversePrintBFS(invertTree_loop(BinaryTree.create(Arrays.asList(4))));
		BinaryTree.traversePrintBFS(invertTree_loop(BinaryTree.create(Arrays.asList(4,1))));
		BinaryTree.traversePrintBFS(invertTree_loop(BinaryTree.create(Arrays.asList(4,1,2))));
	}
}
