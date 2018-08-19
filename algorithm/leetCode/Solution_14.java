package LeetCode;

import java.util.*;

/**
 * 题目：输入数据为一个文件路径，对于每个测试实例，要求输出对应的filename extension
 * 
 * @author geyan
 *
 */
public class Solution_14 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			// 这里需要转义字符，不能直接写"."
			String[] strs = str.split("\\.");
			if (strs.length == 1) {
				System.out.print("null");
			} else {
				System.out.println(strs[strs.length - 1]);
			}
		}
	}
}
