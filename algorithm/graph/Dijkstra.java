/**
 * Dijkstra：能够解决权值非负，是单起点，可以求到所有顶点的最短路径。
 * 权值非负的原因在于，假设起点是V0,此时V1也加入到最短路径中，需要判断V0~V2与V0~V1+V1~V2的大小，因为有相加，所以权值不能为负
 * 
 * @author geyan
 *
 */
public class Dijkstra {

	private char[] mVexs;
	private int[][] mMatrix;

	/**
	 * 关键在于对dist数组的操作，与prim算法很类似
	 * 1.dist数组赋值
	 * 2.找出dist数组中最小值
	 * 3.更新dist数组
	 */
	public void dijkstra(int start) {
		int num = mVexs.length;
		boolean[] flag = new boolean[num];
		int[] dist = new int[num];
		for (int i = 0; i < num; i++) {
			flag[i] = false;
			dist[i] = mMatrix[start][i];
		}
		flag[start] = true;
		dist[start] = 0;
		// 需要循环num-1次，每次找出一个顶点的最短路径
		for (int i = 1; i < num; i++) {
			int k = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < num; j++) {
				if (flag[j] == false && dist[j] < min) {
					min = dist[j];
					k = j;
				}
			}
			// 顶点mVexs[k]到起点的路径最小
			flag[k] = true;
			// 修正dist数组
			for (int j = 0; j < num; j++) {
				// 利用顶点mVexs[k]，求出起点mVexs[start]到其他顶点的路径
				int temp = mMatrix[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + mMatrix[k][j]);
				if (!flag[j] && temp < dist[j]) {
					dist[j] = temp;
				}
			}
		}
		// -------------------------------
		// 打印结果，起点mVexs[start]到各顶点的最短路径长度
		for (int i = 0; i < num; i++) {
			System.out.printf("最短路径(%c,%c)=%d\n", mVexs[start], mVexs[i], dist[i]);
		}
	}
}
