package LeetCode;

/**
 * ��Ŀ�������ַ���s1,s2,s3���ж�s3�Ƿ���s1��s2��˳�򣬽�����ɵġ�
 * ���Ƕ�̬�滮����
 * @author geyan
 *
 */
public class IsInterleave {

	public boolean isInterleave(String s1, String s2, String s3) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		char[] c3 = s3.toCharArray();

		if (c1.length + c2.length != c3.length) {
			return false;
		}

		// �����ά���飬dp[i][j]��ʾc1[0...i]��c2[0...j]�ܷ�˳��ƥ��c3[0...i+j]
		boolean[][] dp = new boolean[c1.length + 1][c2.length + 1];

		// 1.��ʼ������c1��ȡ0���ַ�����c2��ȡ0���ַ�������ƥ��c3[0]
		dp[0][0] = true;

		// 2.��c1��ȡ0���ַ�����c2��ȡi��
		for (int i = 1; i <= c2.length; i++) {
			dp[0][i] = dp[0][i - 1] && (c2[i - 1] == c3[i - 1]);
		}

		// 3.��c1��ȡi���ַ�����c2��ȡ0���ַ�
		for (int i = 1; i <= c1.length; i++) {
			dp[i][0] = dp[i - 1][0] && (c1[i - 1] == c3[i - 1]);
		}

		// 4.��c1��ȡi���ַ�����c2��ȡj���ַ�
		for (int i = 1; i <= c1.length; i++) {
			for (int j = 1; j <= c2.length; j++) {
				// ����ǰһ��
				// 1.��c1��ȡ��i-1����c2��ȡ��j����ƥ��Ľ����dp[i-1][j];��ô���ھͿ���c1��ȡ���ĵ�i�����Ƿ���c3���Ѿ�ƥ��ĺ�һ���ַ���ͬ
				// c1[i-1]��Ŀǰһ��ȡ����i-1+j������ô��һ�������ж�c3�е�i+j���ַ��Ƿ���c1�ĵ�i���ַ���ͬ����c1[i-1]
				// == c3[i+j-1]
				// 2.ͬ��
				dp[i][j] = (dp[i - 1][j] && (c1[i - 1] == c3[i + j - 1]))
						|| (dp[i][j - 1] && (c2[j - 1] == c3[i + j - 1]));
			}
		}
		return dp[c1.length][c2.length];
	}
}
