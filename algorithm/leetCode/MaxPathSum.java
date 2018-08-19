package LeetCode;

/**
 * 题目：二叉树中最大的路径和，路径不局限于根节点到叶子节点，只要是二叉树中的任意一条路径即可。
 * 
 * 分析：
 * 1. 路径不局限于根节点到叶子节点，只要是二叉树中的任意路径即可。
 * 2. 因为这个路径的灵活性，我们需要对递归返回值进行一些调整，而不是通常的返回要求的结果。在这里，函数的返回值定义为以自己为根的一条从根到子结点的最长路径。
 * 这个返回值是为了提供给它的父结点计算自身的最长路径用，
 * 而结点自身的最长路径（也就是可以从左到右那种）则只需计算然后更新即可。
 * 这样一来，一个结点自身的最长路径就是它的左子树返回值（如果大于0的话），
 * 加上右子树的返回值（如果大于0的话），再加上自己的值。
 * 而返回值则是自己的值加上左子树返回值，右子树返回值或者0（注意这里是“或者”，而不是“加上”，因为返回值只取一支的路径和）。
 * 在过程中求得当前最长路径时比较一下是不是目前最长的，如果是则更新。
 * 算法的本质还是一次树的遍历，所以复杂度是O(n)。而空间上仍然是栈大小O(logn)。
 * @author geyan
 *
 */
public class MaxPathSum {

	int maxValue = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		getMaxPathSum(root);
		return maxValue;
	}

	public int getMaxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// 以root为根的节点的左孩子值，与0比较取较大值，为了防止出现负数的情况
		int left = Math.max(0, getMaxPathSum(root.left));
		int right = Math.max(0, getMaxPathSum(root.right));
		// 记录下当前路径的最大和
		maxValue = Math.max(maxValue, root.val + left + right);
		// 只能返回左右子树中较大值+当前根节点的值，以作为当前根节点的父节点的左子树中最大的路径和
		return Math.max(0, root.val + Math.max(left, right));
	}
}
