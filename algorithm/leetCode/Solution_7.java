package LeetCode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * ��Ŀ��ɾ�������ַ� 
 * ��Ŀ���������������ַ������ӵ�һ�ַ�����ɾ���ڶ����ַ��������е��ַ������磬���롱They are students.���͡�aeiou������ɾ��֮��ĵ�һ���ַ�����ɡ�Thy r stdnts.��
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

	// ʹ��Set���ϣ���str2�ַ������ַ�����set�����У�����str1�ַ����е��ַ����ж��Ƿ����set�����У����ڣ�����ӵ�sb�У�ע��ո��㡣
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
