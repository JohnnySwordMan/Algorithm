/**
 * ��Ŀ��������Ӵ�
 * 
 * ˼·�� 
 * 1.�����ַ���s[i...j]�����str.charAt(i) == str.charAt(j)Ϊtrue�����ڴ˻������ж�str.charAt(i+1) == str.charAt(j-1)
 * 2.���str.charAt(i) != str.charAt(j)�����ַ���s[i...j]�������ǻ����ִ�����û�б�Ҫ�ж�str.charAt(i+1) == str.charAt(j-1)
 * 
 * ������ά����dp��dp[i][j]��ʾ�ַ���s[i...j]�Ƿ��ǻ����Ӵ�
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
		// ���Ǽ���i<=j
		int i = 0, j = 0;
		for (i = 0; i < str.length(); i++) {
			for (j = 0; j < str.length(); j++) {
				if (i >= j) {
					// ֻ��һ���ַ�����մ�������Ϊ�ǻ����Ӵ�
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
			}
		}
		int k, maxLen = 1;
		int rf = 0, rt = 0;
		// k��ʾi,j֮��ļ��
		for (k = 1; k < str.length(); k++) {
			for (i = 0; k + i < str.length(); i++) {
				// �ʼi,j���ڣ�Ȼ��i,j���1...ֱ��i,j���Ϊ�����ַ���
				j = i + k;
				if (str.charAt(i) != str.charAt(j)) {
					dp[i][j] = false;
				} else {
					// ���str.charAt(i) ==
					// str.charAt(j)��str��������ȡ����str.charAt(i+1)��str.charAt(j-1)
					dp[i][j] = dp[i + 1][j - 1];
					if (dp[i][j]) {
						if (k + 1 > maxLen) {
							// ��¼������Ӵ��ĳ��ȣ���ʼ
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
