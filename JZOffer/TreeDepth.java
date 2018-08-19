/**
 * 面试题39：二叉树的深度 
 * 面试描述：输入一棵二叉树的根节点，求该树的深度。
 * 
 * @author geyan
 *
 */
public class TreeDepth {

	/**
	 * 分析： 
	 * 如果一棵二叉树只有根节点，高度为1; 
	 * 如果根节点只有左子树而没有右子树，则左子树高度+1;
	 * 如果根节点只有右子树而没有左子树，则右子树高度+1; 
	 * 如果根节点既有左子树，又有右子树，则左右子树高度的较大值+1
	 */
	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}
}
