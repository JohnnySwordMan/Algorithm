/**
 * Dijkstra���ܹ����Ȩֵ�Ǹ����ǵ���㣬���������ж�������·����
 * Ȩֵ�Ǹ���ԭ�����ڣ����������V0,��ʱV1Ҳ���뵽���·���У���Ҫ�ж�V0~V2��V0~V1+V1~V2�Ĵ�С����Ϊ����ӣ�����Ȩֵ����Ϊ��
 * 
 * @author geyan
 *
 */
public class Dijkstra {

	private char[] mVexs;
	private int[][] mMatrix;

	/**
	 * �ؼ����ڶ�dist����Ĳ�������prim�㷨������
	 * 1.dist���鸳ֵ
	 * 2.�ҳ�dist��������Сֵ
	 * 3.����dist����
	 */
	public void dijkstra(int start, int[] dist) {
		int num = mVexs.length;
		boolean[] flag = new boolean[num];
		for (int i = 0; i < num; i++) {
			flag[i] = false;
			dist[i] = mMatrix[start][i];
		}
		// ��Ҫѭ��num-1�Σ�ÿ���ҳ�һ����������·��
		for (int i = 1; i < num; i++) {
			int k = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < num; j++) {
				if (flag[j] == false && dist[j] < min) {
					min = dist[j];
					k = j;
				}
			}
			// ����mVexs[k]������·����С
			flag[k] = true;
			// ����dist����
			for (int j = 0; j < num; j++) {
				// ���ö���mVexs[k]��������mVexs[start]�����������·��
				int temp = mMatrix[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + mMatrix[k][j]);
				if (!flag[j] && temp < dist[j]) {
					dist[j] = temp;
				}
			}
		}
		// -------------------------------
		// ��ӡ��������mVexs[start]������������·������
		for (int i = 0; i < num; i++) {
			System.out.printf("���·��(%c,%c)=%d\n", mVexs[start], mVexs[i], dist[i]);
		}
	}
}
