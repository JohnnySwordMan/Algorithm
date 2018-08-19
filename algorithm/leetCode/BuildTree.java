package LeetCode;

/**
 * 题目：根据中序和后序构建二叉树
 * 
 * 根据先序和中序构建二叉树，参考/algorithm/JZOffer/ReConstructBinaryTree.java
 * @author geyan
 *
 */
public class BuildTree {
	// 之前做过先序和中序构造二叉树，现在是中序和后序构造二叉树
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTreeCore(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		// 结束递归
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		// 根节点
		TreeNode root = new TreeNode(postorder[postEnd]);
		// 根据根节点，找出左右子树
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				root.left = buildTreeCore(inorder, inStart, i - 1, postorder, postStart, postStart + i - 1 - inStart);
				root.right = buildTreeCore(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
			}
		}
		return root;
	}
}
