/**
 * 面试题29：数组中出现次数超过一半的数字
 * 题目描述：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现5次，超过数组的一般，因此输出2.如果不存在则输出0。
 * 
 * 分析： 可以直观想到的有排序，HashMap，但是都不是最优解
 * 
 * @author geyan
 *
 */
public class MoreThanHalfNum {

	/**
	 * 如果数组中存在数字超过一半，那么其出现的次数要大于其他数字出现的次数之和。当我们在遍历数字的时候，需要保存两个值，一个是数组中的数字，
	 * 一个是该数字出现的次数。
	 * 当遍历到下一个数字的时候，如果下一个数字与之前保存的数字相同，则次数+1，否则次数-1.如果次数为0，则重新保存当前数字，次数为1。
	 * 由于要找的数字出现的次数要比其他所有数字出现次数之和还要多，那么要找的数字必定是最后一次把次数设为1时的对应数字。
	 * 最后判断，该数字出现次数是否超过一半。
	 * 
	 * 时间复杂度为O(N)
	 */
	public int moreThanHalfNum(int[] array) {
		if (array == null || array.length <= 0)
			return 0;
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (result == array[i]) {
				times++;
			} else {
				times--;
			}
			if (times == 0) {
				result = array[i];
				times = 1;
			}
		}
		// 检查result是否超过一半
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (result == array[i]) {
				k++;
			}
		}
		if (k * 2 > array.length) {
			return result;
		}
		return 0;
	}
}
