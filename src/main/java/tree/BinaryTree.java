package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTree extends Tree {


	public static TreeNode create(List<Integer> values) {
		TreeNode root = null;
		Map<Integer, TreeNode> created = new HashMap<>();
		for (int i = 0; i < values.size(); i++) {
			if (values.get(i) == null) {
				continue;
			}

			TreeNode cur = created.get(i);
			if (cur == null) {
				cur = new TreeNode(values.get(i));
				created.put(i, cur);
			}
			if (root == null) {
				root = cur;
			}

			int leftIndex = 2 * i + 1;
			if (leftIndex < values.size() && values.get(leftIndex) != null) {
				cur.left = new TreeNode(values.get(leftIndex));
				created.put(leftIndex, cur.left);
			}
			int rightIndex = 2 * i + 2;
			if (rightIndex < values.size() && values.get(rightIndex) != null) {
				cur.right = new TreeNode(values.get(2 * i + 2));
				created.put(rightIndex, cur.right);
			}
		}
		return root;
	}

	public static void main(String[] args) {
		traversePrintBFS(create(Arrays.asList(1,2,3,null,4)));
	}
}
