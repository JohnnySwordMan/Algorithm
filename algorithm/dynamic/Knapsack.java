/**
 * 题目：0-1背包问题 
 * 题目描述：一个背包有一定的承重W，有N件物品，每件都有自己的价值，记录在数组V中，也都有自己的重量，记录在数组W中，
 * 每件物品只能选择要装入的背包还是不装入背包， 要求在不超过背包承重的前提下，选出物品的总价值最大。
 * 
 * 分析： 假设dp[x][y]表示前x件物品，不超过重量y的时候的最大价值，枚举下第x件物品的情况：
 * 1.如果选择第x件物品，则前x-1件物品得到的重量不能超过y-w[x] 
 * 2.如果不选第x件物品，则前x-1件物品得到的重量不能超过y
 * 
 * 即，dp[x][y] = max{dp[x-1][y],dp[x-1][y-w[x]]+v[x]};
 * 
 * 对矩阵dp来说，行数是物品的数量n+1，列数是背包的重量w+1，从左到右，再从上到下依次计算所有dp值即可。
 * 
 * 0-1背包是不能用贪心算法的，而背包问题可以用贪心算法
 * @author geyan
 *
 */
public class Knapsack {

	/**
	 * @param n 物品数量
	 * @param w	背包承重
	 * @param weight 对应物品的重量
	 * @param value  对应物品的价值
	 */
	public int backpack(int n, int w, int[] weight, int[] value) {
		int[][] dp = new int[n + 1][w + 1];
		// 第一列
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		// 第一行
		for (int j = 0; j <= w; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (weight[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + 1);
				}
			}
		}
		return dp[n][w];
	}
}
