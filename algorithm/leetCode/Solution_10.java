package LeetCode;

import java.util.Scanner;

/**
 * ��Ŀ�������߷���Ŀ������Ķ�̬�滮
 * ��һ��X*Y������С��Ҫ�ڴ������ϴ����Ͻǵ����½ǣ�ֻ���߸����ֻ�����һ������ߡ�
 * �����һ���㷨������С���ж������߷�����������������int x,int y���뷵��С�ŵ��߷���Ŀ��
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
			// dp[0][0] = 1��һ������Ҳ��һ���߷�
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
