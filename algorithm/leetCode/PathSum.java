package LeetCode;

import java.util.ArrayList;

/**
 * 题目：给定二叉树和sum值，找到根节点到叶子节点路径和等于sum的路径，这个不是判断，不同于HasPathSum.java
 * @author geyan
 *
 */
public class PathSum {

	ArrayList<ArrayList<Integer>> arrayList;

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		arrayList = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		getPath(root, sum, list);
		return arrayList;
	}

	public void getPath(TreeNode root, int sum, ArrayList<Integer> list) {
		if (root == null) {
			return;
		}
		list.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			arrayList.add(new ArrayList<>(list));
		}
		getPath(root.left, sum - root.val, list);
		getPath(root.right, sum - root.val, list);
		// 需要删除最后一个节点
		list.remove(list.size() - 1);
	}
}
