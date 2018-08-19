/**
 * 题目：小范围排序
 * 已知一个几乎有序的数组，几乎有序是指，如果把数组排好顺序的话，每个元素移动的距离可以不超过k，并且k相对于数组来说比较小。请选择一个合适的排序算法针对这个数据进行排序
 * 给定一个int数组A，同时给定A的大小和题意中的k，请返回排序后的数组。
 * 测试样例：
 * [2,1,4,3,6,5,8,7,10,9],10,2
 * 
 * 返回：
 * [1,2,3,4,5,6,7,8,9,10]
 *
 * 
 * 分析：如果把数组排好顺序的话，每个元素移动的距离可以不超过k。那么最小值必定就在下标0~k-1之间(包含0和k-1)
 * 那么可以先把a[0]~a[k-1]建立最小堆，输出堆顶元素，再将a[k]加入，重新建立最小堆，再次输出堆顶元素。
 */
import java.util.*;

public class ScaleSort {
	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 10, 9 };
		int[] arr = sortElement(a, 10, 2);
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static int[] sortElement(int[] a, int n, int k) {
		if (n == 0 || n < k)
			return a;

		// 先取数组a的前k个，始终以heap数组中元素建堆
		int[] heap = Arrays.copyOf(a, k);

		// 建立最小堆，最小堆建立之后，堆顶元素也就是heap[0]是最小值！
		for (int i = k / 2 - 1; i >= 0; i--) {
			minHeapDown(heap, i, k - 1);
		}

		// 每次取出最小堆的根，换为新的元素，再调用minHeapDown维护最小堆
		for (int i = 0; i < n - k; i++) {
			a[i] = heap[0];
			heap[0] = a[i + k]; // 当i=n-k-1时，即heap[0] = a[n-1]时，建立最小堆
			minHeapDown(heap, 0, k - 1);
		}

		// 将根和尾节点交换，完成堆排序。将heap数组中最后k个元素元素排序，且后续没有元素加入
		for (int i = n - k; i < n; i++) {
			a[i] = heap[0];
			// 交换heap[0]和heap[k-1]，并去掉原堆顶元素(最小的)
			swap(heap, 0, k - 1);
			k--;
			minHeapDown(heap, 0, k - 1);
		}
		return a;
	}

	/**
	 * 建立最小堆
	 * 
	 * @param a
	 *            [description]
	 * @param start
	 *            [description]
	 * @param end
	 *            [description]
	 * @return [description]
	 */
	public static void minHeapDown(int[] a, int start, int end) {
		int c = start;
		int l = 2 * c + 1; // 数组下标从0开始
		int temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			// 找出左右孩子中较小的那个
			if (l < end && a[l] > a[l + 1]) {
				l++;
			}
			if (temp <= a[l]) { // 父亲节点的值小于等于孩子节点的值
				break;
			} else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

}