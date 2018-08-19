/**
 * ��Ŀ��ƽ��������ж� 
 * ��Ŀ��������һ�ö������������һ���㷨�ж���ö������Ƿ�Ϊƽ���������
 * �����������ĸ��ڵ�root���뷵��һ��boolֵ������������Ƿ�Ϊƽ���������
 * 
 * �������ж��Ƿ���ƽ���������ͨ�����������ʵ�֣����жϸ��ڵ�root�Ķ������Ƿ�ƽ�⣬�������ж�root���������Ƿ�ƽ�⣬�����ƽ�⣬��ֱ�ӷ��أ�
 * ���ƽ�⣬������ж�root���������Ƿ�ƽ�⡣���ж�root���������Ƿ�ƽ���ʱ�������ظ��������̣�����ʹ�õݹ�ķ�ʽ��
 * 
 * �޸ģ��ж�ƽ���������Ӧ�������ж��Ƿ��Ƕ������������ο�/JZOffer/IsBalanced.java
 * @author geyan
 *
 */
public class CheckBalance {

	public boolean check(TreeNode root) {
		// ��������������Ϊƽ���ǣ����ֱ�Ӷ����boolean��ͨ��ֵ���ݵķ�ʽ����ôgetHeight�����ж�boolean��ǵ��޸ģ�ֻ�������ڷ����ڡ�
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(root, 1, res);
		return res[0];
	}

	private int getHeight(TreeNode node, int level, boolean[] res) {
		if (node == null)
			return level;
		// ͨ���ݹ鷽ʽ���ж�������
		int leftHeight = getHeight(node.left, level + 1, res);
		// ����ڱ����������������޸���ƽ���ǣ���ô��������ƽ�⣬���ظ߶�
		if (!res[0])
			return leftHeight;
		// ͨ���ݹ鷽ʽ���ж�������
		int rightHeight = getHeight(node.right, level + 1, res);
		// ����ڱ����������������޸���ƽ���ǣ���ô��������ƽ�⣬���ظ߶�
		if (!res[0])
			return rightHeight;
		// ��������������ƽ��ģ��������������Ƚ��бȽϣ��жϵ�ǰ���Ϊ���������Ƿ�ƽ��
		if (Math.abs(leftHeight - rightHeight) > 1) {
			res[0] = false;
			return Math.max(leftHeight, rightHeight);
		}
		return Math.max(leftHeight, rightHeight);
	}
}
