package tree;

public class BSTUtils {


	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static TreeNode createBST(int[] nums) {
		TreeNode root = null;
		for (int num : nums) {
			root = insert(root, num);
		}

		return root;
	}

	public static TreeNode insert(TreeNode root, int val) {

		if (root == null) {
			return new TreeNode(val);
		}

		if (val < root.val) {
			root.left = insert(root.left, val);
		} else if (val > root.val) {
			root.right = insert(root.right, val);
		} else {
			return root;
		}

		return root;
	}

}
