package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ����������α�������֮���ʹ�ӡ
 * 
 * ������ʹ��flag����������˳��ArrayList���Ͽ������Ԫ�ص������±꣬�ڷ������ʱ��ÿ�ο������Ԫ����0��λ��
 * ������Ŀ�ο���/algorithm/binaryTree/LevelOrder.java
 * @author geyan
 *
 */
public class Solution_17 {
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		if (root == null) {
			return res;
		}
		boolean flag = true;
		TreeNode last = root;
		TreeNode nlast = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (flag) {
				al.add(cur.val);
			} else {
				al.add(0, cur.val);
			}

			if (cur.left != null) {
				nlast = cur.left;
				q.offer(cur.left);
			}

			if (cur.right != null) {
				nlast = cur.right;
				q.offer(cur.right);
			}

			if (cur == last) {
				last = nlast;
				flag = !flag;
				res.add(al);
				al = new ArrayList<>();
			}
		}
		return res;
	}
}
