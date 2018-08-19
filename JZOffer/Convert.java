/**
 * ������27��������������˫������
 * ��Ŀ����������һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽڵ㣬ֻ�ܵ������нڵ�ָ���ָ��
 * 
 * ������
 * �������������ԭ��ָ���������ڵ��ָ�����Ϊ������ָ��ǰһ���ڵ�ָ��ԭ��ָ���������ڵ��ָ�����Ϊ������ָ���һ���ڵ�ָ��
 * @author geyan
 *
 */
public class Convert {

	public TreeNode convert(TreeNode root) {
		// ���ڱ��洦������е�˫�������β�ڵ�
		TreeNode[] lastNode = new TreeNode[1];
		convertNode(root, lastNode);
		// �ҵ�˫�������ͷ�ڵ�
		TreeNode head = lastNode[0];
		while (head != null && head.left != null) {
			head = head.left;
		}
		return head;
	}

	private void convertNode(TreeNode node, TreeNode[] lastNode) {
		// �ڵ㲻Ϊ��
		if (node != null) {
			// ��������������ȴ���������
			if (node.left != null) {
				convertNode(node.left, lastNode);
			}
			// ����ǰ�ڵ��ǰ��ָ���Ѿ�����õ�˫������
			node.left = lastNode[0];
			// ���������ת���ɵ�˫������Ϊ�գ�����β�ڵ�ĺ��
			if (lastNode[0] != null) {
				lastNode[0].right = node;
			}
			// ��¼��ǰ�ڵ�Ϊβ�ڵ�
			lastNode[0] = node;
			// ����������
			if (node.right != null) {
				convertNode(node.right, lastNode);
			}
		}
	}
}
