package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目：n个数里最小的k个
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

	// 直接使用Arrays.sort方法排序，找出前k个,最后一个数是k，不能参与排序
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

	// 求最小的k个数，构造最大堆
	// 求最大的k个数，构造最小堆
	// 由于最后还是要求这k个数按大小输出，所以不如选择方法一，直接排序
	public static void function_2(int[] num, int n, int k) {
		int[] arr = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			arr[i] = num[i];
		}

		// 维护一个k个大小的数组，用来存放最小的k个值
		int[] result = new int[k];
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				result[i] = arr[i];
			} else {
				// result构造最大堆，result[0]是数组最大值
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

	// 构造最大堆
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
