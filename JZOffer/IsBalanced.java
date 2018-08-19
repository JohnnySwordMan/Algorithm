import java.util.ArrayList;
import java.util.Stack;

/**
 * ������39���꣺����һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ���������
 * ������ƽ��������Ķ��壺ƽ���������һ�ֶ���������������ÿһ���ڵ�����������������߶Ȳ�С�ڵ���1��
 * �������ж��Ƿ��Ƕ�������������ȥ�ж��Ƿ���ƽ���������
 * @author geyan
 *
 */
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		boolean[] res = new boolean[1];
		// ��ʼƽ��
		res[0] = true;
		boolean flag = isBinarySortTree(root);
		if (flag) {
			// �����Ƕ�������������ȥ�ж��Ƿ��Ƕ���ƽ����
			getHeight(root, 1, res);
			return res[0];
		}
		return true;
	}

	/**
	 * �ж��Ƿ��Ƕ��������� �������ÿ���ڵ㣬����ڵ��ֵһֱ����һ�������Ľڵ�ֵҪ����˵���Ƕ����������������ǡ�
	 * Ϊ�˷���ͬʱ�õ���ǰ�ڵ����һ�������Ľڵ㣬��������������ǵݹ�ʵ�ֽ�Ϊ���ʡ�
	 */
	private boolean isBinarySortTree(TreeNode root) {
		if (root == null)
			return false;
		ArrayList<Integer> al = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				al.add(cur.val);
				cur = cur.right;

			}
		}
		for (int i = 1; i < al.size(); i++) {
			if (al.get(i - 1) > al.get(i))
				return false;
		}
		return true;
	}

	/**
	 * ������������жϸ��ڵ�����������߶Ȳ��Ƿ�С�ڵ���1
	 */
	private int getHeight(TreeNode root, int level, boolean[] res) {
		if (root == null)
			return level;
		int leftHeight = getHeight(root.left, level + 1, res);
		// ��ʼres[0]=true,����߶Ȳ����1����Ϊfalse
		if (!res[0]) {
			return leftHeight;
		}
		int rightHeight = getHeight(root.right, level + 1, res);
		if (!res[0]) {
			return rightHeight;
		}
		if (Math.abs(leftHeight - rightHeight) > 1) {
			// ���������߶Ȳ����1
			res[0] = false;
			return Math.max(leftHeight, rightHeight);
		}
		return Math.max(leftHeight, rightHeight);
	}
}
