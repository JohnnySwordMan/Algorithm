/**
 * 题目：最长公共子串 
 * 题目描述：给出两个字符串，找出其中最长的公共连续子串
 * 
 * @author geyan
 *
 */
public class LongestCommonSubstring {

	/**
	 * 时间复杂度为O(n*m)，空间复杂度为O(n*m) 
	 * 最长公共子串和最长公共子序列很类似，只不过当a[i] != b[j]时，dp[i][j] = 0;
	 * 而不是dp[i][j] = max{dp[i-1][j],dp[i][j-1]}; 
	 */
	public int findLCS(String str1, String str2) {
		char[] a = str1.toCharArray();
		char[] b = str2.toCharArray();
		int n = a.length;
		int m = b.length;
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int j = 0; j <= m; j++) {
			dp[0][j] = 0;
		}
		int maxLen = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
					}
				} else {
					// 这里和最长公共子序列不同
					dp[i][j] = 0;
				}
			}
		}
		return maxLen;
	}
}
