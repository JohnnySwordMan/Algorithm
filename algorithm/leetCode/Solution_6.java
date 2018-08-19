package LeetCode;

import java.util.Scanner;

/**
 * 题目：n个数里出现次数大于等于n/2的数
 * 
 * 参考/algorithm/JZOffer/MoreThanHalfNum.java
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
		// 记录数字出现次数
		int count = 1;
		// 数字
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
		// 最后一次赋值的result就是要求的，下面的，我们只需要再次验证result的次数是否超过数组的一般
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
