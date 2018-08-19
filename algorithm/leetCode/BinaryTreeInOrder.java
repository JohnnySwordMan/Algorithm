package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：中序遍历二叉树，递归和非递归
 * 详情见/algorithm/binaryTree/BSTree.java
 * @author geyan
 *
 */
public class BinaryTreeInOrder {

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		inorderTraversal(root, al);
		return al;
	}

	// 递归
	public void inorderTraversal(TreeNode root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, al);
		al.add(root.val);
		inorderTraversal(root.right, al);
	}

	// 非递归
	public ArrayList<Integer> iterativeInOrder(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		Stack<TreeNode> s = new Stack<>();
		TreeNode cur = root;
		while (!s.empty() || cur != null) {
			if (cur != null) {
				// 一直向左下遍历，push到栈中，直至最左节点
				s.push(cur);
				cur = cur.left;
			} else {
				// 该节点有可能是左节点，也有可能是根节点
				 cur = s.pop();
				 al.add(cur.val);
				 // 如果是左节点，则cur.right为空，那么会继续从栈中弹出节点，如果是根节点，则还会继续遍历该根节点的右子树
				 cur = cur.right;
			}
		}
		return al;
	}
}
