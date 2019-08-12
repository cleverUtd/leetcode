package tree;

import java.util.Arrays;

import static tree.Tree.*;

public class MaximumDepthOfBinaryTree {

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static void main(String[] args) {
		System.out.println(maxDepth(BinaryTree.create(Arrays.asList(3,9,20,null,null,15,7))));
	}
}
