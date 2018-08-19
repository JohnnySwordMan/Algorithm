/**
 * 题目：剪绳子
 * 题目描述：给你一根长度为n的绳子，请把绳子剪成m段(m、n都是整数，n>1并且m>1)，每段绳子的长度记为k[0],k[1],k[2],...,k[m]。
 * 请问k[0]×k[1]×k[2]×...×k[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2，3，3的三段，此时得到的最大乘积是18。
 * 
 * @author geyan
 *
 */
public class MaxProductAfterCutting {

	/**
	 * 动态规划，时间复杂度为O(n^2)，空间复杂度为O(n)
	 * 定义函数f(n)为把长度为n的绳子剪成若干段后各段长度乘积的最大值，在剪第一刀的时候，我们有n-1种可能的选择，
	 * 也就是说剪出来的第一段绳子的长度有可能为1,2,3,...n-1。 f(n) = max(f(i)*f(n-i))
	 * 
	 * @return
	 */
	public int maxProductAfterCutting_1(int n) {
		if (n < 2) {
			return 0;
		}
		if (n == 2) {
			// 1×1
			return 1;
		}
		if (n == 3) {
			// 1×2
			return 2;
		}
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		int max = 0;
		for (int i = 4; i <= n; i++) {
			for (int j = 1; j <= i / 2; j++) {
				int product = dp[j] * dp[i - j];
				if (max < product) {
					max = product;
				}
				dp[i] = max;
			}
		}
		return dp[n];
	}

	/**
	 * 贪心算法，时间复杂度为O(1)，空间复杂度为O(1)
	 * 当n>=5时，尽可能多地剪长度为3的绳子，当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。
	 * 
	 * 证明：
	 * 当n>=5的时候，可以证明2(n-2)>n，并且3(n-3)>n，即当绳子剩下的长度大于等于5的时候，我们把它剪成长度为3或2的绳子段。
	 * 另外，当n>=5时，3(n-3)>=2(n-2)，因此我们应该尽可能地多剪长度为3的绳子段。
	 * @param n
	 * @return
	 */
	public int maxProductAfterCutting_2(int n) {
		if (n < 2) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}
		// 尽可能多地剪去长度为3的绳子段
		int timesOf3 = n / 3;
		// 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段，此时更好的方法是把绳子剪成长度为2的两段
		if (n - timesOf3 * 3 == 1) {
			// 说明可以分成timesOf3-1个长度为3的，timesOf2个长度为2的。
			timesOf3 -= 1;
		}
		int timesOf2 = (n - timesOf3 * 3) / 2;
		return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));

	}
}
