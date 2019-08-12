import tree.BinaryTree;
import tree.Tree;

import java.util.Arrays;

public class Test {


	public static void main(String[] args) {
		System.out.println(depth(BinaryTree.create(Arrays.asList(1,2,3))));
		System.out.println(depth(BinaryTree.create(Arrays.asList(1))));
		System.out.println(depth(BinaryTree.create(Arrays.asList(1,2,3,4,5,6,7,8,null,9,10,null,null,null,null,null,null,null,null,null,null,12))));
	}

	public static int depth(Tree.TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(depth(root.left), depth(root.right));
	}



}
