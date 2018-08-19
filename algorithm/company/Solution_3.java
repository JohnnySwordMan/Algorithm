import java.util.Scanner;

/**
 * ��Ŀ��ĩβ0�ĸ���
 * ��Ŀ����������һ��������n����n!ĩβ�ж��ٸ�0�����磺n = 10��n!=3628800�����Դ���2��
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
	 * ����һ�����������ʽⷨ ����׳���ÿ���������е�����5����
	 * 2��5=10�����Եó�һ��0��һ����������2�ĸ���ҪԶԶ��������5�ĸ��������ԣ�����ֻ��Ҫ�������5�ĸ��������ɵõ�0�ĸ�����
	 * �����ǵ�������n������5�ĸ�����������1~nÿ����������5�ĸ���
	 * 
	 * ʱ�临�Ӷ�ΪO(Nlog5(N)) (��5Ϊ��)
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
	 * ��������˼�������ڷ���һ [n/5] + [n/5^2] + [n/5^3] + ...
	 * [n/5]��ʾ������n������5�ı�������һ��5��[n/5^2]����������n������5^2�ı����ڹ���һ��5...
	 * 
	 * ʱ�临�Ӷ�ΪO(log5(N)) (��5Ϊ��)
	 * 
	 * ��25Ϊ����25/5 = 5����С�ڵ���25�����У�5�ı�����5�����ֱ���5��10��15��20��25��
	 * ���ǿ��Կ���25�ֿ��Էֽ��5��5����ʵ����2��5�� ����25!������5������ʵ��5 + 1 = 6��
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
	 * ��������f(n)��ʾ������nĩβ���е�"0"�ĸ����� 
	 * ��0<n<5��f(n!) = 0; 
	 * ��n<=5��f(n!) = k + f(k!); k = n/5;
	 * 
	 * ʱ�临�Ӷ�ΪO(log5(N))  (��5Ϊ��)
	 */
	private static int test_3(int n) {
		int count = 0;
		if (n < 5)
			return count;
		int k = n / 5;
		return k + test_3(k);
	}
}
