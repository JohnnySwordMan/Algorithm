/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 
 * 示例 1：
 * 
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。 示例 2：
 * 
 * 输入: "cbbd" 输出: "bb"
 * 
 */
public class LongestPalindrome {

    /**
     * 动态规划
     * 
     * 定义dp[i][j]数组，表示str[i]...str[j]是否是回文子串 思路： 1. 对于字符串str[i...j]，如果字符串str[i] ==
     * str[j]，则在此基础上判断str[i+1] ?= str[j-1]; 2. 如果str[i] !=
     * str[j]，则str[i...j]不可能为回文子串，
     */
    public String longestPalindrome(String str) {
        if (str == null || str.length() == 0 || str.length() == 1) {
            return str;
        }
        boolean[][] dp = new boolean[str.length()][str.length()];
        // 初始化，我们假设 i <= j
        int i = 0, j = 0;
        for (i = 0; i < str.length(); i++) {
            for (j = 0; j < str.length(); j++) {
                if (i >= j) {
                    // 我们认为只有一个字符串或空串的，都是回文子串
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }
            }
        }
        int k = 1, maxLen = 1;
        int left = 0, right = 0;
        // k表示i和j之间的间隔
        for (k = 1; k < str.length(); k++) {
            for (i = 0; i + k < str.length(); i++) {
                j = i + k;
                if (str.charAt(i) != str.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // str[i...j]是否是回文子串依赖于str[i+1...j-1]
                    dp[i][j] = dp[i + 1][j - 1];
                    if (dp[i][j]) {
                        if (k + 1 > maxLen) {
                            maxLen = k + 1;
                            left = i;
                            right = j;
                        }
                    }
                }
            }
        }
        return str.substring(left, right + 1);
    }
}