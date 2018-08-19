package LeetCode;

/**
 * 题目：给定二叉树和sum，判断是否存在从根节点到叶子节点的一条路径和等于sum
 * @author geyan
 *
 */
public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		if (root.val == sum && root.left == null && root.right == null) {
			return true;
		}
		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}
}
