/**
 * 题目：对称的二叉树
 * 题目描述：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 
 * 分析：首先判断根节点的左右子树是否相等，如果相等，再判断左子树的左子树与右子树的右子树，左子树的右子树与右子树的左子树是否相等
 * @author geyan
 *
 */
public class IsSymmetrical {

	public boolean isSymmtrical(TreeNode root) {
		if (root == null) {
			return true;
		}
		return comRoot(root.left,root.right);
	}

	private boolean comRoot(TreeNode left, TreeNode right) {
		if (left == null) {
			return right == null;
		}
		if (right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return comRoot(left.right, right.left) && comRoot(left.left, right.right);
	}
}
