package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ��Ŀ����α���������ÿ������������Ǵӵײ����������
 * �ο�/algorithm/binaryTree/LevelOrder.java�����ú�����෴��
 * �����ڱ����У��Ҳ�û��ֱ�ӽ�ÿһ�е�ArrayList��ӵ�result�У������Ƚ�����ӵ�ջ�У�����ٴ�ջ����ӵ�result�С�
 * @author geyan
 *
 */
public class LevelOrderBottom {

	// �����ǲ�α����������� ���ն�Ӧ�����
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		ArrayList<Integer> al = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		Stack<ArrayList<Integer>> s = new Stack<>();

		TreeNode last = root;
		TreeNode nlast = null;

		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			al.add(cur.val);
			if (cur.left != null) {
				nlast = cur.left;
				q.offer(cur.left);
			}
			if (cur.right != null) {
				nlast = cur.right;
				q.offer(cur.right);
			}
			if (last == cur) {
				last = nlast;
				s.push(al);
				al = new ArrayList<>();
			}
		}
		while (!s.isEmpty()) {
			result.add(s.pop());
		}
		return result;
	}
}
