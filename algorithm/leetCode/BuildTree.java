package LeetCode;

/**
 * ��Ŀ����������ͺ��򹹽�������
 * 
 * ������������򹹽����������ο�/algorithm/JZOffer/ReConstructBinaryTree.java
 * @author geyan
 *
 */
public class BuildTree {
	// ֮ǰ��������������������������������ͺ����������
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null) {
			return null;
		}
		return buildTreeCore(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTreeCore(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		// �����ݹ�
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		// ���ڵ�
		TreeNode root = new TreeNode(postorder[postEnd]);
		// ���ݸ��ڵ㣬�ҳ���������
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == postorder[postEnd]) {
				root.left = buildTreeCore(inorder, inStart, i - 1, postorder, postStart, postStart + i - 1 - inStart);
				root.right = buildTreeCore(inorder, i + 1, inEnd, postorder, postStart + i - inStart, postEnd - 1);
			}
		}
		return root;
	}
}
