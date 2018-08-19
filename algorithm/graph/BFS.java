import java.util.LinkedList;
import java.util.Queue;

/**
 * ������ȱ���(������ȱ���)���ڽӾ���ʵ��
 * 
 * @author geyan
 *
 */
public class BFS {

	// ��������
	private char[] vertices;

	// �洢����֮������ӹ�ϵ���ڽӾ����ʾ
	private int[][] matrix;

	// �������
	private int vexnum;

	// ��¼�ö����Ƿ񱻷��ʹ�
	private boolean[] visited;

	/**
	 * ������ȱ����������ڶ������Ĳ�α���
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
