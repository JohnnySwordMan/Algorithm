import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ������23���������´�ӡ������(��α���)
 * ��Ŀ�������������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * 
 * ��������α����ı��Σ���α�����ӡ�ڵ㣬��Ҫ�����սڵ�Ĳ�δ�ӡ����������һ�и��ڵ㣬�ڶ��и������Һ���...�ο�algorithm/binaryTree/LevelOrder.java
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
