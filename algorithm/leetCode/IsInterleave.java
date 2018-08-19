package LeetCode;

/**
 * 题目：给定字符串s1,s2,s3，判断s3是否是s1和s2按顺序，交叉组成的。
 * 这是动态规划问题
 * @author geyan
 *
 */
public class IsInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		if (c1.length + c2.length != c3.length) {
			return false;
		}

		// 定义二维数组，dp[i][j]表示c1[0...i]和c2[0...j]能否顺序匹配c3[0...i+j]
		boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];

		// 1.初始化，从c1中取0个字符，从c2中取0个字符，可以匹配c3[0]
		dp[0][0] = true;

		// 2.从c1中取0个字符，从c2中取i个
		for (int i = 1; i <= c2.length; i++) {
			dp[0][i] = dp[0][i - 1] && (c2[i - 1] == c3[i - 1]);
		}

		// 3.从c1中取i个字符，从c2中取0个字符
		for (int i = 1; i <= c1.length; i++) {
			dp[i][0] = dp[i - 1][0] && (c1[i - 1] == c3[i - 1]);
		}

		// 4.从c1中取i个字符，从c2中取j个字符
		for (int i = 1; i <= c1.length; i++) {
			for (int j = 1; j <= c2.length; j++) {
				// 根据前一步
				// 1.从c1中取出i-1，从c2中取出j个，匹配的结果是dp[i-1][j];那么现在就看从c1中取出的第i个，是否与c3中已经匹配的后一个字符相同
				// c1[i-1]，目前一共取出了i-1+j个，那么下一步就是判断c3中第i+j个字符是否与c1的第i个字符相同，即c1[i-1]
				// == c3[i+j-1]
				// 2.同理
				dp[i][j] = (dp[i - 1][j] && (c1[i - 1] == c3[i + j - 1]))
						|| (dp[i][j - 1] && (c2[j - 1] == c3[i + j - 1]));
			}
		}
		return dp[c1.length][c2.length];
	}
}
