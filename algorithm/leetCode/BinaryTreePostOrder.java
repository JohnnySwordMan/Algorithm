package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：后序遍历二叉树，递归和非递归
 * 详情见/algorithm/binaryTree/BSTree.java
 * @author geyan
 *
 */
public class BinaryTreePostOrder {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		postorderTraversal(root, al);
		return al;
	}

	// 递归
	private void postorderTraversal(TreeNode node, ArrayList<Integer> al) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left, al);
		postorderTraversal(node.right, al);
		al.add(node.val);
	}

	// 非递归，使用两个栈
	public ArrayList<Integer> IterativePostOrderTraversal(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		if (root == null) {
			return al;
		}
		TreeNode cur = root;
		s1.push(cur);
		while (!s1.empty()) {
			TreeNode popNode = s1.pop();
			if (popNode.left != null) {
				s1.push(popNode.left);
			}
			if (popNode.right != null) {
				s1.push(popNode.right);
			}
			// 每一个从s1中弹出的节点，都压入s2中
			s2.push(popNode);
		}
		// 依次弹出s2中的节点
		while (!s2.empty()) {
			al.add(s2.pop().val);
		}
		return al;
	}
}
