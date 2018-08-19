package LeetCode;

import java.util.*;

/**
 * 题目：给定一个英文字符串,请写一段代码找出这个字符串中首先出现三次的那个英文字符。
 * @author geyan
 *
 */
public class Solution_16 {
	public static void main(String[] args) {
		/*
		 * Scanner input = new Scanner(System.in); while (input.hasNext()) {
		 * String str = input.nextLine(); function(str); }
		 */
		String str = "Have you ever gone shopping and";
		function(str);
	}

	public static void function(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
				if (!map.containsKey(c[i])) {
					map.put(c[i], 1);
				} else {
					map.put(c[i], map.get(c[i]) + 1);
				}
				// 在遍历的过程中，只要发现字符出现次数等于3，就停止遍历，不需要等遍历完一次，第二次遍历的时候再去判断
				if (map.get(c[i]) == 3) {
					System.out.println(c[i]);
					break;
				}
			}
		}
	}
}