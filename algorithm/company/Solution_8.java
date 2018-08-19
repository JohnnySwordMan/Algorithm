import java.util.Scanner;

/**
 * ��Ŀ��ƴ��Ǯ��(���͵Ķ�̬�滮)
 * ��Ŀ����������6�����1��5��10��20��50��100Ԫ��ֽ�ң�����ÿ�ֱ�ֵ���������㹻�࣬��д���������NԪ(NΪ0~10000�ķǸ�����)
 * �Ĳ�ͬ��ϵĸ���
 * 
 * ע�⣺ 1.�ڼ����룬û���ҳ�����ʱ�����Խ�dp����ĳ�long����
 * 
 * @author geyan
 *
 */
public class Solution_8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int sum = sc.nextInt();
			System.out.println(test(sum));
		}
	}

	/**
	 * ���arr����Ϊn������������Ϊn������Ϊsum+1�ľ���dp��dp[i][j]�ĺ�������ʹ��arr[0...i]���ҵ�����£�
	 * ���Ǯ��j�ж����ַ�����
	 * 
	 * @param sum
	 */
	private static int test(int sum) {
		// 1.����������飬��Ҫ�������
		int[] arr = { 1, 5, 10, 20, 50, 100 };
		int n = arr.length;
		// 2.����dp���飬�ȶ����int���ͣ�����б�����󣬿�������long�ͣ�������ֵ�ϴ�
		int[][] dp = new int[n][sum + 1];
		// 3.��ʼ����һ�У���һ��
		// ��һ��ȫ��Ϊ1��ʹ����Щ������ɽ��Ϊ0�ķ�����ֻ��1�֣��Ǿ�����Щ����ʹ��0�ţ�����ʹ��
		for (int i = 0; i < n; i++) {
			dp[i][0] = 1;
		}
		// ��һ�У�arr[0]��������λ����1
		for (int i = 0; i < sum + 1; i++) {
			dp[0][i] = 1;
		}

		// 4.dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
		/**
		 * dp[i][j]:
		 * 1.������arr[i]���ң�ֻʹ��arr[0...i-1]���ң�������Ϊdp[i-1][j]
		 * 2.��ʹ��1��arr[i]���ң�ʣ�µ�ʹ��arr[0...i-1]���ң�������Ϊdp[i-1][j-arr[i]]
		 * 3.��ʹ��2��arr[i]���ң�ʣ�µ�ʹ��arr[0...i-1]���ң�������Ϊdp[i-1][j-2*arr[i]]
		 * 4.��ʹ��3��arr[i]���ң�ʣ�µ�ʹ��arr[0...i-1]���ң�������Ϊdp[i-1][j-3*arr[i]]
		 * .
		 * .
		 * .
		 * ����>
		 * dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i]] + dp[i-1][j-2*arr[i]] + dp[i-1][j-3*arr[i]] + ...
		 * 
		 * dp[i-1][j-arr[i]]:�������Ϊ����ʹ��arr[i]����ɽ��Ϊj-arr[i]
		 * dp[i-1][j-2*arr[i]]:�������Ϊ��ʹ��1��arr[i]����ɽ��Ϊj-arr[i]
		 * .
		 * .
		 * .
		 * �������ͣ���ʾΪʹ��arr[0...i]���ң���ɽ��j-arr[i]�ķ�����
		 * ��dp[i][j] = dp[i-1][j] + dp[i][j-arr[i]]
		 */
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < sum + 1; j++) {
				if (arr[i] <= j) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n - 1][sum];
	}
}
