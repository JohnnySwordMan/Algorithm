package LeetCode;

/**
 * ��Ŀ��minimum-depth-of-binary-tree 
 * ��Ŀ������Given a binary tree, find its minimum
 * depth.The minimum depth is the number of nodes along the shortest path from
 * the root node down to the nearest leaf node.
 * 
 * ������Ҫ����Ӹ��ڵ㵽��Ҷ�ӽڵ�����·��
 * 1.�ݹ飬����������0
 * 2.��������Ϊ�գ��򷵻�����������С���+1
 * 3.��������Ϊ�գ��򷵻�����������С���+1
 * 4.��������������Ϊ�գ��򷵻�����������С��ȵĽ�Сֵ+1
 * 
 * ������һ������ķ��������leftHeight==0 ��rightHeight==0��˵��Ҫôֻ�и��ڵ㣬Ҫô���ڵ�ֻ����������������������ô���ֻ��������������������С���+1�����ֻ��������������������С���+1��
 * ���Ϸ��� leftHeight + rightHeight + 1����
 * @author geyan
 *
 */
public class Solution_1 {

	public int run(TreeNode root) {
		if (root == null)
			return 0;
		int leftHeight = run(root.left);
		int rightHeight = run(root.right);
		if (leftHeight == 0 || rightHeight == 0)
			// return 1;
			return leftHeight + rightHeight + 1;
		return Math.min(leftHeight, rightHeight) + 1;
	}
}
