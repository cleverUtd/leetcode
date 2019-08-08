package tree;


import java.util.Arrays;

import static tree.Tree.*;

public class SubtreeOfAnotherTree {


	public static boolean isSubtree(TreeNode s, TreeNode t) {
		if (s == null) {
			return false;
		}

		if (isSame(s, t)) {
			return true;
		} else {
			return isSubtree(s.left, t) || isSubtree(s.right, t);
		}
	}

	private static boolean isSame(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}

		if (s == null || t == null) {
			return false;
		}

		return (s.val == t.val) && isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	public static void main(String[] args) {

		System.out.println(isSubtree(BinaryTree.create(Arrays.asList(3,4,5,1,2)),
				BinaryTree.create(Arrays.asList(4,1,2))));

		System.out.println(isSubtree(BinaryTree.create(Arrays.asList(3,4,5,1,2,null,null,null,null,0)),
				BinaryTree.create(Arrays.asList(4,1,2))));


		System.out.println(isSubtree(BinaryTree.create(Arrays.asList(93,92,92,91,93,91,null,90,92,92,94,90,null,89,89,91,93,91,93,95,93,89,91,88,null,null,null,null,null,92,92,90,92,92,94,null,96,92,92,null,null,null,90,87,89,91,null,null,91,89,91,93,93,93,91,93,95,95,97,null,null,91,91,null,null,null,null,90,null,90,null,null,90,null,null,90,92,92,94,92,92,null,92,null,92,null,92,94,94,null,null,96,null,null,90,90,null,91,null,null,null,null,null,null,91,91,91,null,93,null,95,93,null,91,91,null,null,91,null,null,null,null,null,null,null,null,95,null,null,null,null,90,null,null,92,null,null,null,null,null,94,94,96,92,94,90,92,90,90,null,null,null,null,null,89,null,null,93,null,93,null,97,97,91,null,93,95,89,91,91,93,89,89,89,89,null,90,null,null,null,94,null,null,null,null,90,92,92,94,94,null,null,null,92,null,null,92,92,null,88,90,null,null,88,null,90,90,null,null,null,null,null,null,91,null,91,93,95,null,null,null,null,93,93,91,null,null,null,null,null,null,null,null,89,null,null,91,null,null,90,null,92,92,94,96,92,null,92,94,null,null,null,null,null,null,null,91,null,91,null,null,null,95,null,97,91,93,null,91,null,null,null,null,null,null,null,null,98,98,null,null,94,94,null,null,null,99,null,null,null,95,null,95,100)),
				BinaryTree.create(Arrays.asList(91))));
	}
}

