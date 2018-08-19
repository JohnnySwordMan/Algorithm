import java.util.LinkedList;
import java.util.List;

/**
 * 面试题45：圆圈中最后剩下的数字(约瑟夫环)
 * 题目描述：0，1，...n-1这n个数字拍成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 * 
 * @author geyan
 *
 */
public class LastRemaining {

	/**
	 * 使用数组模拟
	 */
	public int lastRemaining_1(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		// 定义一个数组来模拟环，删除元素，则可以将对应下标的元素置为-1
		int[] array = new int[n];
		// i记录数组下标，step记录数过的有效数，count表示剩余数量
		int i = -1, step = 0, count = n;
		while (count > 0) {
			i++;
			// 模拟环
			if (i >= n)
				i = 0;
			// 是否被删除过
			if (array[i] == -1)
				continue;
			step++;
			if (step == m) {
				array[i] = -1;
				step = 0;
				count--;
			}
		}
		return i;
	}

	/**
	 * 使用LinkedList
	 */
	public int lastRemaining_2(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		List<Integer> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}
		// 要删除元素的位置
		int index = 0;
		while (list.size() > 1) {
			// 走m-1次
			for (int i = 1; i < m; i++) {
				// %模拟圆
				index = (index + 1) % list.size();
			}
			list.remove(index);
		}
		return list.get(0);
	}

	public int lastRemaining_3(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		if (n == 1)
			return 0;
		return ((lastRemaining_3(n - 1, m) + m) % n);
	}

	public int lastRemaining_4(int n, int m) {
		if (n < 1 || m < 1)
			return -1;
		int last = 0;
		for (int i = 2; i <= n; i++) {
			last = (last + m) % i;
		}
		return last;
	}
}
