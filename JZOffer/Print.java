import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * ��Ŀ���Ѷ�������ӡ�ɶ���(��α������ο�/algorithm/binaryTree/LevelOrder.java)
 * ��Ŀ���������ϵ��°����ӡ��������ͬһ��ڵ�������������ÿһ�����һ�С�
 * 
 * @author geyan
 *
 */
public class Print {
	public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
		ArrayList<Integer> al = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(pRoot == null){
			return arrayList;
		}
		// ����last
		TreeNode last = pRoot;
		TreeNode nlast = null;
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			al.add(cur.val);
			if (cur.left != null) {
				queue.offer(cur.left);
				nlast = cur.left;
			}
			if (cur.right != null) {
				queue.offer(cur.right);
				nlast = cur.right;
			}
			if(cur == last){
				// ����
				last = nlast;
				arrayList.add(al);
				al = new ArrayList<>(); 
			}
		}
		return arrayList;
	}
}
