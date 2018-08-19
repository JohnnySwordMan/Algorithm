import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：滑动窗口 有一个整型数组 arr 和一个大小为 w 的窗口从数组的最左边滑到最右边,窗口每次向右边滑一个位置。
 * 返回一个长度为n-w+1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 以数组为[4,3,5,4,3,3,6,7]，w=3为例。因为第一个窗口[4,3,5]的最大值为5，第二个窗口[3,5,4]的最大值为5，第三个窗口[5,4
 * ,3]的最大值为5。第四个窗口[4,3,3]的最大值为4。
 * 第五个窗口[3,3,6]的最大值为6。第六个窗口[3,6,7]的最大值为7。所以最终返回[5,5,5,4,6,7]。
 * 给定整形数组arr及它的大小n，同时给定w，请返回res数组。保证w小于等于n，同时保证数组大小小于等于500。 测试样例：
 * [4,3,5,4,3,3,6,7]，8，3 返回： [5,5,5,4,6,7] 注意：边界条件，在编程过程中，注意下标的取值，有无等号存在
 * 
 * @author geyan
 *
 */
public class SlideWindow {

	// 普通解法，时间复杂度为O(N*w)，也就是每次对每一个窗口遍历其中的w个数，选出最大值。
	public int[] slide_1(int[] arr, int n, int w) {
		int[] res = new int[n - w + 1];
		int index = 0;
		for (int i = 0; i < n - w + 1; i++) { // i<n-w+1，而不是i<n-w，循环n-w+1次
			res[index++] = max(arr, i, i + w - 1);
		}
		// res[index] = max(arr,n-w-1,n-1);
		return res;
	}

	/**
	 * 最优解时间复杂度可以做到O(N)，使用双端队列 双端队列qmax={}，双端队列存放着数组中的下标值，假设当前数为arr[i]，放入规则如下：
	 * 1.如果qmax为空，直接把下标i放入qmax中
	 * 2.如果qmax不为空，取出当前qmax队尾存放的下标j，如果arr[j]>arr[i]，直接把下标i放进qmax的队尾
	 * 3.如果arr[j]<=arr[i]，则一直从qmax的队尾弹出下标，直到某个下标在qmax中对应的值大于arr[i]，把i放入qmax的队尾。
	 * 如果qmax队头的下标等于i-w，弹出qmax当前队头下标
	 */
	public int[] slide(int[] arr, int n, int w) {
		int[] res = new int[n - w + 1];
		if (arr == null || w > n)
			return res;
		int index = 0;
		// 创建双端队列
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			// 尾部添加元素
			if (deque.isEmpty() || arr[deque.peekLast()] > arr[i]) {
				deque.offerLast(i);
			} else {
				// 尾部删除元素
				while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
					deque.pollLast();
				}
				deque.offerLast(i);
			}
			if (i >= w - 1) {
				// 如果队头元素，即数组下标等于i-w，则弹出当前队头下标
				while (!deque.isEmpty() && deque.peekFirst() == i - w) {
					deque.pollFirst();
				}
				res[index++] = arr[deque.peekFirst()];
			}

		}
		return res;
	}

	// 找到数组中，从下标start到end的最大值，只是找出最大值，不需要排序
	public static int max(int[] a, int start, int end) {
		int max = start;
		for (int i = start + 1; i <= end; i++) { // i<=end，不是i<end
			if (a[max] < a[i])
				max = i;
		}
		return a[max];
	}
}
