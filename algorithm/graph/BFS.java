import java.util.LinkedList;
import java.util.Queue;

/**
 * 宽度优先遍历(广度优先遍历)，邻接矩阵实现
 * 
 * @author geyan
 *
 */
public class BFS {

	// 顶点数组
	private char[] vertices;

	// 存储顶点之间的链接关系，邻接矩阵表示
	private int[][] matrix;

	// 顶点个数
	private int vexnum;

	// 记录该顶点是否被访问过
	private boolean[] visited;

	/**
	 * 广度优先遍历，类似于二叉树的层次遍历
	 */
	public void BFSTraverse() {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				visit(i);
				visited[i] = true;
				queue.offer(i);
				while (!queue.isEmpty()) {
					int cur = queue.poll();
					for (int j = 0; j < vexnum; j++) {
						if (matrix[cur][j] == 1 && !visited[j]) {
							visit(j);
							visited[j] = true;
							queue.offer(j);
						}
					}
				}
			}
		}
	}

	private void visit(int i) {
		System.out.print(i);
	}
}
