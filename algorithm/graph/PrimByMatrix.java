/**
 * 邻接矩阵表示下的图的prim算法 Prim:求最小生成树，n个顶点,n-1条边，且权值之和最小
 * 开始选择任意顶点V0，从剩余顶点中选择与VO相连的(即未加入到最小生成树的V0的邻居节点)，且权值最小的(假设选择的是V3)，那么将V0,
 * V3及其连边加入到最小生成树中 然后从与V0,V3的邻居节点中选择权值最小的(比如V4)，再从V0,V3,V4的邻居节点中选择权值最小的...
 * 
 * @author geyan
 *
 */
public class PrimByMatrix {

	// 图的顶点集合
	private char[] mVexs;

	// 邻接矩阵
	private int[][] mMatrix;

	/**
	 * 关键点就在于对weights数组的操作 
	 * 1.weights数组赋值 
	 * 2.找出weights数组中最小值 
	 * 3.更新weights数组
	 * 
	 * @param start
	 *            从图中第start节点开始生成最小树
	 */
	public void prim(int start) {
		int num = mVexs.length;

		// prim的结果数组
		char[] prim = new char[num];
		int index = 0;
		// 首先将start顶点加入到最小生成树中
		prim[index++] = mVexs[start];

		// 不是各个顶点间的权值，weights[i]表示已加入到最小生成树中的顶点到未加入到最小生成树中的顶点i的权值
		// 这样和图的遍历是类似的，都是需要将顶点分为两个部分，不同的是图的遍历，可以定义bool数组来表示是否已经被访问
		// 这里涉及到权值，没有必要再去定义bool数组，可以设置令weights[i]=0,表示节点i已经加入到最小生成树中
		int[] weights = new int[num];

		for (int i = 0; i < num; i++) {
			// 以start为起点，将start到各个顶点的权值依次赋值给weights数组
			weights[i] = mMatrix[start][i];
		}

		// 若start已经加入到最小生成树中
		weights[start] = 0;

		// 每一次的循环需要找出weights数组中的最小值，然后更新weights
		for (int i = 0; i < num; i++) {
			if (i == start)
				continue;
			int j = 0;
			int k = 0;
			int min = Integer.MAX_VALUE;
			// 在未被加入到最小生成树的顶点中，找出权值最小的顶点
			while (j < num) {
				// weights[j]!=0表示mVexs[j]节点并没有加入到最小生成树中，类似与图的遍历中的visited[j]
				if (weights[j] != 0 && weights[j] < min) {
					min = weights[j];
					k = j;
				}
				j++;
			}

			// 此时，权值最小的顶点就是mVexs[k]，将该顶点加入到最小生成树中
			prim[index++] = mVexs[k];
			// 因为mVexs[k]顶点已经加入到最小生成树中，所以weights[k]=0
			// 更新weights数组，其实就是找出k与其他顶点的的权值和start与其他顶点的权值，如果前者小，则更新对应weights数组元素
			for (j = 0; j < num; j++) {
				if (weights[j] != 0 && mMatrix[k][j] < weights[j]) {
					weights[j] = mMatrix[k][j];
				}
			}
		}
		// ----------------------------------------------------------------

		/**
		 * prim数组中元素就是依次加入到最小生成树的顶点
		 */
	}
}
