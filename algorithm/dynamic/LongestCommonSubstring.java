/**
 * ��Ŀ��������Ӵ� 
 * ��Ŀ���������������ַ������ҳ�������Ĺ��������Ӵ�
 * 
 * @author geyan
 *
 */
public class LongestCommonSubstring {

	/**
	 * ʱ�临�Ӷ�ΪO(n*m)���ռ临�Ӷ�ΪO(n*m) 
	 * ������Ӵ�������������к����ƣ�ֻ������a[i] != b[j]ʱ��dp[i][j] = 0;
	 * ������dp[i][j] = max{dp[i-1][j],dp[i][j-1]}; 
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
					// ���������������в�ͬ
					dp[i][j] = 0;
				}
			}
		}
		return maxLen;
	}
}
