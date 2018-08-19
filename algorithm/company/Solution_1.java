import java.util.Scanner;

/**
 * 题目：连续最大和 
 * 题目描述：一个数组有N个元素，求连续子数组的最大和。例如：[-1,2,1]，和最大的连续子数组为[2,1]，其和为3
 * 
 * 其实就是剑指Offer面试题31
 * @author geyan
 *
 */
public class Solution_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = Integer.parseInt(input.nextLine());
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}
			System.out.println(max(array, n));
		}
	}

	private static int max(int[] array, int n) {
		int curSum = array[0], maxSum = curSum;
		for (int i = 1; i < n; i++) {
			// 在以array[i]结尾的情况下，比较curSum + array[i] 与 array[i]的大小
			curSum = Math.max(curSum + array[i], array[i]);
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}
}
