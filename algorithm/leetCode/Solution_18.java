package LeetCode;

import java.util.*;


/**
 * 京东笔试题：进制均值
 * 题目描述：尽管是一个CS专业的学生，小B的数学基础很好并对数值计算有着特别的兴趣，喜欢用计算机程序来解决数学问题，现在，她正在玩一个数值变换的游戏。
 * 她发现计算机中经常用不同的进制表示一个数，如十进制数123表达为16进制时只包含两位数7、11（B），用八进制表示为三位数1、7、3，按不同进制表达时，各个位数的和也不同，
 * 如上述例子中十六进制和八进制中各位数的和分别是18和11,。 小B感兴趣的是，一个数A如果按2到A-1进制表达时，各个位数之和的均值是多少？
 * 她希望你能帮她解决这个问题？ 所有的计算均基于十进制进行，结果也用十进制表示为不可约简的分数形式。
 * @author geyan
 *
 */
public class Solution_18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int num = input.nextInt();
			int sum = 0;
			for (int i = 2; i < num; i++) {
				// 转换进制
				sum += function(num, i);
			}
			int k = num - 2;
			getgcd(sum, k);
		}
	}

	public static int function(int num, int k) {
		int res = 0;
		while (num != 0) {
			res += num % k;
			num /= k;
		}
		return res;
	}

	// 简化分数，从k开始，而不是从2开始。
	public static void getgcd(int num, int k) {
		for (int i = k; i > 1; i--) {
			if (num % i == 0 && k % i == 0) {
				num = num / i;
				k = k / i;
				break;
			}
		}
		System.out.println(num + "/" + k);
	}
}
