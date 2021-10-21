package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(Tree.TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public void inorder(Tree.TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
