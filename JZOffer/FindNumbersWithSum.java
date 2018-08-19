import java.util.ArrayList;

/**
 * 面试题41：和为s的两个数字
 * 题目描述：输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，输出两个数的乘积最小的。
 * 
 * @author geyan
 *
 */
public class FindNumbersWithSum {
	/**
	 * 方法一：时间复杂度为O(N^2) 两个嵌套for循环，选中第一个数，遍历之后的数，找出和为s的。
	 * 
	 * 方法二：时间复杂度为O(N) 因为是有序的，那么可以使用start,end指针分别指向第一个和最后一个位置, 
	 * 1.如果a[start] + a[end] > sum，end指针前移 
	 * 2.如果a[start] + a[end] < sum，start指针后移 
	 * 3.如果a[start] + a[end] == sum，则start后移，end前移，因为可能存在多对这样的情况。这一步，不需要start++,end--啦，因为在两个数差值越大，其乘积最小
	 * 4.重复上述操作
	 */
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> al = new ArrayList<>();
		if (array == null || array.length <= 0) {
			return al;
		}
		int start = 0, end = array.length - 1;
		while (start <= end) {
			if ((array[start] + array[end]) > sum) {
				end--;
			} else if ((array[start] + array[end]) < sum) {
				start++;
			} else {
				// a[start] + a[end] ==
				// sum，其实不需要start++,end--的，因为数组是递增的，当两个数差值越大，乘积越小
				al.add(array[start]);
				al.add(array[end]);
				// 退出循环
				break; 
			}
		}
		return al;
	}
}
