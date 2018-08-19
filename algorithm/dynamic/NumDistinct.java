/**
 * ��Ŀ��S�а���T�Ĳ�ͬ��������
 * ��Ŀ�����������ַ���S��T����������ַ���S��������T�ĸ���
 * 
 * ������
 * dp[i][j]��ʾS[0...i-1]��T[0...j-1]��ͬ�����еĸ��� 
 * ��S[i-1] != T[i-1]��dp[i][j] = dp[i-1][j]; 
 * ��S[i-1] == T[i-1]��dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
 * 
 * @author geyan
 *
 */
public class NumDistinct {

	public int numDistinct(String S, String T) {
		if (S.length() == 0 || T.length() == 0) {
			return 0;
		}
		// ��������dp
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		// ��ʼ����һ��
		// ���SΪ�մ�����T���ǿմ�����T��������S��������
		for (int i = 1; i <= T.length(); i++) {
			dp[0][i] = 0;
		}
		// ��ʼ����һ��
		// ���TΪ�գ���T��S�������У�ֻ��һ��
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
