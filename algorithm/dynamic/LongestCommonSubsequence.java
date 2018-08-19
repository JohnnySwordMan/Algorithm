/**
 * 题目：最长公共子序列 题目描述：给定两个字符串A和B，返回两个字符串的最长公共子序列的长度
 * 
 * 分析：这是典型的动态规划问题，子序列，不要求连续，只要字符相对顺序一致即可。
 * 创建二维数组dp[n+1][m+1]，dp[i][j]表示以A[i]和B[j]结尾的最长的公共子序列长度， 
 * 当i = 0 或 j = 0，dp[i][j] = 0;
 * 当i,j > 0，A[i] != B[j]，dp[i][j] = max{dp[i-1][j],dp[i][j-1]}; 
 * 当i,j >0，A[i] = B[j]，dp[i][j] = dp[i-1][j-1] + 1
 * 
 * 时间复杂度度为O(n*m)，空间复杂度为O(n*m)
 * 
 * @author geyan
 *
 */
public class LongestCommonSubsequence {

	/**
	 * 求两个字符串的最长的公共子序列
	 */
	public int findLCS(String A, int n, String B, int m) {
		if (A == "" || B == "")
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		// 第一列
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		// 第一行
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 注意，不是a[i] = b[j]，a[i-1],b[j-1]对应的是dp[i][j]，因为dp第一行和第一列都是为0的
				// 比如，当i,j都为1时，以a[0],b[0]为结尾的dp值，其实对应的是dp[1][1]
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

	/**
	 * 求两个字符串的最长公共子序列， 同时要求输出该子序列的内容， 我们只需要使用一个二维数组记录在遍历过程中所选择的子问题的最优解
	 */
	public int findLCS_1(String A, int n, String B, int m) {

		if (A == "" || B == "")
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] path = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		// 第一列
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		// 第一行
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					path[i][j] = 1;
				} else {
					if (dp[i - 1][j] >= dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
						path[i][j] = 2;
					} else {
						dp[i][j] = dp[i][j - 1];
						path[i][j] = 3;
					}
				}
			}
		}
		return dp[n][m];
	}

	// 输出LCS序列，printOneLCS(path,a,n,m);
	public void printOneLCS(int[][] path, char[] a, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (path[i][j] == 1) {
			printOneLCS(path, a, i - 1, j - 1);
			System.out.print(a[i - 1] + " -> ");
		} else if (path[i][j] == 2) {
			printOneLCS(path, a, i - 1, j);
		} else {
			printOneLCS(path, a, i, j - 1);
		}
	}

	// 输出LCS序列，printOneLCS(dp,a,b,n,m);
	public void printOneLCS_1(int[][] arr, char[] X, char[] Y, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (X[i - 1] == Y[j - 1]) {
			System.out.print(X[i - 1] + " -> ");
			// 寻找的
			printOneLCS_1(arr, X, Y, i - 1, j - 1);
		} else if (arr[i - 1][j] >= arr[i][j - 1]) {
			printOneLCS_1(arr, X, Y, i - 1, j);
		} else {
			printOneLCS_1(arr, X, Y, i, j - 1);
		}
	}
}
