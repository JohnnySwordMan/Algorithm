import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ����һ�ö������������һ���㷨�����ղ�δ�ӡ��ö�������
 * �����������ĸ����root���뷵�ش�ӡ������������ÿһ��һ��������д洢�����������˳���ղ����������£���ÿһ���������Ԫ�ذ��մ����������С�
 * ��֤�����С�ڵ���500��
 * 
 * �������ѵ�����ж�ʲôʱ��û��� last��ʾ���ڴ�ӡ�ĵ�ǰ�е����ҽ�㣬nlast��ʾ��һ�е����ҽ�㡣
 * ����ÿһ��������ұ��������������last��㣬��ʾ�û����ˣ�����֮��ֻҪ��last = nlast���ɣ��ظ��������衣
 * --->��ô�������ˣ������ȷ�ظ���last��nlast�أ���ʵֻ��Ҫ��nlast���ټ�¼������ȱ���(��α���)���¼�����еĽ�㡣
 * ������Ϊ���¼�����еĽ��һ������һ�����ҽ�㡣
 * 
 * 
 * @author geyan
 *
 */
public class LevelOrder {

	public static void main(String[] args) {
	}

	public static int[][] printTree(TreeNode root) {
		if (root == null)
			return null;
		// ��������е��б�ÿһ�д�ŵ���ArrayList����
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

		// ���ÿһ��Ԫ�ص�����
		ArrayList<Integer> array = new ArrayList<>();

		// ����ʵ��
		Queue<TreeNode> queue = new LinkedList<>();

		// ����last
		TreeNode last = root;
		TreeNode nlast = null;

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			array.add(current.val);
			if (current.left != null) {
				// nlast��ʾ���¼�����еĽ��
				nlast = current.left;
				queue.offer(current.left);
			} /*
				 * else if (current.right != null) { // ������ô������else��else��ʾ����ѡ��һ
				 * 
				 * queue.offer(current.right); nlast = current.right; }
				 */

			if (current.right != null) { // ������ô������else��else��ʾ����ѡ��һ
				nlast = current.right;
				queue.offer(current.right);
			}

			if (current == last) {
				last = nlast;
				arrayList.add(array);
				array = new ArrayList<>();
			}
		}

		// ���������󣬽�arrayListת���ɶ�ά�������ʽ
		int[][] result = new int[arrayList.size()][];
		for (int i = 0; i < arrayList.size(); i++) {
			result[i] = new int[arrayList.get(i).size()];
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = arrayList.get(i).get(j);
			}
		}
		return result;
	}

	// �������Ĳ�α�����������ͼ�Ŀ�����ȱ���
	public static void levelIterator(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode cur = null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			System.out.print(cur.val + " ");
			if (cur.left != null) {
				queue.offer(cur.left);
			}
			// ����ͬ��������else��
			if (cur.right != null) {
				queue.offer(cur.right);
			}
		}
	}

}

/**
 * �Զ���������Ľ���� ֵ����������
 * 
 * @author geyan
 *
 */
class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}
