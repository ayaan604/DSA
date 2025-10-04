package tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
	List<Integer> inorderList;
	
    public List<Integer> inorderTraversal(TreeNode root) {
		inorderList = new ArrayList<>();
		
		inorder(root);
		
        return inorderList;
    }

	private void inorder(TreeNode root) {
        if(root == null) return;
        
		inorder(root.left);
		
		inorderList.add(root.val);
		
		inorder(root.right);
	}
}



 // Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
 