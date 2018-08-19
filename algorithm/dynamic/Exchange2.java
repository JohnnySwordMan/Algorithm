/**
 * ��̬�滮���⣺ʹ��penny�����е�Ӳ�ң�����ʹ�ö��ٸ�Ӳ�ҿ������target���
 * 
 * dp[i] = j,ƴ��iԪ����ʹ��j��Ӳ��
 * @author geyan
 *
 */
public class Exchange2 {

	public int countWays(int[] penny, int target) {
		if (penny == null || penny.length == 0 || target == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		for (int i = 1; i <= target; i++) {
			// ��ʼ����iԪ���޷�ƴ�յ�
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < penny.length; j++) {
				// penny[j]С��ƴ�ս���ʹ��һöpenny[j]Ӳ�ң�ʣ�µĽ���ǿ���ƴ�յ�
				if (penny[j] <= i && dp[i - penny[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - penny[j]] + 1);
				}
			}
		}
		if (dp[target] == Integer.MAX_VALUE) {
			return -1;
		} else {
			return dp[target];
		}
	}
}
