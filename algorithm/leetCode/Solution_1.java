package LeetCode;

/**
 * 题目：minimum-depth-of-binary-tree 
 * 题目描述：Given a binary tree, find its minimum
 * depth.The minimum depth is the number of nodes along the shortest path from
 * the root node down to the nearest leaf node.
 * 
 * 分析：要求出从根节点到其叶子节点的最短路径
 * 1.递归，若空树返回0
 * 2.若左子树为空，则返回右子树的最小深度+1
 * 3.若右子树为空，则返回左子树的最小深度+1
 * 4.若做右子树均不为空，则返回左右子树最小深度的较小值+1
 * 
 * 这里用一个巧妙的方法，如果leftHeight==0 或rightHeight==0，说明要么只有根节点，要么根节点只有左子树或者右子树，那么如果只有左子树，则右子树最小深度+1，如果只有右子树，则左子树最小深度+1。
 * 综上返回 leftHeight + rightHeight + 1即可
 * @author geyan
 *
 */
public class Solution_1 {

	public int run(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = run(root.left);
		int rightHeight = run(root.right);
		if (leftHeight == 0 || rightHeight == 0)
			// return 1;
			return leftHeight + rightHeight + 1;
		return Math.min(leftHeight, rightHeight) + 1;
	}
}
