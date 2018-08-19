package LeetCode;

import java.util.*;

/**
 * 题目：现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，
 * 现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数。
 * 例：丢失的元素为336，10，8435，得到的新数字为103368435，除以七的余数为2。
 * 
 * 
 * 分析：因为有1~10000个数，创建数组，大小为10001，每输入一个数字，就存放在对应的数组位置，比如输入3，则存放在a[3]的位置，一共输入9997次。
 * 然后遍历数组a，从下标1开始遍历，如果数组下标对应的值为0，说明没有输入该值，则丢失的值为对应下标
 * @author geyan
 *
 */
public class Solution_9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int[] arr = new int[10001];
			// 这个i是用来控制输入次数的
			for (int i = 0; i < 9997; i++) {
				int num = input.nextInt();
				arr[num] = num; // 输入多少，对应放在相应位置
			}
			int[] res = new int[3];
			int index = 0;
			for (int i = 1; i < 10001; i++) {
				if (arr[i] == 0) {
					res[index++] = i; // 说明
				}
			}
			Arrays.sort(res);
			String result = "";
			for (int i = 0; i < res.length - 1; i++) {
				result += res[i];
			}
			result += res[2];
			// long型
			long number = Long.parseLong(result);
			System.out.println(number % 7);
		}

	}
}