package LeetCode;

import java.util.Scanner;

/**
 * ��Ŀ��n��������ִ������ڵ���n/2����
 * 
 * �ο�/algorithm/JZOffer/MoreThanHalfNum.java
 * @author geyan
 *
 */
public class Solution_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] strs = str.split(" ");
			int[] arr = new int[strs.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = Integer.parseInt(strs[i]);
			}
			System.out.println(function_1(arr, arr.length));
		}
	}

	public static int function_1(int[] arr, int n) {
		// ��¼���ֳ��ִ���
		int count = 1;
		// ����
		int result = arr[0];
		for (int i = 1; i < n; i++) {
			if (result == arr[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result = arr[i];
				count = 1;
			}
		}
		// ���һ�θ�ֵ��result����Ҫ��ģ�����ģ�����ֻ��Ҫ�ٴ���֤result�Ĵ����Ƿ񳬹������һ��
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (result == arr[i]) {
				k++;
			}
		}
		if (k * 2 >= n) {
			return result;
		} else {
			return 0;
		}
	}
}
