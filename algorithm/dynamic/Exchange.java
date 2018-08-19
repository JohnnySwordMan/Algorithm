/**
 * ��̬�滮���⣺����Ǯ dp[i][j]:��ʹ��penny[0...i]���ҵ�����£����Ǯ��j�ж����ַ�����
 * 
 * ��������ο���/algorithm/���ŵ���/Solution_2.java
 * @author geyan
 *
 */
public class Exchange {

	public int countWays(int[] penny, int n, int aim) {
		if (penny == null || penny.length == 0 || aim < 0) {
			return 0;
		}
		int[][] dp = new int[penny.length][aim + 1];
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < aim + 1; i++) {
			if (i % penny[0] == 0)
				dp[0][i] = 1;
		}
		for (int i = 1; i < penny.length; i++) {
			for (int j = 1; j <= aim; j++) {
				if (penny[i] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - penny[i]];
			}
		}
		return dp[n - 1][aim];
	}
}
