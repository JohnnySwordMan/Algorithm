import java.util.Scanner;

/**
 * 题目：拼凑钱币(典型的动态规划)
 * 题目描述：给你6种面额1，5，10，20，50，100元的纸币，假设每种币值的数量都足够多，编写程序求组成N元(N为0~10000的非负整数)
 * 的不同组合的个数
 * 
 * 注意： 1.在检查代码，没有找出错误时，可以将dp数组改成long试试
 * 
 * @author geyan
 *
 */
public class Solution_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int sum = sc.nextInt();
			System.out.println(test(sum));
		}
	}

	/**
	 * 如果arr长度为n，则生成行数为n，列数为sum+1的矩阵dp，dp[i][j]的含义是在使用arr[0...i]货币的情况下，
	 * 组成钱数j有多少种方法？
	 * 
	 * @param sum
	 */
	private static int test(int sum) {
		// 1.定义货币数组，不要求有序的
		int[] arr = { 1, 5, 10, 20, 50, 100 };
		int n = arr.length;
		// 2.定义dp数组，先定义成int类型，如果有编译错误，可以试试long型，该题数值较大
		int[][] dp = new int[n][sum + 1];
		// 3.初始化第一行，第一列
		// 第一列全部为1，使用这些货币组成金额为0的方法，只有1种，那就是这些货币使用0张，即不使用
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		// 第一行，arr[0]整数倍的位置置1
		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = 1;
		}

		// 4.dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
		/**
		 * dp[i][j]:
		 * 1.若不用arr[i]货币，只使用arr[0...i-1]货币，方法数为dp[i-1][j]
		 * 2.若使用1张arr[i]货币，剩下的使用arr[0...i-1]货币，方法数为dp[i-1][j-arr[i]]
		 * 3.若使用2张arr[i]货币，剩下的使用arr[0...i-1]货币，方法数为dp[i-1][j-2*arr[i]]
		 * 4.若使用3张arr[i]货币，剩下的使用arr[0...i-1]货币，方法数为dp[i-1][j-3*arr[i]]
		 * .
		 * .
		 * .
		 * ——>
		 * dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]] + dp[i-1][j-2*arr[i]] + dp[i-1][j-3*arr[i]] + ...
		 * 
		 * dp[i-1][j-arr[i]]:可以理解为，不使用arr[i]，组成金额为j-arr[i]
		 * dp[i-1][j-2*arr[i]]:可以理解为，使用1张arr[i]，组成金额为j-arr[i]
		 * .
		 * .
		 * .
		 * 即上述和，表示为使用arr[0...i]货币，组成金额j-arr[i]的方法数
		 * 即dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]]
		 */
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][sum];
	}
}
