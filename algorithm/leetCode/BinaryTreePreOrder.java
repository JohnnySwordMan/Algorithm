package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：先序遍历，递归和非递归
 * 详情见/algorithm/binaryTree/BSTree.java
 * @author geyan
 *
 */
public class BinaryTreePreOrder {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		preorderTraversal(root, al);
		return al;
	}

	// 递归
	private void preorderTraversal(TreeNode node, ArrayList<Integer> al) {
		if (node == null) {
			return;
		}
		al.add(node.val);
		if (node.left != null) {
			preorderTraversal(node.left, al);
		}
		if (node.right != null) {
			preorderTraversal(node.right, al);
		}
	}

	// 非递归
	public ArrayList<Integer> IterativePreOrder(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.empty()) {
			TreeNode cur = s.pop();
			al.add(cur.val);
			// 先将右孩子压入栈中
			if (cur.right != null) {
				s.push(cur.right);
			}
			if(cur.left != null){
				s.push(cur.left);
			}
		}
		return al;
	}
}
