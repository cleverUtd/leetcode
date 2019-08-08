package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "Node{" + "val=" + val + '}';
		}
	}


	protected static void traversePrintBFS(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode treeNode = queue.poll();
			System.out.print(treeNode == null ? "NULL " : treeNode + " ");
			if (treeNode != null) {
				queue.add(treeNode.left);
				queue.add(treeNode.right);
			}
		}
	}
}

