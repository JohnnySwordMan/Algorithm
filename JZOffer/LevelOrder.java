import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * ��Ŀ���Ѷ�������ӡ�ɶ���(��α���)
 * ��Ŀ���������ϵ��°����ӡ��������ͬһ��ڵ�������������ÿһ�����һ�С�
 * 
 * @author geyan
 *
 */
public class LevelOrder {
	
	/**
	 * �ѵ����ڣ�ʲôʱ����
	 * ʵ�֣�������������last��nlast��last��ʾ���ڴ�ӡ�ĵ�ǰ�е����ҽڵ㣻nlast��ʾ��һ�е����ҽڵ�
	 * ÿһ������ұ��������������last�ڵ㣬���У�����֮����last = nlast���ظ��������輴�ɡ�
	 * nlast�����ټ�¼��α���ÿ���¼�����еĽڵ㼴�ɡ�
	 */
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
		// �ڱ�������ʱ��һ�㶼�����ýڵ���ӵ����л���ջ�У�Ȼ������л�ջ��ʱ����ȥ���о�����߼�
		queue.offer(pRoot);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			al.add(cur.val);
			// ����������Ϊ�գ��������У�����nlast��ֵ
			if (cur.left != null) {
				queue.offer(cur.left);
				nlast = cur.left;
			}
			// ����������Ϊ��
			if (cur.right != null) {
				queue.offer(cur.right);
				nlast = cur.right;
			}
			// ����Ѿ���������ǰ�е����ҽڵ㣬����
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
