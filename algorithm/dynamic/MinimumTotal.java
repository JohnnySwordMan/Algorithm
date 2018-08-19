import java.util.ArrayList;

/**
 * 题目：要求一个三角形中从顶到底的最小路径和，空间复杂度为O(n)
 * @author geyan
 *
 */
public class MinimumTotal {

	/**
	 * 自底向上 时间复杂度为O(n)，空间复杂度为O(1)，但是修改了原有的数组 从倒数第二行开始，该行第一个数+下面一行，其相邻的较小值，
	 * 比如说6+min(4,1),5+min(1,8),7+min(8,3)
	 */
	public int minimumTotal_1(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() <= 0) {
			return 0;
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				// 找出第i+1行的第j列和第i+1行的第j+1列的较小值
				int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, triangle.get(i).get(j) + min);
			}
		}
		return triangle.get(0).get(0);
	}

	/**
	 * 自顶向下， 假设dp[m][n]保存了第m行第n个节点的最小路径和，则 
	 * dp[m+1][n] = min(dp[m][n],dp[m][n-1])+triangle[m+1][n]; n>0 
	 * dp[m+1][0] = dp[m][0] + triangle[m+1][0];
	 * 空间复杂度必须为O(n)，所以我们需要滚动计算，使用一个一维数组保存每层的最小路径和，为了防止计算的时候不覆盖以前的值，我们需要从后往前计算。
	 */
	public int minimumTotal_2(ArrayList<ArrayList<Integer>> triangle) {
		int row = triangle.size();
		if (triangle == null || row <= 0) {
			return 0;
		}
		int[] dp = new int[row];
		int minTotal = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < row; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == 0) {
					dp[j] = dp[j] + triangle.get(i).get(j);
				} else {
					dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			minTotal = Math.min(minTotal, dp[i]);
		}
		return minTotal;
	}
}
