import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：完全二叉树判断 
 * 题目描述： 有一棵二叉树，请设计一个算法判断它是否是完全二叉树。
 * 给定二叉树的根节点root，请返回一个bool值代表它是否为完全二叉树。树的节点个数小于等于500。
 * 
 * 具体实现： 
 * 1.采用按层遍历二叉树的方式，从每层的左边向右边依次遍历所有节点
 *  2.如果当前节点有右孩子，但是没有左孩子，直接返回false
 * 3.如果当前节点并不是左右孩子全有，那么之后的节点必须都为叶子节点，否则返回false 
 * 4.遍历过程中如果不返回false，遍历结束后返回true
 * 
 * 怎么实现第3步？ 设置一个flag标记，如果当前节点的左孩子不为空，则进队列，否则flag为false，同样的，如果当前节点的右孩子不为空，则进队列，否则flag为false。 
 * 叶子节点的判断？cur.left != null || cur.right != null，只要左右孩子节点有一个不为空，则说明不是叶子节点
 * 
 * @author geyan
 *
 */
public class CheckCompletion {

	public boolean chk(TreeNode root) {
		if (root == null)
			return false;
		// 标记是否左右孩子全有
		boolean flag = true;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			// 如果当前节点有右孩子，而没有左孩子
			if (cur.left == null && cur.right != null)
				return false;
			// 如果当前节点不是左右孩子全有，且之后的节点不是叶子节点
			if (!flag && (cur.left != null || cur.right != null))
				return false;
			// 如果cur.left == null 或 cur.right == null，则说明cur不是左右孩子全有，则flag = false
			if (cur.left != null) {
				q.offer(cur.left);
			} else {
				flag = false;
			}
			if (cur.right != null) {
				q.offer(cur.right);
			} else {
				flag = false;
			}
		}
		return true;
	}
}
