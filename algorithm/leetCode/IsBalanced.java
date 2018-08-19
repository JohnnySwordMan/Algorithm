package LeetCode;

/**
 * ��Ŀ���ж϶������ǲ��Ǹ߶�ƽ��ġ������ж϶������ǲ���ƽ���������
 * 
 * �ж��Ƿ���ƽ�����������ο�/algorithm/JZOffer/IsBalanced.java��
 * �ж��Ƿ���ƽ����������������ж��Ƿ��Ƕ�������������ȥ�ж��Ƿ���ƽ���������
 * @author geyan
 *
 */
public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	private int getHeight(TreeNode root, int level, boolean[] res) {
		if (root == null) {
			return level;
		}
		int leftHeight = getHeight(root.left, level + 1, res);
		if (!res[0]) {
			return leftHeight;
		}
		int rightHeight = getHeight(root.right, level + 1, res);
		if (!res[0]) {
			return rightHeight;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			res[0] = false;
			return Math.max(leftHeight, rightHeight);
		}
		return Math.max(leftHeight, rightHeight);
	}
}
