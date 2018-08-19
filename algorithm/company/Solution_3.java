import java.util.Scanner;

/**
 * 题目：末尾0的个数
 * 题目描述：输入一个正整数n，求n!末尾有多少个0？比如：n = 10，n!=3628800，所以答案是2。
 * @author geyan
 *
 */
public class Solution_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(test_2(n));
		}
	}

	/**
	 * 方法一：质因数性质解法 求出阶乘中每个数，含有的因子5个数
	 * 2×5=10，可以得出一个0，一个数其因子2的个数要远远多于因子5的个数，所以，我们只需要求出因子5的个数，即可得到0的个数，
	 * 并不是单纯的求n的因子5的个数，而是求1~n每个数的因子5的个数
	 * 
	 * 时间复杂度为O(Nlog5(N)) (以5为底)
	 */
	private static int test_1(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j % 5 == 0) {
				count++;
				j /= 5;
			}
		}
		return count;
	}

	/**
	 * 方法二：思想类似于方法一 [n/5] + [n/5^2] + [n/5^3] + ...
	 * [n/5]表示不大于n的数中5的倍数贡献一个5，[n/5^2]表述不大于n的数中5^2的倍数在贡献一个5...
	 * 
	 * 时间复杂度为O(log5(N)) (以5为底)
	 * 
	 * 以25为例，25/5 = 5，在小于等于25的数中，5的倍数有5个，分别是5，10，15，20，25。
	 * 但是可以看到25又可以分解成5×5，其实就有2个5。 所以25!中因子5个数其实是5 + 1 = 6。
	 */
	private static int test_2(int n) {
		int count = 0;
		int base = 5;
		while (n >= base) {
			count += n / base;
			base *= 5;
		}
		return count;
	}

	/**
	 * 方法三：f(n)表示正整数n末尾含有的"0"的个数， 
	 * 当0<n<5，f(n!) = 0; 
	 * 当n<=5，f(n!) = k + f(k!); k = n/5;
	 * 
	 * 时间复杂度为O(log5(N))  (以5为底)
	 */
	private static int test_3(int n) {
		int count = 0;
		if (n < 5)
			return count;
		int k = n / 5;
		return k + test_3(k);
	}
}
