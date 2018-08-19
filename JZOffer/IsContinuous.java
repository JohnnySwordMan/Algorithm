import java.util.Arrays;

/**
 * 面试题：扑克牌顺子 
 * 题目描述：从扑克牌中随机抽 5 张牌，判断是不是一个顺子， 即这 5 张牌是不是连续的。2～10 为数字本身， A 为 1。 J 为
 * 11、Q 为 12、 K为 13。大小王可以看成任意数字。为了方便起见，可以认为大小王是0.
 * 
 * 分析：怎么判断这5个数字是否连续。最直观的方法就是排序。由于0可以当作任意数字，可以用0去填补数组中空缺的数字。
 * 那么，我们所要做的工作就是， 
 * 1.遍历数组，计算0的个数
 * 2.遍历数组，计算相邻位置上的数字空缺总数，这些空缺总数如果是小于等于0的个数，则数组是连续的，否则是不连续的 
 * 3.如果数组中存在相同的非0数字，则不是顺子
 * 
 * @author geyan
 *
 */
public class IsContinuous {

	public boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length < 5)
			return false;
		sort_asc(numbers, numbers.length);
		// Arrays.sort(numbers);
		// 记录0的个数
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 0)
				count++;
		}
		// 记录数字之间的空缺总数
		int sum = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] != 0 && numbers[i + 1] != 0) {
				// temp表示空缺的总数，不能忘记-1
				int temp = numbers[i + 1] - numbers[i] - 1;
				/*
				 * if (temp == 1) { // 1,3 sum++; }
				 */
				if (temp >= 1) {
					sum += temp;
				} else if (temp == 0) {
					// 1,2
					continue;
				} else if (temp == -1) {
					// 1,1
					// 存在相同的非0 的数字
					return false;
				}
			}
		}
		// 空缺总数小于等于0的个数
		if (sum <= count) {
			return true;
		} else {
			return false;
		}
	}

	// 堆排序，排序一律手写，正好可以练习
	private void sort_asc(int[] arr, int n) {
		// 建堆
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(arr, i, n - 1);
		}
		// 交换，建堆
		for (int i = n - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			maxHeapDown(arr, 0, i - 1);
		}
	}

	// 建堆
	private void maxHeapDown(int[] arr, int start, int end) {
		int c = start, l = 2 * c + 1;
		int temp = arr[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && arr[l] < arr[l + 1])
				l++;
			if (temp >= arr[l]) {
				break;
			} else {
				arr[c] = arr[l];
				arr[l] = temp;
			}
		}
	}
}
