package LeetCode;

import java.util.ArrayList;

/**
 * ��Ŀ��������������sumֵ���ҵ����ڵ㵽Ҷ�ӽڵ�·���͵���sum��·������������жϣ���ͬ��HasPathSum.java
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
		// ��Ҫɾ�����һ���ڵ�
		list.remove(list.size() - 1);
	}
}
