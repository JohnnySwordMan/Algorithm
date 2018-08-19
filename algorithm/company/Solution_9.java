import java.util.Scanner;
import java.util.Stack;

/**
 * 题目：最大矩形面积 
 * 题目描述：给定一组非负整数组成的数组h，代表一组柱状图的高度，其中每个柱子的宽度为1.在这组柱状图中找到能组成的最大矩形的面积 比如：
 * 输入：2 1 5 6 2 3 输出：10
 * 
 * 最优解：时间复杂度为O(N),空间复杂度为O(N)
 * @author geyan
 *
 */
public class Solution_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(solution_2(arr, n));
		}
	}

	/**
	 * 时间复杂度为O(N)，空间复杂度为O(N)
	 * 分析：对于高度arr[i]，如果知道右侧第一个小于arr[i]的下标，左侧第一个小于arr[i]的下标，
	 * 那么对于包含该高度的矩形的最大面积就是arr[i]*(right-left-1)
	 * 实现：从左到右遍历数组元素，如果栈为空或者当前的数组元素大于栈顶元素，则继续压入栈中;如果当前数组元素小于栈顶元素，弹出栈顶元素cur，
	 * 则弹出的栈顶元素对应的高度为arr[cur]，则当前数组元素为arr[cur]的右侧第一个小于它的元素;
	 * 而当前栈顶元素对应的高度为arr[cur]左侧第一个小于它的元素。 只要遍历一次即可
	 */
	private static int solution_2(int[] arr, int n) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int i = 0;
		while (i <= n) {
			// i=n，并且设置此时的高度为0，主要是为了将数组最后一个元素，即最后一个高度和之前的能够合在一起解决
			int height = (i == n) ? 0 : arr[i];
			if (stack.empty() || height > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// 如果arr[i]<=arr[stack.peek()]，此时arr[i]为当前栈顶元素的右边第一个小于它的元素下标
				// 我们还要得到当前栈顶元素左边小于它的第一个
				int cur = stack.pop();
				// 出栈后，此时栈顶元素就是左边第一个小于cur的元素下标
				sum = Math.max(sum, arr[cur] * (stack.empty() ? i : i - stack.peek() - 1));
			}
		}
		return sum;
	}

	// 暴力解决，时间复杂度为O(N^2)
	private static long solution_1(int[] arr, int n) {
		long res = 0;
		for (int i = 0; i < n; i++) {
			long minHeight = arr[i];
			long area = minHeight;
			for (int j = i; j < n; j++) {
				if (minHeight > arr[j]) {
					minHeight = arr[j];
				}
				area = minHeight * (j - i + 1);
				res = Math.max(res, area);
			}
		}
		return res;
	}
}
