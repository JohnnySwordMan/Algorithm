package LeetCode;

import java.util.Scanner;

/**
 * 题目：字符串中找出连续最长的数字串
 * 
 * 分析：
 * 定义两个变量count和max，count记录连续的数字个数，max记录最大的连续的数字个数。
 * 定义变量end，记录下最大的连续的数字串的最后一个。
 * 遍历字符串，如果是数字，count++，同时更新max值，记录下最大的连续的数字串的最后一个
 * @author geyan
 *
 */
public class Solution_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			getMaxStr(str);
		}
	}

	public static void getMaxStr(String str) {
		int max = 0;
		int count = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				// 计算数字出现的个数
				count++;
				if (max < count) {
					// 更新最大值
					max = count;
					// end指向的是最大连续数字的最后一位
					end = i;
				}
			} else {
				// 如果是字符，则重新计数
				count = 0;
			}
		}
		System.out.println(str.substring(end - max + 1, end + 1));
	}
}
