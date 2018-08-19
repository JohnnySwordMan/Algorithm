import java.util.Stack;

/**
 * ������ȱ������ڽӾ���ʵ��
 * @author geyan
 *
 */
public class DFS {

	// ��������
	private char[] vertices;

	// �洢����֮������ӹ�ϵ���ڽӾ����ʾ
	private int[][] matrix;

	// �������
	private int vexnum;

	// ��¼�ö����Ƿ񱻷��ʹ�
	private boolean[] visited;

	/**
	 * (�ǵݹ�)������ȱ��� 
	 * ջʵ��
	 */
	public void iterativeDFS() {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				// ����iδ�����ʣ���ջ
				stack.add(i);
				while (!stack.empty()) {
					// ���ջ���գ�����ջ��Ԫ��
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
	 * (�ݹ�)������ȱ���
	 */
	public void DFSTraverse() {

		// ��ʼ��������ʱ�ǣ���ʼ�����ж����δ������
		for (int i = 0; i < vexnum; i++) {
			visited[i] = false;
		}
		// ��δ�����ʵĶ��㿪ʼ����
		for (int i = 0; i < vexnum; i++) {
			if (!visited[i]) {
				// ����DFS
				traverse(i);
			}
		}
	}

	// ����ĳ������
	private void traverse(int i) {
		visit(i);
		visited[i] = true;
		// �ҵ�i��δ�����ʵ��ڽӶ��㣬���б���
		for (int j = 0; j < vexnum; j++) {
			if (matrix[i][j] == 1 && !visited[j]) {
				traverse(j);
			}
		}
	}

	// ����ĳ����
	private void visit(int i) {
		System.out.print(i);
	}
}
