/**
 * 题目：面试题31：连续子数组的最大和
 * 题目描述：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(N)
 * 
 * @author geyan
 *
 */
public class FindGreatestSumOfSubArray {

	/**
	 * cur:当前数组元素和 res:存储最大的元素和 分析：初始，令res = cur = array[0]， 开始遍历数组元素，cur =
	 * cur+array[i]，如果cur
	 * <0，那么重置cur为0，抛弃前面的元素，如果cur>res，说明此时的cur要大于之前保存的最大元素和，重置res
	 */
	public int findGreatestSumOfSubArray_1(int[] array) {
		if (array == null || array.length < 0)
			return 0;
		int cur = array[0];
		int res = cur;
		for (int i = 1; i < array.length; i++) {
			// 如果当前数组元素和小于0，则重置cur，抛弃前面的数组元素
			if (cur < 0)
				cur = 0;
			cur = cur + array[i];
			if (cur > res)
				res = cur;
		}
		return res;
	}

	/**
	 * 令curSum为当前最大子数组和，maxSum为最大子数组和
	 * 以第i个元素结尾，可以有两种选择，要么是放入前面的子数组中，curSum+array[i]，要么成为新的子数组的第一个元素array[i]
	 */
	public int findGreatestSumOfSubArray_2(int[] array) {
		if (array == null || array.length < 0)
			return 0;
		int curSum = array[0];
		int maxSum = curSum;
		for (int i = 1; i < array.length; i++) {
			curSum = Math.max(curSum + array[i], array[i]);
			maxSum = Math.max(maxSum, curSum);
		}
		return maxSum;
	}
}
