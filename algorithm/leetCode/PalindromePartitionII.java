package LeetCode;

/**
 * 题目：拆分回文字串 题目描述：给定字符串，找出所有可能的回文子串的切分 例如：s = "aab"
 * 则[["aa","b"],["a","a","b"]]，输出最小切割数
 * 
 * 分析：dp[i]表示字符串s[0...i]的最小回文切割数，最优解在dp[s.length()-1]
 * 
 * @author geyan
 *
 */
public class PalindromePartitionII {

	public int minCut(String s) {
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			// 判断字串s[0...i]是否是回文字串，如果是，dp[i] = 0，表示不需要分割；如果不是回文字串，则dp[i] =
			// i，表示需要最多分割i次
			dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
			if (dp[i] == 0) {
				continue;
			}
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s.substring(j, i + 1))) {
					// 如果s[j...i]是回文字串，那么比较dp[i]与dp[j-1]+1，取较小的。因为s[0...i]可以分为s[0...j-1]和s[j...i]，因为s[j...i]是回文字串，所以只需要考虑s[0...j-1]需要被切割几次
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				} else {
					// 如果s[j...i]不是回文字串，那么s[j...i]需要被切割成单独的一个，则i+1-j
					dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
				}
			}		
		}
		return dp[s.length()-1];
	}

	// 判断是否是回文字串
	private boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return false;
	}
}
