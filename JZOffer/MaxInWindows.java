import java.util.ArrayList;

/**
 * ��Ŀ���������ڵ����ֵ
 * 
 * �ο�/algorithm/stackAndQueue/SlideWindow.java
 * @author geyan
 *
 */
public class MaxInWindows {

	// ��ͨ��������ÿ�δ����е����ֵ�����
	public ArrayList<Integer> maxInWindows_1(int[] num, int size) {
		ArrayList<Integer> al = new ArrayList<>();
		if (num == null || size == 0) {
			return al;
		}
		int n = num.length;

		// i��ʾ�����ƶ�
		for (int i = 0; i < n - size + 1; i++) {
			al.add(max(num, i, i + size - 1));
		}
		return al;
	}

	public int max(int[] a, int start, int end) {
		int max = start;
		for (int i = start + 1; i <= end; i++) {
			if (a[max] < a[i]) {
				max = i;
			}
		}
		return a[max];
	}
}
