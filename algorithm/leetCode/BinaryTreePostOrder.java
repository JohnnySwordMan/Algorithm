package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ������������������ݹ�ͷǵݹ�
 * �����/algorithm/binaryTree/BSTree.java
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

	// �ݹ�
	private void postorderTraversal(TreeNode node, ArrayList<Integer> al) {
		if (node == null) {
			return;
		}
		postorderTraversal(node.left, al);
		postorderTraversal(node.right, al);
		al.add(node.val);
	}

	// �ǵݹ飬ʹ������ջ
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
			// ÿһ����s1�е����Ľڵ㣬��ѹ��s2��
			s2.push(popNode);
		}
		// ���ε���s2�еĽڵ�
		while (!s2.empty()) {
			al.add(s2.pop().val);
		}
		return al;
	}
}
