/**
 * �ڽӾ����ʾ�µ�ͼ��prim�㷨 Prim:����С��������n������,n-1���ߣ���Ȩֵ֮����С
 * ��ʼѡ�����ⶥ��V0����ʣ�ඥ����ѡ����VO������(��δ���뵽��С��������V0���ھӽڵ�)����Ȩֵ��С��(����ѡ�����V3)����ô��V0,
 * V3�������߼��뵽��С�������� Ȼ�����V0,V3���ھӽڵ���ѡ��Ȩֵ��С��(����V4)���ٴ�V0,V3,V4���ھӽڵ���ѡ��Ȩֵ��С��...
 * 
 * @author geyan
 *
 */
public class PrimByMatrix {

	// ͼ�Ķ��㼯��
	private char[] mVexs;

	// �ڽӾ���
	private int[][] mMatrix;

	/**
	 * �ؼ�������ڶ�weights����Ĳ��� 
	 * 1.weights���鸳ֵ 
	 * 2.�ҳ�weights��������Сֵ 
	 * 3.����weights����
	 * 
	 * @param start
	 *            ��ͼ�е�start�ڵ㿪ʼ������С��
	 */
	public void prim(int start) {
		int num = mVexs.length;

		// prim�Ľ������
		char[] prim = new char[num];
		int index = 0;
		// ���Ƚ�start������뵽��С��������
		prim[index++] = mVexs[start];

		// ���Ǹ���������Ȩֵ��weights[i]��ʾ�Ѽ��뵽��С�������еĶ��㵽δ���뵽��С�������еĶ���i��Ȩֵ
		// ������ͼ�ı��������Ƶģ�������Ҫ�������Ϊ�������֣���ͬ����ͼ�ı��������Զ���bool��������ʾ�Ƿ��Ѿ�������
		// �����漰��Ȩֵ��û�б�Ҫ��ȥ����bool���飬����������weights[i]=0,��ʾ�ڵ�i�Ѿ����뵽��С��������
		int[] weights = new int[num];

		for (int i = 0; i < num; i++) {
			// ��startΪ��㣬��start�����������Ȩֵ���θ�ֵ��weights����
			weights[i] = mMatrix[start][i];
		}

		// ��start�Ѿ����뵽��С��������
		weights[start] = 0;

		// ÿһ�ε�ѭ����Ҫ�ҳ�weights�����е���Сֵ��Ȼ�����weights
		for (int i = 0; i < num; i++) {
			if (i == start)
				continue;
			int j = 0;
			int k = 0;
			int min = Integer.MAX_VALUE;
			// ��δ�����뵽��С�������Ķ����У��ҳ�Ȩֵ��С�Ķ���
			while (j < num) {
				// weights[j]!=0��ʾmVexs[j]�ڵ㲢û�м��뵽��С�������У�������ͼ�ı����е�visited[j]
				if (weights[j] != 0 && weights[j] < min) {
					min = weights[j];
					k = j;
				}
				j++;
			}

			// ��ʱ��Ȩֵ��С�Ķ������mVexs[k]�����ö�����뵽��С��������
			prim[index++] = mVexs[k];
			// ��ΪmVexs[k]�����Ѿ����뵽��С�������У�����weights[k]=0
			// ����weights���飬��ʵ�����ҳ�k����������ĵ�Ȩֵ��start�����������Ȩֵ�����ǰ��С������¶�Ӧweights����Ԫ��
			for (j = 0; j < num; j++) {
				if (weights[j] != 0 && mMatrix[k][j] < weights[j]) {
					weights[j] = mMatrix[k][j];
				}
			}
		}
		// ----------------------------------------------------------------

		/**
		 * prim������Ԫ�ؾ������μ��뵽��С�������Ķ���
		 */
	}
}
