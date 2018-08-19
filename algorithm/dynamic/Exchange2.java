/**
 * 动态规划问题：使用penny数组中的硬币，最少使用多少个硬币可以组成target金额
 * 
 * dp[i] = j,拼凑i元最少使用j个硬币
 * @author geyan
 *
 */
public class Exchange2 {

	public int countWays(int[] penny, int target) {
		if (penny == null || penny.length == 0 || target == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		for (int i = 1; i <= target; i++) {
			// 初始化，i元是无法拼凑的
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < penny.length; j++) {
				// penny[j]小于拼凑金额，且使用一枚penny[j]硬币，剩下的金额是可以拼凑的
				if (penny[j] <= i && dp[i - penny[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - penny[j]] + 1);
				}
			}
		}
		if (dp[target] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dp[target];
		}
	}
}
