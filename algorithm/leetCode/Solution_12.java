package LeetCode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * ��Ŀ�������ӷ�
 * �����һ���㷨�ܹ�����������ַ����洢������������Ӳ������ԷǷ��������򷵻�error
 * @author geyan
 *
 */
public class Solution_12 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			/*
			 * String str = input.nextLine(); String[] strs = str.split(" ");
			 * String str1 = strs[0]; String str2 = strs[1];
			 * function_2(str1,str2);
			 */
			try {
				BigInteger n = input.nextBigInteger();
				BigInteger m = input.nextBigInteger();
				System.out.println(m.add(n));
			} catch (Exception e) {
				System.out.println("error");
			}
		}
	}

	// 80%
	public static void function_1(String str1, String str2) {
		boolean flag1 = true;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '-') {
				continue;
			}
			if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9') {
				continue;
			} else {
				flag1 = false;
				break;
			}
		}

		boolean flag2 = true;
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) == '-') {
				continue;
			}
			if (str2.charAt(i) >= '0' && str2.charAt(i) <= '9') {
				continue;
			} else {
				flag2 = false;
				break;
			}
		}

		if (!flag1 || !flag2) {
			System.out.println("error");
			// ��Ҫ�����˳�
			return;
		}

		long num1 = Long.parseLong(str1);
		long num2 = Long.parseLong(str2);

		// ֱ����Ӽ��ɣ�û����ҪŪ������
		System.out.println(num1 + num2);
	}

	// 40%
	public static void function_2(String str1, String str2) {
		boolean flag1 = true;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == '-') {
				continue;
			}
			if (str1.charAt(i) >= '0' && str1.charAt(i) <= '9') {
				continue;
			} else {
				flag1 = false;
				break;
			}
		}

		boolean flag2 = true;
		for (int i = 0; i < str2.length(); i++) {
			if (str2.charAt(i) == '-') {
				continue;
			}
			if (str2.charAt(i) >= '0' && str2.charAt(i) <= '9') {
				continue;
			} else {
				flag2 = false;
				break;
			}
		}

		if (!flag1 || !flag2) {
			System.out.println("error");
			// ��Ҫ�����˳�
			return;
		}

		long num1 = Long.parseLong(str1);
		long num2 = Long.parseLong(str2);

		int length = Math.max(str1.length(), str2.length());
		int[] arr = new int[length];
		int length12 = str1.length() - str2.length();
		StringBuilder sb12 = new StringBuilder();
		if (length12 < 0) {
			for (int i = 0; i < -length12; i++) {
				sb12.append(0);
			}
			sb12.append(str1);
			str1 = sb12.toString();
		} else if (length12 > 0) {
			for (int i = 0; i < length12; i++) {
				sb12.append(0);
			}
			sb12.append(str2);
			str2 = sb12.toString();
		}

		// ��������Ĵ�����ʱ���Դ�ͷ��ʼ���
		for (int i = 0; i < length; i++) {
			arr[i] = (str1.charAt(i) - '0') + (str2.charAt(i) - '0');
		}

		// �����λ��arr[0]����Ҫ�����λ
		int carry = 0;
		for (int i = length - 1; i > 0; i++) {
			arr[i] += carry;
			carry = arr[i] / 10;
			arr[i] = arr[i] % 10;
		}
		arr[0] += carry;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		long res = Long.parseLong(sb.toString());

		System.out.println(res);
	}
}
