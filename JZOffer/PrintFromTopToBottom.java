import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题23：从上往下打印二叉树(层次遍历)
 * 题目描述：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 
 * 举例：层次遍历的变形，层次遍历打印节点，需要将按照节点的层次打印出来，即第一行根节点，第二行根的左右孩子...参考algorithm/binaryTree/LevelOrder.java
 * @author geyan
 *
 */
public class PrintFromTopToBottom {

	public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> al = new ArrayList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			al.add(cur.val);
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}
		return al;
	}
}
