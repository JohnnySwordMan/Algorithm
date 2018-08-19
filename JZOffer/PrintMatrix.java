import java.util.ArrayList;

/**
 * 面试题20：顺时针打印矩阵
 * 题目描述：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。如果输入如下矩阵：
 * 1  2  3  4
 * 5  6  7  8
 * 9 10 11 12
 * 13 14 15 16
 * 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,8,12,11,10
 * 
 * 分析：画图，有助于理清思路，注意发生的边界条件
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
		int endY = columns - 1 - start; // 终止列号
		int endX = rows - 1 - start; // 终止行号

		// 从左到右打印一行
		for (int i = start; i <= endY; i++) {
			arrayList.add(matrix[start][i]);
		}

		// 从上到下打印一列，前提是终止行号大于起始行号
		if (start < endX) {
			for (int i = start + 1; i <= endX; i++) {
				arrayList.add(matrix[i][endY]);
			}
		}

		// 从右到左打印一行，前提是终止行号大于起始行号，终止列号大于起始列号
		if (start < endX && start < endY) {
			for (int i = endY - 1; i >= start; i--) {
				arrayList.add(matrix[endX][i]);
			}
		}

		// 从下到上打印一列，前提是终止列号大于起始列号，终止行号-1大于起始行号(因为从右到左打印一行，已经将该终止行号打印了，所以从终止行号-1开始打印)
		if (start < endY && start < endX - 1) {
			for (int i = endX - 1; i > start; i--) {
				arrayList.add(matrix[i][start]);
			}
		}
		// return arrayList;
	}
}
