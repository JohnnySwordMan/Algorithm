import java.util.ArrayList;

/**
 * ��Ŀ��Ҫ��һ���������дӶ����׵���С·���ͣ��ռ临�Ӷ�ΪO(n)
 * @author geyan
 *
 */
public class MinimumTotal {

	/**
	 * �Ե����� ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1)�������޸���ԭ�е����� �ӵ����ڶ��п�ʼ�����е�һ����+����һ�У������ڵĽ�Сֵ��
	 * ����˵6+min(4,1),5+min(1,8),7+min(8,3)
	 */
	public int minimumTotal_1(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() <= 0) {
			return 0;
		}
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				// �ҳ���i+1�еĵ�j�к͵�i+1�еĵ�j+1�еĽ�Сֵ
				int min = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1));
				triangle.get(i).set(j, triangle.get(i).get(j) + min);
			}
		}
		return triangle.get(0).get(0);
	}

	/**
	 * �Զ����£� ����dp[m][n]�����˵�m�е�n���ڵ����С·���ͣ��� 
	 * dp[m+1][n] = min(dp[m][n],dp[m][n-1])+triangle[m+1][n]; n>0 
	 * dp[m+1][0] = dp[m][0] + triangle[m+1][0];
	 * �ռ临�Ӷȱ���ΪO(n)������������Ҫ�������㣬ʹ��һ��һά���鱣��ÿ�����С·���ͣ�Ϊ�˷�ֹ�����ʱ�򲻸�����ǰ��ֵ��������Ҫ�Ӻ���ǰ���㡣
	 */
	public int minimumTotal_2(ArrayList<ArrayList<Integer>> triangle) {
		int row = triangle.size();
		if (triangle == null || row <= 0) {
			return 0;
		}
		int[] dp = new int[row];
		int minTotal = Integer.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		dp[0] = triangle.get(0).get(0);
		for (int i = 1; i < row; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == 0) {
					dp[j] = dp[j] + triangle.get(i).get(j);
				} else {
					dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
				}
			}
		}
		for (int i = 0; i < row; i++) {
			minTotal = Math.min(minTotal, dp[i]);
		}
		return minTotal;
	}
}
