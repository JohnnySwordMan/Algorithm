package LeetCode;

/**
 * ��Ŀ������������ת����ƽ��������� ͬ��������ת��ƽ�������/algorithm/LeetCode/SortedListToBST.java
 * 
 * @author geyan
 *
 */
public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length <= 0) {
			return null;
		}
		return toBST(num, 0, num.length - 1);
	}

	private TreeNode toBST(int[] num, int start, int end) {
		if (start > end) {
			return null;
		}
		if (start == end) {
			return new TreeNode(num[start]);
		}
		// end�ǿ���ȡ���ģ�һ�㲻����ȡ���Ļ�����end-start��midӦ�ô�������Ԫ�ظ�����һ�㴦
		int mid = start + (end - start + 1) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = toBST(num, start, mid - 1);
		root.right = toBST(num, mid + 1, end);
		return root;
	}
}
