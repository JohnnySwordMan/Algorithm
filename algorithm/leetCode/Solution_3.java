package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ��Ŀ�����ף���ɫ��ש��
 * ��Ŀ������С����һЩ��ɫ��ש�顣ÿ����ɫ��һ����д��ĸ��ʾ��������ɫש�鿴��������ȫһ����������һ���������ַ���s,s��ÿ���ַ�����С�׵�ĳ��ש�����ɫ��
 * С����������е�ש���ų�һ�С����������һ�Բ�ͬ��ɫ������ש��,��ô����ש��ͺ�Ư���ġ�
 * �������С�׼����ж����ַ�ʽ��������ש���ų�Ư����һ�С�(������ַ�ʽ����Ӧ��ש����ɫ��������ͬ��,��ô��Ϊ�����ַ�ʽ��һ���ġ�)
 * ����: s = "ABAB",��ôС�����������еĽ��:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 * ����ֻ��"AABB"��"BBAA"�������ֻ��һ�Բ�ͬ��ɫ������ש�顣
 * 
 * ���һ����������ʾС�׿����ж����ַ�ʽ
 * 
 * ��������Ŀ����Խ�Ǹ��ӣ���Խ�򵥣���Ҫ���ֶ��ŵ��ˣ�
 * ��ʵֻҪ�ж��ַ������ж����ֲ�ͬ���ַ�����
 * ֻ��һ�֣���ô����һ�ַ�ʽ����ԭ���ַ�û�в�ͬ��ɫ������ש�飬��Ҳ�������ֻ��һ�Բ�ͬ��ɫ������ש�顣
 * �����ֲ�ͬ�ַ����Ǿ������ַ�ʽ��
 * �������֣��򲻻����㡣
 * @author geyan
 *
 */
public class Solution_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			ArrayList<Character> al = new ArrayList<>();
			char[] c = str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (!al.contains(c[i])) {
					al.add(c[i]);
				}
			}
			if (al.size() > 2) {
				System.out.println(0);
			} else {
				System.out.println(al.size());
			}
		}
	}
}
