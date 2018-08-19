/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes，否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author geyan
 *
 */
public class VerifySquenceOfBST {

	/**
	 * 如果数组元素是后序遍历的结果，那么最后一个元素是根节点。 1、确定root；
	 * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
	 * 3、遍历右子树，若发现有小于root的值，则直接返回false； 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
	 */
	public boolean verifySquenceOfBST_1(int[] a, int n) {
		if (a == null || n <= 0)
			return false;
		int root = a[n - 1];
		int i = 0;
		for (; i < n - 1; i++) {
			if (a[i] > root)
				break;
		}
		// 此时a[i]大于根节点，表示i以及i之后的元素应该是右子树，接下来判断下
		int j = i;
		for (; j < n - 1; j++) {
			if (a[j] < root)
				return false;
		}

		boolean left = true;
		if (i > 0) {
			left = verifySquenceOfBST_1(a, i);
		}

		boolean right = true;
		if (j < n - 1) {
			right = verifySquenceOfBST_1(a, n - 1 - i);
		}
		return left && right;
	}

	// 方法二，方法一写法不好
	public boolean verifySquenceOfBST_2(int[] a, int start, int end) {
		if (a == null || a.length <= 0) {
			return false;
		}
		
		int root = a[end];
		int i = 0;
		for (; i < end; i++) {
			if (a[i] > root) {
				break;
			}
		}

		int j = i;
		for (; j < end; j++) {
			if (a[j] < root) {
				return false;
			}
		}

		// 递归左右两部分
		boolean left = true;
		if (i > start) {
			left = verifySquenceOfBST_2(a, start, i - 1);
		}

		boolean right = true;
		if (j < end) {
			right = verifySquenceOfBST_2(a, j, end - 1);
		}
		return left && right;
	}
}
