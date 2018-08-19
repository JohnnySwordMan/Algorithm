/**
 * 面试题32：从1到n整数中1出现的次数 
 * 题目描述：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11，12
 * 
 * @author geyan
 *
 */
public class NumberOf1Between1AndN {

	/**
	 * 方法一：不考虑时间效果。判断一个整数各个位置上是否为1
	 * 
	 * @param n
	 * @return
	 */
	public int numberOf1Between1AndN_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			count += numberOf1_1(i);
		}
		return count;
	}

	// 判断给定的整数n的各个位置上是否为1
	private int numberOf1_1(int n) {
		int count = 0;
		while (n != 0) {
			if (n % 10 == 1) {
				// 说明个位是否为1
				count++;
			}
			// 判断十位上是否为1
			n /= 10;
		}
		return count;
	}

}
