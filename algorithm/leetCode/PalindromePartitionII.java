package LeetCode;

/**
 * ��Ŀ����ֻ����ִ� ��Ŀ�����������ַ������ҳ����п��ܵĻ����Ӵ����з� ���磺s = "aab"
 * ��[["aa","b"],["a","a","b"]]�������С�и���
 * 
 * ������dp[i]��ʾ�ַ���s[0...i]����С�����и��������Ž���dp[s.length()-1]
 * 
 * @author geyan
 *
 */
public class PalindromePartitionII {

	public int minCut(String s) {
		int[] dp = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			// �ж��ִ�s[0...i]�Ƿ��ǻ����ִ�������ǣ�dp[i] = 0����ʾ����Ҫ�ָ������ǻ����ִ�����dp[i] =
			// i����ʾ��Ҫ���ָ�i��
			dp[i] = isPalindrome(s.substring(0, i + 1)) ? 0 : i;
			if (dp[i] == 0) {
				continue;
			}
			for (int j = 1; j <= i; j++) {
				if (isPalindrome(s.substring(j, i + 1))) {
					// ���s[j...i]�ǻ����ִ�����ô�Ƚ�dp[i]��dp[j-1]+1��ȡ��С�ġ���Ϊs[0...i]���Է�Ϊs[0...j-1]��s[j...i]����Ϊs[j...i]�ǻ����ִ�������ֻ��Ҫ����s[0...j-1]��Ҫ���и��
					dp[i] = Math.min(dp[i], dp[j - 1] + 1);
				} else {
					// ���s[j...i]���ǻ����ִ�����ôs[j...i]��Ҫ���и�ɵ�����һ������i+1-j
					dp[i] = Math.min(dp[i], dp[j - 1] + i + 1 - j);
				}
			}		
		}
		return dp[s.length()-1];
	}

	// �ж��Ƿ��ǻ����ִ�
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
