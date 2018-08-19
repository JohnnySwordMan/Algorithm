/**
 * ��Ŀ������������� ��Ŀ���������������ַ���A��B�����������ַ���������������еĳ���
 * 
 * ���������ǵ��͵Ķ�̬�滮���⣬�����У���Ҫ��������ֻҪ�ַ����˳��һ�¼��ɡ�
 * ������ά����dp[n+1][m+1]��dp[i][j]��ʾ��A[i]��B[j]��β����Ĺ��������г��ȣ� 
 * ��i = 0 �� j = 0��dp[i][j] = 0;
 * ��i,j > 0��A[i] != B[j]��dp[i][j] = max{dp[i-1][j],dp[i][j-1]}; 
 * ��i,j >0��A[i] = B[j]��dp[i][j] = dp[i-1][j-1] + 1
 * 
 * ʱ�临�Ӷȶ�ΪO(n*m)���ռ临�Ӷ�ΪO(n*m)
 * 
 * @author geyan
 *
 */
public class LongestCommonSubsequence {

	/**
	 * �������ַ�������Ĺ���������
	 */
	public int findLCS(String A, int n, String B, int m) {
		if (A == "" || B == "")
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		// ��һ��
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		// ��һ��
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// ע�⣬����a[i] = b[j]��a[i-1],b[j-1]��Ӧ����dp[i][j]����Ϊdp��һ�к͵�һ�ж���Ϊ0��
				// ���磬��i,j��Ϊ1ʱ����a[0],b[0]Ϊ��β��dpֵ����ʵ��Ӧ����dp[1][1]
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

	/**
	 * �������ַ���������������У� ͬʱҪ������������е����ݣ� ����ֻ��Ҫʹ��һ����ά�����¼�ڱ�����������ѡ�������������Ž�
	 */
	public int findLCS_1(String A, int n, String B, int m) {

		if (A == "" || B == "")
			return 0;
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] path = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		// ��һ��
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		// ��һ��
		for (int i = 0; i <= m; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					path[i][j] = 1;
				} else {
					if (dp[i - 1][j] >= dp[i][j - 1]) {
						dp[i][j] = dp[i - 1][j];
						path[i][j] = 2;
					} else {
						dp[i][j] = dp[i][j - 1];
						path[i][j] = 3;
					}
				}
			}
		}
		return dp[n][m];
	}

	// ���LCS���У�printOneLCS(path,a,n,m);
	public void printOneLCS(int[][] path, char[] a, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (path[i][j] == 1) {
			printOneLCS(path, a, i - 1, j - 1);
			System.out.print(a[i - 1] + " -> ");
		} else if (path[i][j] == 2) {
			printOneLCS(path, a, i - 1, j);
		} else {
			printOneLCS(path, a, i, j - 1);
		}
	}

	// ���LCS���У�printOneLCS(dp,a,b,n,m);
	public void printOneLCS_1(int[][] arr, char[] X, char[] Y, int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (X[i - 1] == Y[j - 1]) {
			System.out.print(X[i - 1] + " -> ");
			// Ѱ�ҵ�
			printOneLCS_1(arr, X, Y, i - 1, j - 1);
		} else if (arr[i - 1][j] >= arr[i][j - 1]) {
			printOneLCS_1(arr, X, Y, i - 1, j);
		} else {
			printOneLCS_1(arr, X, Y, i, j - 1);
		}
	}
}
