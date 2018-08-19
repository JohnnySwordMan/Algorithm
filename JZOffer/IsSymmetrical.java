/**
 * ��Ŀ���ԳƵĶ�����
 * ��Ŀ��������ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
 * 
 * �����������жϸ��ڵ�����������Ƿ���ȣ������ȣ����ж����������������������������������������������������������������Ƿ����
 * @author geyan
 *
 */
public class IsSymmetrical {

	public boolean isSymmtrical(TreeNode root) {
		if (root == null) {
			return true;
		}
		return comRoot(root.left,root.right);
	}

	private boolean comRoot(TreeNode left, TreeNode right) {
		if (left == null) {
			return right == null;
		}
		if (right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return comRoot(left.right, right.left) && comRoot(left.left, right.right);
	}
}
