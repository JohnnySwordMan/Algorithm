package LeetCode;

/**
 * 题目：位运算
 * @author geyan
 *
 */
public class SingleNumber {

	/**
	 * 给定数组，数组中只有一个元素出现一次，其他元素都出现两次
	 */
	public int singleNumber_1(int[] arr) {
		if (arr == null || arr.length <= 0) {
			return 0;
		}
		int res = arr[0];
		for (int i = 1; i < arr.length; i++) {
			res = res ^ arr[i];
		}
		return res;
	}

	/**
	 * 给定数组，数组中只有一个元素出现一次，其他元素都出现3次
	 * 方法一：也可以利用位运算来消除重复3次的数。
	 * 以一个数组[14,14,14,9]为例，将每个数字以二进制表达： 
	 * 1110 
	 * 1110 
	 * 1110
	 * 1001
	 * 
	 * ———————— 
	 * 4331 对每一位求和 
	 * 1001 对每一位的和做%3运算，来消除重复3次的数
	 */
	public int singleNumber_2(int[] A) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			// mask, 第i位为1，其他位都为0
			int c = 0, mask = 1 << i; 
			for (int j = 0; j < A.length; j++) {
				int val = (A[j] & mask);
				// 如果该数在这一位上为1，计数器就加一
				// val<0不能忘记，因为负数在内存中以补码的形式存放。
				if (val > 0 || val < 0) { 
					c++;
				}
			}
			// 这一位的计数除以3取余数，在这里只可能为0或1
			if (c % 3 > 0) 
				res |= mask;
		}
		return res;
	}

	/**
	 * 给定数组，数组中只有一个元素出现一次，其他元素都出现三次
	 * 分析：用三个变量分别记录出现一次的数，出现两次的数和出现三次的数。
	 * 出现一次ones的数计算方法和I是一样的，异或就行了。
	 * 出现两次twos的条件是ones中有该数，而该数又出现了。
	 * 出现三次threes的条件是即出现在ones里又出现twos里。
	 * 如果一个数出现了3次，我们就要把ones和twos中清除该数。
	 */
	public int singleNumber_3(int[] A) {
		int ones = 0, twos = 0, threes = 0;
		for (int i = 0; i < A.length; i++) {
			// 出现两次twos的条件是ones中有该数，而该数又出现了
			twos |= ones & A[i];
			// 出现一次ones的数计算方法和I是一样的，异或就行了
			ones ^= A[i];
			// 出现三次threes的条件是即出现在ones里又出现twos里
			threes = ones & twos;
			// 将出现三次的数从ones和twos中去除
			twos &= ~threes;
			ones &= ~threes;
		}
		return ones;
	}

	/**
	 * 给定数组，数组中有两个元素出现一次，其他元素都出现两次
	 */
	public String singleNumber_4(int[] A) {
		if (A == null || A.length <= 0) {
			return null;
		}
		int res = A[0];
		for (int i = 1; i < A.length; i++) {
			res ^= A[0];
		}
		int index = 0;
		// res为只出现一次的数的异或结果，所以必定不是0，即可以根据该数二进制位上位1的位置，来将数组分成两部分
		// 那就以res的二进制从左开始第一次出现1的位置来将数组分成两部分
		while ((res & 1) == 0) {
			res = res >> 1;
			index++;
		}
		int res1 = 0, res2 = 0;
		// 根据元素的二进制的第index位是否为1，可以将array数组分成两个数组
		// 只出现一次的数字必定会分到这两个数组中，不可能同时在一个数组里，且出现两次的数字必定全在同一个数组里，所以问题就会变成在一个数组中找出只出现一次的数字。
		for (int i = 0; i < A.length; i++) {
			if (isBit1(A[i], index)) {
				res1 ^= A[i];
			} else {
				res2 ^= A[i];
			}
		}
		return res1 + "," + res2;
	}

	// 判断数字num在第index位上是否为1
	private boolean isBit1(int num, int index) {
		num = num >> index;
		return (num & 1) == 1 ? true : false;
	}
}
