package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：二叉树层次遍历，按之字型打印
 * 
 * 分析：使用flag变量来控制顺序，ArrayList集合可以添加元素到具体下标，在反向输出时，每次可以添加元素至0的位置
 * 类似题目参考：/algorithm/binaryTree/LevelOrder.java
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
