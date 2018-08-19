package LeetCode;

import java.util.Scanner;

/**
 * Ϊ�˷����û���ȷ������Ҫ����������ж��û������밴�� 6+8+4 �ĸ�ʽ���з��飬 ʵ��һ������������������е����֤�ţ����ط������ַ�
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
			// ���±�Ϊ6��λ�ò���ո񣬲��ù�ԭ����λ���Ƿ��ǿո�
			sb.insert(6, " ");
			System.out.println(sb.toString());
		} else {
			// 6+1+8=15���������±�Ϊ15�ĵط�����ո�
			sb.insert(6, " ");
			sb.insert(15, " ");
			System.out.println(sb.toString());
		}
	}

	// 70%
	public static void function_1(String str) {
		StringBuilder sb = new StringBuilder();

		// ���Ƚ�������ַ������пո��ȥ��
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
