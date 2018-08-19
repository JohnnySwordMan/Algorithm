package LeetCode;

import java.util.Scanner;

/**
 * 为了方便用户正确输入需要在输入过程中对用户的输入按照 6+8+4 的格式进行分组， 实现一个方法接收输入过程中的身份证号，返回分组后的字符
 * 
 * @author geyan
 *
 */
public class Solution_15 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			format(str);
		}
	}

	// 100%
	public static void format(String str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			sb.append(str.charAt(i));
		}
		if (str.length() <= 6) {
			System.out.println(sb.toString());
		} else if (str.length() > 6 && str.length() <= 14) {
			// 在下标为6的位置插入空格，不用管原来该位置是否是空格
			sb.insert(6, " ");
			System.out.println(sb.toString());
		} else {
			// 6+1+8=15，所以在下标为15的地方插入空格
			sb.insert(6, " ");
			sb.insert(15, " ");
			System.out.println(sb.toString());
		}
	}

	// 70%
	public static void function_1(String str) {
		StringBuilder sb = new StringBuilder();

		// 首先将输入的字符串中有空格的去掉
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				sb.append(str.charAt(i));
			}
		}
		String newStr = sb.toString();
		// System.out.println(newStr);
		function(newStr);
	}

	public static void function(String str) {
		StringBuilder sb = new StringBuilder();
		if (str.length() <= 6) {
			System.out.println(str);
		} else if (str.length() <= 14) {
			for (int i = 0; i < 6; i++) {
				sb.append(str.charAt(i));
			}
			sb.append(" ");
			for (int i = 6; i < str.length(); i++) {
				sb.append(str.charAt(i));
			}
		} else {
			for (int i = 0; i < 6; i++) {
				sb.append(str.charAt(i));
			}
			sb.append(" ");
			for (int i = 6; i < 14; i++) {
				sb.append(str.charAt(i));
			}
			sb.append(" ");
			for (int i = 14; i < str.length(); i++) {
				sb.append(str.charAt(i));
			}
		}
		System.out.println(sb.toString());
	}
}
