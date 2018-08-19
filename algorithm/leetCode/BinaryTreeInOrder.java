package LeetCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ������������������ݹ�ͷǵݹ�
 * �����/algorithm/binaryTree/BSTree.java
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

	// �ݹ�
	public void inorderTraversal(TreeNode root, ArrayList<Integer> al) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, al);
		al.add(root.val);
		inorderTraversal(root.right, al);
	}

	// �ǵݹ�
	public ArrayList<Integer> iterativeInOrder(TreeNode root) {
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return al;
		}
		Stack<TreeNode> s = new Stack<>();
		TreeNode cur = root;
		while (!s.empty() || cur != null) {
			if (cur != null) {
				// һֱ�����±�����push��ջ�У�ֱ������ڵ�
				s.push(cur);
				cur = cur.left;
			} else {
				// �ýڵ��п�������ڵ㣬Ҳ�п����Ǹ��ڵ�
				 cur = s.pop();
				 al.add(cur.val);
				 // �������ڵ㣬��cur.rightΪ�գ���ô�������ջ�е����ڵ㣬����Ǹ��ڵ㣬�򻹻���������ø��ڵ��������
				 cur = cur.right;
			}
		}
		return al;
	}
}
