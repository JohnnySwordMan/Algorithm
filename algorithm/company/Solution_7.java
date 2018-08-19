import java.util.Scanner;

/**
 * 题目：大富翁游戏(斐波那契数列，与跳台阶，变态跳台阶是一个问题，也可以认为是简单的动态规划)
 * 题目描述：大富翁游戏，玩家根据骰子的点数决定走的步数，即骰子点数为1时可以走一步，点数为2时可以走两步，点数为n时可以走n步。
 * 求玩家走到第n步（n<=骰子最大点数且是方法的唯一入参）时，总共有多少种投骰子的方法。
 * 
 * 具体分析参考：/algorithm/JZOffer/JumpFloorII.java，JumpFloor.java，Fibonacci.java
 * @author geyan
 *
 */
public class Solution_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			System.out.println(test(n));
		}
	}

	// n = 1,f(n) = 1;
	// n > 1,f(n) = 2*(n-1)
	private static int test(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		int f1 = 1;
		int temp = 0;
		for (int i = 2; i <= n; i++) {
			temp = 2 * f1;
			f1 = temp;
		}
		return temp;
	}
}
