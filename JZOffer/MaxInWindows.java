import java.util.ArrayList;

/**
 * 题目：滑动窗口的最大值
 * 
 * 参考/algorithm/stackAndQueue/SlideWindow.java
 * @author geyan
 *
 */
public class MaxInWindows {

	// 普通方法，将每次窗口中的最大值求出来
	public ArrayList<Integer> maxInWindows_1(int[] num, int size) {
		ArrayList<Integer> al = new ArrayList<>();
		if (num == null || size == 0) {
			return al;
		}
		int n = num.length;

		// i表示窗口移动
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
