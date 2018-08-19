package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��Ŀ������X��Χ��O�滻��X���������O�����ܣ�����Ҫ�滻
 * 
 * ����������ʹ�õ���BFS
 * @author geyan
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length <= 0 || board[0].length <= 0) {
			return;
		}
		int row = board.length;
		int cols = board[0].length;
		for (int i = 0; i < cols; i++) {
			// ��һ��
			bfs(board, 0, i);
			// ���һ��
			bfs(board, row - 1, i);

		}
		for (int i = 0; i < row; i++) {
			// ��һ��
			bfs(board, i, 0);
			// ���һ��
			bfs(board, i, cols - 1);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'B') {
					board[i][j] = 'O';
				}

			}
		}

	}

	private void bfs(char[][] board, int i, int j) {
		int row = board.length;
		int cols = board[0].length;
		Queue<Integer> q = new LinkedList<>();

		q.offer(i * cols + j);
		while (!q.isEmpty()) {
			int index = q.poll();
			int x = index / cols;
			int y = index % cols;
			if (board[x][y] != 'O') {
				continue;
			}
			board[x][y] = 'B';
			// �ҵ�'O'������������Ԫ���±���뵽������
			if (x > 0) {
				q.offer(index - cols);
			}
			if (x < row - 1) {
				q.offer(index + cols);
			}
			if (y > 0) {
				q.offer(index - 1);
			}
			if (y < cols - 1) {
				q.offer(index + 1);
			}
		}
	}
}
