import java.util.Scanner;

/**
 * ��Ŀ��������Ϸ(쳲��������У�����̨�ף���̬��̨����һ�����⣬Ҳ������Ϊ�Ǽ򵥵Ķ�̬�滮)
 * ��Ŀ������������Ϸ����Ҹ������ӵĵ��������ߵĲ����������ӵ���Ϊ1ʱ������һ��������Ϊ2ʱ����������������Ϊnʱ������n����
 * ������ߵ���n����n<=�������������Ƿ�����Ψһ��Σ�ʱ���ܹ��ж�����Ͷ���ӵķ�����
 * 
 * ��������ο���/algorithm/JZOffer/JumpFloorII.java��JumpFloor.java��Fibonacci.java
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
