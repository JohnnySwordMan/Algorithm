package LeetCode;

import java.util.*;

/**
 * ��Ŀ����������Ϊһ���ļ�·��������ÿ������ʵ����Ҫ�������Ӧ��filename extension
 * 
 * @author geyan
 *
 */
public class Solution_14 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			// ������Ҫת���ַ�������ֱ��д"."
			String[] strs = str.split("\\.");
			if (strs.length == 1) {
				System.out.print("null");
			} else {
				System.out.println(strs[strs.length - 1]);
			}
		}
	}
}
