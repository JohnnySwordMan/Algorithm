import java.util.Scanner;

/**
 * ��Ŀ�����ֺ�Ϊsum�ķ�����
 * ��Ŀ����������һ����n��������������A��һ������sum����ѡ������A�в������ֺ�Ϊsum�ķ�������
 * 
 * ע��㣺 1.���ͨ�����Ѿ��ﵽ80%��������int�ô��ˣ����Ի���long����
 * 
 * @author geyan
 *
 */
public class Solution_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			// �����СΪn+1
			int[] arr = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				arr[i] = sc.nextInt();
			}
			test(arr, n, sum);
		}
	}

	/**
	 * ��̬�滮���ͽ�Ǯ����������һ����
	 * dp[i][j]��ʾ��ǰi��ֵ��ɺ�Ϊj�ķ�������
	 * 1.��ʹ��arr[i]��dp[i][j] = dp[i-1][j];
	 * 2.ʹ��arr[i]��dp[i][j] = dp[i-1][j-arr[i]];
	 */
	private static void test(int[] arr, int n, int sum) {
		// long��������int
		long[][] dp = new long[n + 1][sum + 1];
		dp[0][0] = 1;
		for (int i = 1; i < n + 1; i++) {
			for (int j = 0; j < sum + 1; j++) {
				if (j >= arr[i]) {
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n][sum]);
	}
}
