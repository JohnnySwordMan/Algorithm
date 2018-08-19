package LeetCode;

import java.util.Scanner;

/**
 * 题目：网络走法数目，经典的动态规划
 * 有一个X*Y的网格，小团要在此网格上从左上角到右下角，只能走格点且只能向右或向下走。
 * 请设计一个算法，计算小团有多少种走法。给定两个正整数int x,int y，请返回小团的走法数目。
 * @author geyan
 *
 */
public class Solution_10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int x = input.nextInt();
			int y = input.nextInt();
			int[][] dp = new int[x + 1][y + 1];
			// dp[0][0] = 0;
			// dp[0][0] = 1，一步不走也是一种走法
			for (int i = 0; i < y + 1; i++) {
				dp[0][i] = 1;
			}

			for (int i = 0; i < x + 1; i++) {
				dp[i][0] = 1;
			}

			for (int i = 1; i < x + 1; i++) {
				for (int j = 1; j < y + 1; j++) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
			System.out.println(dp[x][y]);
		}
	}
}
