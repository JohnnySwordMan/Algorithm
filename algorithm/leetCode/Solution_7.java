package LeetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 题目：删除公共字符 
 * 题目描述：输入两个字符串，从第一字符串中删除第二个字符串中所有的字符。例如，输入”They are students.”和”aeiou”，则删除之后的第一个字符串变成”Thy r stdnts.”
 * 
 * @author geyan
 *
 */
public class Solution_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str1 = input.nextLine();
			String str2 = input.nextLine();
			System.out.println(function_1(str1, str2));
		}
	}

	// 使用Set集合，将str2字符串中字符存入set集合中，遍历str1字符串中的字符，判断是否存在set集合中，存在，则不添加到sb中，注意空格不算。
	public static String function_1(String str1, String str2) {
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < c2.length; i++) {
			set.add(c2[i]);
		}

		for (int i = 0; i < c1.length; i++) {
			if (set.contains(c1[i]) && c1[i] != ' ') {
				continue;
			}
			sb.append(c1[i]);
		}
		return sb.toString();
	}
}
