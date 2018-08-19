package LeetCode;

import java.util.*;

/**
 * 京东笔试题：幸运数
 * 题目描述：小明同学学习了不同的进制之后，拿起了一些数字做起了游戏。小明同学知道，在日常生活中我们最常用的是十进制数，而在计算机中，二进制数也很常用。
 * 现在对于一个数字x，小明同学定义出了两个函数f(x)和g(x)。 f(x)表示把x这个数用十进制写出后各个数位上的数字之和。
 * 如f(123)=1+2+3=6。 g(x)表示把x这个数用二进制写出后各个数位上的数字之和。如123的二进制表示为1111011，那么，g(123)=1+1+1+1+0+1+1=6。 
 * 小明同学发现对于一些正整数x满足f(x)=g(x)，他把这种数称为幸运数，现在他想知道，小于等于n的幸运数有多少个？
 * @author geyan
 *
 */
public class Solution_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (function(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	public static boolean function(int n) {
		int sum1 = 0;
		int temp = n;
		while (n != 0) {
			sum1 += n % 10;
			n /= 10;
		}

		int sum2 = 0;
		while (temp != 0) {
			sum2 += temp % 2;
			temp /= 2;
		}
		return sum1 == sum2 ? true : false;
	}
}