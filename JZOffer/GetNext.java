package JZOffer;

/**
 * 题目：二叉树的下一个节点
 * 题目描述：给定一个二叉树和其中的一个节点，请找出中序遍历顺序的下一个节点并且返回。注意，树中的节点不仅包含左右子节点，同时包含指向父节点的指针。
 * 
 * 分析：
 * 1.二叉树为空，则返回空
 * 2.如果该节点有右子树，那么下一个节点就是它的右子树中的最左子节点
 * 3.如果该节点没有右子树，如果该节点是其父节点的左子树节点，那么下一个节点就是其父节点
 * 4.如果该节点没有右子树，如果该节点是其父节点的右子树节点，那么可以沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点，
 * 如果这样的节点存在，那么这个节点的父节点就是要找的下一个节点
 * @author geyan
 *
 */
public class GetNext {

	public TreeLinkNode getNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		// 保存要查找的下一个节点
		TreeLinkNode target = null;
		// 情况1：如果该节点的右子树不为空，则要找的节点就是该节点的右子树中的最左节点
		if (pNode.right != null) {
			target = pNode.right;
			while (target.left != null) {
				target = target.left;
			}
			// 返回target，即我们要找的该节点在中序遍历顺序中的下一个节点
			return target;
		}
		// 节点没有右子树，向上遍历
		else if (pNode.parent != null) {
			target = pNode.parent;
			// cur是target的子节点
			TreeLinkNode cur = pNode;
			while (target != null && target.left != cur) {
				// 该节点没有右子树，其次该节点是其父节点的右子树节点
				// 沿着指向父节点的指针一直向上遍历，直到找到一个是它父节点的左子节点的节点，
				// 如果这样的节点存在，则该节点的父节点就是我们要找的下一个节点
				cur = target;
				target = target.parent;
			}
			return target;
		}
		return null;
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode parent = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}