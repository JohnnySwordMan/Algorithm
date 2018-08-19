/**
 * 题目：平衡二叉树判断 
 * 题目描述：有一棵二叉树，请设计一个算法判断这棵二叉树是否为平衡二叉树。
 * 给定二叉树的根节点root，请返回一个bool值，代表这棵树是否为平衡二叉树。
 * 
 * 分析：判断是否是平衡二叉树，通过后序遍历来实现，若判断根节点root的二叉树是否平衡，可以先判断root的左子树是否平衡，如果不平衡，则直接返回，
 * 如果平衡，则继续判断root的右子树是否平衡。在判断root的左子树是否平衡的时候，又是重复上述过程，所以使用递归的方式。
 * 
 * 修改：判断平衡二叉树，应该首先判断是否是二叉排序树。参考/JZOffer/IsBalanced.java
 * @author geyan
 *
 */
public class CheckBalance {

	public boolean check(TreeNode root) {
		// 定义引用类型作为平衡标记，如果直接定义成boolean，通过值传递的方式，那么getHeight方法中对boolean标记的修改，只能作用在方法内。
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	private int getHeight(TreeNode node, int level, boolean[] res) {
		if (node == null)
			return level;
		// 通过递归方式，判断左子树
		int leftHeight = getHeight(node.left, level + 1, res);
		// 如果在遍历左子树过程中修改了平衡标记，那么左子树不平衡，返回高度
		if (!res[0])
			return leftHeight;
		// 通过递归方式，判断右子树
		int rightHeight = getHeight(node.right, level + 1, res);
		// 如果在遍历右子树过程中修改了平衡标记，那么右子树不平衡，返回高度
		if (!res[0])
			return rightHeight;
		// 若左右子树都是平衡的，则对左右子树深度进行比较，判断当前结点为根的子树是否平衡
		if (Math.abs(leftHeight - rightHeight) > 1) {
			res[0] = false;
			return Math.max(leftHeight, rightHeight);
		}
		return Math.max(leftHeight, rightHeight);
	}
}
