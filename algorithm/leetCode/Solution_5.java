package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��Ŀ��n��������С��k��
 * @author geyan
 *
 */
public class Solution_5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			String[] strs = str.split(" ");
			int length = strs.length;
			int[] num = new int[length];
			for (int i = 0; i < length; i++) {
				num[i] = Integer.parseInt(strs[i]);
			}
			int k = num[length - 1];
		}

	}

	// ֱ��ʹ��Arrays.sort���������ҳ�ǰk��,���һ������k�����ܲ�������
	public static void function_1(int[] num, int n, int k) {
		int[] arr = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			arr[i] = num[i];
		}
		Arrays.sort(arr);
		for (int i = 0; i < k - 1; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(arr[k - 1]);
	}

	// ����С��k��������������
	// ������k������������С��
	// ���������Ҫ����k��������С��������Բ���ѡ�񷽷�һ��ֱ������
	public static void function_2(int[] num, int n, int k) {
		int[] arr = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			arr[i] = num[i];
		}

		// ά��һ��k����С�����飬���������С��k��ֵ
		int[] result = new int[k];
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				result[i] = arr[i];
			} else {
				// result�������ѣ�result[0]���������ֵ
				maxHeadpDown(result, 0, k - 1);
				if (result[0] > arr[i]) {
					int temp = result[0];
					result[0] = arr[i];
					arr[i] = temp;
				}
			}
		}

		Arrays.sort(result);
		for (int i = 0; i < k - 1; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println(result[k - 1]);
	}

	// ��������
	public static void maxHeadpDown(int[] arr, int start, int end) {
		int c = start;
		int l = 2 * c + 1;
		int temp = arr[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && arr[l] < arr[l + 1]) {
				l++;
			}
			if (temp >= arr[l]) {
				break;
			} else {
				arr[c] = arr[l];
				arr[l] = temp;
			}
		}
	}
}
