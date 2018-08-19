/**
 * 题目：最长回文子串
 * 
 * 思路： 
 * 1.对于字符串s[i...j]，如果str.charAt(i) == str.charAt(j)为true，则在此基础上判断str.charAt(i+1) == str.charAt(j-1)
 * 2.如果str.charAt(i) != str.charAt(j)，则字符串s[i...j]不可能是回文字串，更没有必要判断str.charAt(i+1) == str.charAt(j-1)
 * 
 * 创建二维数组dp，dp[i][j]表示字符串s[i...j]是否是回文子串
 * 
 * @author geyan
 *
 */
public class LongestPalindromicSubstring {
	public String longestPalindrome(String str) {
		if (str.length() == 0) {
			return "";
		}
		if (str.length() == 1) {
			return str;
		}
		boolean[][] dp = new boolean[str.length()][str.length()];
		// 我们假设i<=j
		int i = 0, j = 0;
		for (i = 0; i < str.length(); i++) {
			for (j = 0; j < str.length(); j++) {
				if (i >= j) {
					// 只有一个字符串或空串，都认为是回文子串
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		int k, maxLen = 1;
		int rf = 0, rt = 0;
		// k表示i,j之间的间隔
		for (k = 1; k < str.length(); k++) {
			for (i = 0; k + i < str.length(); i++) {
				// 最开始i,j相邻，然后i,j间隔1...直至i,j间隔为整个字符串
				j = i + k;
				if (str.charAt(i) != str.charAt(j)) {
					dp[i][j] = false;
				} else {
					// 如果str.charAt(i) ==
					// str.charAt(j)，str回文性质取决于str.charAt(i+1)和str.charAt(j-1)
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j]) {
						if (k + 1 > maxLen) {
							// 记录最长回文子串的长度，起始
							maxLen = k + 1;
							rf = i;
							rt = j;
						}
					}
				}
			}
		}
		return str.substring(rf, rt + 1);
	}
}
