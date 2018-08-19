import java.util.Stack;

/**
 * 深度优先遍历，邻接矩阵实现
 * @author geyan
 *
 */
public class DFS {

	// 顶点数组
	private char[] vertices;

	// 存储顶点之间的链接关系，邻接矩阵表示
	private int[][] matrix;

	// 顶点个数
	private int vexnum;

	// 记录该顶点是否被访问过
	private boolean[] visited;

	/**
	 * (非递归)深度优先遍历 
	 * 栈实现
	 */
	public void iterativeDFS() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				// 顶点i未被访问，进栈
				stack.add(i);
				while (!stack.empty()) {
					// 如果栈不空，弹出栈顶元素
					int cur = stack.pop();
					if (!visited[cur]) {
						visit(cur);
						visited[cur] = false;
						for (int j = 0; j < vexnum; j++) {
							if (matrix[cur][j] == 1 && !visited[j]) {
								stack.add(j);
							}
						}
					}
				}
			}
		}

	}

	/**
	 * (递归)深度优先遍历
	 */
	public void DFSTraverse() {

		// 初始化顶点访问标记，初始，所有顶点均未被访问
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		// 从未被访问的顶点开始遍历
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				// 进行DFS
				traverse(i);
			}
		}
	}

	// 遍历某个顶点
	private void traverse(int i) {
		visit(i);
		visited[i] = true;
		// 找到i的未被访问的邻接顶点，进行遍历
		for (int j = 0; j < vexnum; j++) {
			if (matrix[i][j] == 1 && !visited[j]) {
				traverse(j);
			}
		}
	}

	// 访问某顶点
	private void visit(int i) {
		System.out.print(i);
	}
}
