package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目：层次遍历，按照每行输出，不过是从底层向上输出。
 * 参考/algorithm/binaryTree/LevelOrder.java。正好和这个相反。
 * 所以在本题中，我并没有直接将每一行的ArrayList添加到result中，而是先将其添加到栈中，最后再从栈中添加到result中。
 * @author geyan
 *
 */
public class LevelOrderBottom {

	// 不就是层次遍历反过来吗？ 按照对应行输出
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
