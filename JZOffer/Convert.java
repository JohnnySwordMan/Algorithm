/**
 * 面试题27：二叉搜索树与双向链表
 * 题目描述：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 
 * 分析：
 * 利用中序遍历，原先指向左子树节点的指针调整为链表中指向前一个节点指向，原先指向右子树节点的指针调整为链表中指向后一个节点指针
 * @author geyan
 *
 */
public class Convert {

	public TreeNode convert(TreeNode root) {
		// 用于保存处理过程中的双向链表的尾节点
		TreeNode[] lastNode = new TreeNode[1];
		convertNode(root, lastNode);
		// 找到双向链表的头节点
		TreeNode head = lastNode[0];
		while (head != null && head.left != null) {
			head = head.left;
		}
		return head;
	}

	private void convertNode(TreeNode node, TreeNode[] lastNode) {
		// 节点不为空
		if (node != null) {
			// 如果有左子树就先处理左子树
			if (node.left != null) {
				convertNode(node.left, lastNode);
			}
			// 将当前节点的前驱指向已经处理好的双向链表
			node.left = lastNode[0];
			// 如果左子树转换成的双向链表不为空，设置尾节点的后继
			if (lastNode[0] != null) {
				lastNode[0].right = node;
			}
			// 记录当前节点为尾节点
			lastNode[0] = node;
			// 处理右子树
			if (node.right != null) {
				convertNode(node.right, lastNode);
			}
		}
	}
}
