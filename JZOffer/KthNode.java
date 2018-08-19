import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ�������������ĵ�k���ڵ�
 * ��Ŀ����������һ�ö��������������ҳ����еĵ�k��Ľڵ㡣
 * 
 * �������������
 * @author geyan
 *
 */
public class KthNode {

	// �������������ȥ�������飬�ҳ���k����С
	public TreeNode kthNode(TreeNode pRoot, int k) {
		ArrayList<TreeNode> al = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (pRoot == null) {
			return pRoot;
		}
		if (k <= 0) {
			return null;
		}
		TreeNode cur = pRoot;
		while (!stack.empty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				al.add(cur);
				cur = cur.right;
			}
		}
		if (al.size() < k) {
			return null;
		}
		// �ҳ���k����С�ڵ�ֵ
		return al.get(k - 1);
	}
}
