import java.util.Scanner;

/**
 * 题目：数字和为sum的方法数
 * 题目描述：给定一个有n个正整数的数组A和一个整数sum，求选择数组A中部分数字和为sum的方案数。
 * 
 * 注意点： 1.如果通过率已经达到80%，可能是int用错了，可以换成long试试
 * 
 * @author geyan
 *
 */
public class Solution_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			// 数组大小为n+1
			int[] arr = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				arr[i] = sc.nextInt();
			}
			test(arr, n, sum);
		}
	}

	/**
	 * 动态规划，和金钱、背包问题一样。
	 * dp[i][j]表示用前i个值组成和为j的方案个数
	 * 1.不使用arr[i]，dp[i][j] = dp[i-1][j];
	 * 2.使用arr[i]，dp[i][j] = dp[i-1][j-arr[i]];
	 */
	private static void test(int[] arr, int n, int sum) {
		// long，而不用int
		long[][] dp = new long[n + 1][sum + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j >= arr[i]) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][sum]);
	}
}
