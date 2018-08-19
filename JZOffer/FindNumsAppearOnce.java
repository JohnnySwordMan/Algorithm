/**
 * 面试题40：数组中只出现一次的数字
 * 题目描述：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度为O(N)，空间复杂度为O(1)
 * 
 * @author geyan
 *
 */
public class FindNumsAppearOnce {

	public static void main(String[] args) {
		int[] array = { 2, 2, 3, 2, 3, 4, 5, 4, 5 };
		System.out.print(findNumAppearOnce(array));
	}

	/**
	 * 引申：给定一数组，该数组中只有一个数出现过一次，其他的都出现2次。 n与0异或->n n与n异或->0 异或运算满足交换律和结合律
	 * 如果是只有一个数出现奇数次，其他数出现过偶数次，都可以这样写。
	 * 
	 * @param array
	 */
	public static int findNumAppearOnce(int[] array) {
		int res = 0;
		for (int i = 0; i < array.length; i++) {
			res ^= array[i];
		}
		return res;
	}

	/**
	 * 有两个数只出现过一次，其他数出现过两次
	 * 
	 * @param array
	 *            给定数组
	 * @param num1
	 *            num1[0]只出现过一次的数
	 * @param num2
	 *            num2[0]只出现过一次的数
	 */
	public void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		if (array == null || array.length <= 0)
			return;
		int res = array[0];
		for (int i = 1; i < array.length; i++) {
			res ^= array[i];
		}

		int index = 0;
		// 此时res为两个只出现一次的数的异或结果，所以必定不为0，那么找出该值二进制上为1的位置
		while ((res & 1) == 0) {
			res = res >> 1; // 左移1位
			index++;
		}

		num1[0] = 0;
		num2[0] = 0;
		// 根据元素的二进制的第index位是否为1，可以将array数组分成两个数组
		// 只出现一次的数字必定会分到这两个数组中，不可能同时在一个数组里，且出现两次的数字必定全在同一个数组里，所以问题就会变成在一个数组中找出只出现一次的数字。
		for (int i = 0; i < array.length; i++) {
			if (isBit1(array[i], index)) {
				num1[0] ^= array[i];
			} else {
				num2[0] ^= array[i];
			}
		}
	}

	/**
	 * 定义一个方法，判断数字num在第index位上是否为1
	 */
	private boolean isBit1(int num, int index) {
		num = num >> index;
		return (num & 1) == 1 ? true : false;
	}
}
