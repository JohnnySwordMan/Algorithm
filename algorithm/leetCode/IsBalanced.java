package LeetCode;

/**
 * 题目：判断二叉树是不是高度平衡的。不是判断二叉树是不是平衡二叉树。
 * 
 * 判断是否是平衡二叉树，请参考/algorithm/JZOffer/IsBalanced.java。
 * 判断是否是平衡二叉树，必须先判断是否是二叉排序树。再去判断是否是平衡二叉树。
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
