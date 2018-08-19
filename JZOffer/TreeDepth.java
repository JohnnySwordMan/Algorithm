/**
 * ������39������������� 
 * ��������������һ�ö������ĸ��ڵ㣬���������ȡ�
 * 
 * @author geyan
 *
 */
public class TreeDepth {

	/**
	 * ������ 
	 * ���һ�ö�����ֻ�и��ڵ㣬�߶�Ϊ1; 
	 * ������ڵ�ֻ����������û�������������������߶�+1;
	 * ������ڵ�ֻ����������û�������������������߶�+1; 
	 * ������ڵ�����������������������������������߶ȵĽϴ�ֵ+1
	 */
	public int treeDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = treeDepth(root.left);
		int right = treeDepth(root.right);
		return left > right ? left + 1 : right + 1;
	}
}
