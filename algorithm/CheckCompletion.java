import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ����ȫ�������ж� 
 * ��Ŀ������ ��һ�ö������������һ���㷨�ж����Ƿ�����ȫ��������
 * �����������ĸ��ڵ�root���뷵��һ��boolֵ�������Ƿ�Ϊ��ȫ�����������Ľڵ����С�ڵ���500��
 * 
 * ����ʵ�֣� 
 * 1.���ð�������������ķ�ʽ����ÿ���������ұ����α������нڵ�
 *  2.�����ǰ�ڵ����Һ��ӣ�����û�����ӣ�ֱ�ӷ���false
 * 3.�����ǰ�ڵ㲢�������Һ���ȫ�У���ô֮��Ľڵ���붼ΪҶ�ӽڵ㣬���򷵻�false 
 * 4.�������������������false�����������󷵻�true
 * 
 * ��ôʵ�ֵ�3���� ����һ��flag��ǣ������ǰ�ڵ�����Ӳ�Ϊ�գ�������У�����flagΪfalse��ͬ���ģ������ǰ�ڵ���Һ��Ӳ�Ϊ�գ�������У�����flagΪfalse�� 
 * Ҷ�ӽڵ���жϣ�cur.left != null || cur.right != null��ֻҪ���Һ��ӽڵ���һ����Ϊ�գ���˵������Ҷ�ӽڵ�
 * 
 * @author geyan
 *
 */
public class CheckCompletion {

	public boolean chk(TreeNode root) {
		if (root == null)
			return false;
		// ����Ƿ����Һ���ȫ��
		boolean flag = true;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			// �����ǰ�ڵ����Һ��ӣ���û������
			if (cur.left == null && cur.right != null)
				return false;
			// �����ǰ�ڵ㲻�����Һ���ȫ�У���֮��Ľڵ㲻��Ҷ�ӽڵ�
			if (!flag && (cur.left != null || cur.right != null))
				return false;
			// ���cur.left == null �� cur.right == null����˵��cur�������Һ���ȫ�У���flag = false
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
