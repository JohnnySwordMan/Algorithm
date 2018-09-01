/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 题目描述：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes，否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * @author geyan
 *
 */
public class VerifySquenceOfBST {

	/**
	 * 如果数组元素是后序遍历的结果，那么最后一个元素是根节点。 
	 * 1、确定root；
	 * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
	 * 3、遍历右子树，若发现有小于root的值，则直接返回false； 
	 * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
	 */
	public boolean verifySquenceOfBST(int[] a){
		if(a == null || a.length == 0){
			return false;
		}
		if(a.length == 1){
			return true;
		}
		return judge(a,0,a.length-1);
	}

	public boolean judge(int[] a, int start, int end) {
		// 遍历完数组的一部分，没有报错，则返回true
		if(start >= end){
			return true;
		}
		int root = a[end];
		int i = start;
		while(a[i] < root){
			i++;
		}
		// a[j]大于root
		int j = i;
		while(j < end){
			if(a[j] < root){
				// 右子树中存在小于根结点的值，说明不是二叉搜索树
				return false;
			}
			j++;
		}
		// 递归左右两部分
		boolean left = judge(a,start,i-1);
		boolean right = judge(a,i,end-1);
		return left && right;
	}
}
