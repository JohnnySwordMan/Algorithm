import java.util.ArrayList;

/**
 * ������20��˳ʱ���ӡ����
 * ��Ŀ����������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֡�����������¾���
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,8,12,11,10
 * 
 * ��������ͼ������������˼·��ע�ⷢ���ı߽�����
 * @author geyan
 *
 */
public class PrintMatrix {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		int rows = matrix.length, columns = matrix[0].length;
		return printMatrixClockwisely(matrix, rows, columns);
	}

	public ArrayList<Integer> printMatrixClockwisely(int[][] matrix, int rows, int columns) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if (matrix == null || rows <= 0 || columns <= 0) {
			return arrayList;
		}
		int start = 0;
		while (rows > start * 2 && columns > start * 2) {
			printMatrixInCircle(matrix, rows, columns, start, arrayList);
			start++;
		}
		return arrayList;
	}

	public void printMatrixInCircle(int[][] matrix, int rows, int columns, int start, ArrayList<Integer> arrayList) {
		// ArrayList<Integer> arrayList = new ArrayList<>();
		int endY = columns - 1 - start; // ��ֹ�к�
		int endX = rows - 1 - start; // ��ֹ�к�

		// �����Ҵ�ӡһ��
		for (int i = start; i <= endY; i++) {
			arrayList.add(matrix[start][i]);
		}

		// ���ϵ��´�ӡһ�У�ǰ������ֹ�кŴ�����ʼ�к�
		if (start < endX) {
			for (int i = start + 1; i <= endX; i++) {
				arrayList.add(matrix[i][endY]);
			}
		}

		// ���ҵ����ӡһ�У�ǰ������ֹ�кŴ�����ʼ�кţ���ֹ�кŴ�����ʼ�к�
		if (start < endX && start < endY) {
			for (int i = endY - 1; i >= start; i--) {
				arrayList.add(matrix[endX][i]);
			}
		}

		// ���µ��ϴ�ӡһ�У�ǰ������ֹ�кŴ�����ʼ�кţ���ֹ�к�-1������ʼ�к�(��Ϊ���ҵ����ӡһ�У��Ѿ�������ֹ�кŴ�ӡ�ˣ����Դ���ֹ�к�-1��ʼ��ӡ)
		if (start < endY && start < endX - 1) {
			for (int i = endX - 1; i > start; i--) {
				arrayList.add(matrix[i][start]);
			}
		}
		// return arrayList;
	}
}
