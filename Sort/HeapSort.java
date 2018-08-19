/**
 * 堆排序的过程，就是建堆--->交换--->建堆 时间复杂度为O(N*logN)，空间复杂度为O(1)，不稳定
 * 
 * @author geyan
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// int[] a = { 110, 100, 90, 40, 80, 20, 60, 10, 30, 50, 70 };
		int[] a = { 50, 10, 90, 30, 70, 40, 80, 60, 20 };
		sort_asc(a, a.length);
		// sort_des(a, a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 从小到大排序，建立最大堆，将堆顶元素与最末元素交换，对除最后一个元素外的元素重新建堆。
	 * 
	 * @param a
	 * @param n
	 */
	public static void sort_asc(int[] a, int n) {

		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(a, i, n - 1); // 建立最大堆
		}

		// 交换，再建堆
		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapDown(a, 0, i - 1);
		}
	}

	/**
	 * 从大到小排序，建立最小堆
	 * 
	 * @param a
	 * @param n
	 */
	public static void sort_des(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapDown(a, i, n - 1); // 建立最小堆
		}

		// 交换，再建堆
		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			minHeapDown(a, 0, i - 1);
		}
	}

	/**
	 * 建立最大堆 数组下标从0开始，若节点下标为c，那么节点c的左孩子的下标为2*c+1。(这里应该是+1)
	 * 
	 * @param a
	 * @param start
	 * @param end
	 */
	private static void maxHeapDown(int[] a, int start, int end) {
		int c = start, l = 2 * c + 1, temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// 先找到节点c的左右孩子节点中较大的孩子
			if (l < end && a[l] < a[l + 1])
				l++;
			// 父节点与较大的孩子节点比较
			if (temp >= a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	private static void minHeapDown(int[] a, int start, int end) {
		int c = start, l = 2 * c + 1, temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// 先找到节点c的左右孩子节点中较小的孩子
			if (l < end && a[l] > a[l + 1])
				l++;
			// 父节点与较小的孩子节点比较
			if (temp <= a[l])
				break;
			else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}
}
