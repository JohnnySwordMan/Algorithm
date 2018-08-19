import java.util.*;

/**
 * 题目：重复值判断练习题 请设计一个高效算法，判断数组中是否有重复值。必须保证额外空间复杂度为O(1)。
 * 给定一个int数组a及它的大小n，请返回它是否有重复值。
 *
 * 分析：对于重复值判断，存在几种方法 方法一：使用HashMap，数组中的元素作为key值，元素出现的次数可以作为value值
 * 方法二：使用变量count来计数(暂时还不知道能不能行)
 * 方法三：先将数组排序，因为重复元素肯定都是连续的。冒泡，选择，插入，希尔，堆排序的空间复杂度都为O(1)。快排的空间复杂度在O(logN)~O(N)，
 * 递归需要用到栈，栈的大小会影响到空间复杂度 效率最高的必定是堆排序，这里的堆排序不能使用递归的方法，只能使用非递归方法 方法四：可以直接使用set集合
 * 
 * 测试样例： [1,2,3,4,5,5,6],7
 *
 * 返回： true
 * 
 * @author geyan
 *
 */
public class Checker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 方法三，先排序，再遍历
	public static boolean checkDuplicate(int[] a, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapDown(a, i, n - 1);
		}

		for (int i = n - 1; i > 0; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapDown(a, 0, i - 1); // 最后一个位置固定了，是每次循环的最大值
		}

		// 遍历，是否存在重复元素
		for (int i = 1; i < n; i++) {
			if (a[i - 1] == a[i]) {
				return true;
			} /*
				 * else { return false; 不能加 }
				 */
		}
		return false;
	}

	// 建立最大堆
	public static void maxHeapDown(int[] a, int start, int end) {
		int c = start;
		int l = 2 * c + 1;
		int temp = a[c];
		for (; l <= end; c = l, l = 2 * l + 1) {
			if (l < end && a[l] < a[l + 1])
				l++;
			if (temp >= a[l]) {
				break;
			} else {
				a[c] = a[l];
				a[l] = temp;
			}
		}
	}

	// 方法四，set集合
	public static boolean checkDuplicate_2(int[] a, int n) {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (set.contains(a[i])) {
				return true;
			} else {
				set.add(a[i]);
			}
		}
		return false;
	}

	/**
	 * 方法一：使用HashMap HashMap额外空间复杂度应该为O(n)。因为根据key值的hash值确定在elementData数组中的位置
	 * 
	 * @param a
	 *            [description]
	 * @param n
	 *            [description]
	 * @return [description]
	 */
	public static boolean checkDuplicate_1(int[] a, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(a[i])) {
				map.put(a[i], 1);
			} else {
				// 只需要直接返回true or false。因为只要判断数组中是否存在重复值
				return true;
			}
		}
		return false;
	}
}
