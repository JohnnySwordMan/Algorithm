package LeetCode;

/**
 * 题目：将有序数组转换成平衡二叉树。 同有序链表转换平衡二叉树/algorithm/LeetCode/SortedListToBST.java
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
		// end是可以取到的，一般不可以取到的话，用end-start，mid应该代表数组元素个数的一般处
		int mid = start + (end - start + 1) / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = toBST(num, start, mid - 1);
		root.right = toBST(num, mid + 1, end);
		return root;
	}
}
