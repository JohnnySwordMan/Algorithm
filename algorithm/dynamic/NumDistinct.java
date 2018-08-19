/**
 * 题目：S中包含T的不同的子序列
 * 题目描述：给定字符串S，T，计算出在字符串S中子序列T的个数
 * 
 * 分析：
 * dp[i][j]表示S[0...i-1]中T[0...j-1]不同子序列的个数 
 * 当S[i-1] != T[i-1]，dp[i][j] = dp[i-1][j]; 
 * 当S[i-1] == T[i-1]，dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
 * 
 * @author geyan
 *
 */
public class NumDistinct {

	public int numDistinct(String S, String T) {
		if (S.length() == 0 || T.length() == 0) {
			return 0;
		}
		// 创建数组dp
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		// 初始化第一行
		// 如果S为空串，若T不是空串，则T不可能是S的子序列
		for (int i = 1; i <= T.length(); i++) {
			dp[0][i] = 0;
		}
		// 初始化第一列
		// 如果T为空，则T是S的子序列，只有一种
		for (int i = 0; i <= S.length(); i++) {
			dp[i][0] = 1;
		}	
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 1; j <= T.length(); j++) {
				if (S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
	}
}
