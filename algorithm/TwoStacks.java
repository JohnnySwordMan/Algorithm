import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：双栈排序 请编写一个程序，按升序对栈进行排序(即最大元素位于栈顶)，要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
 * 给定一个int[] numbers，其中第一个元素为栈顶，请返回排序后的栈。请注意这是一个栈，意味着排序过程中你只能访问到第一个元素。
 * 测试样例：[1,2,3,4,5] 返回：[5,4,3,2,1]
 * 
 * 分析： 假设对Stack栈中数据进行从到小排序，创建一个新的help栈，首先将Stack栈顶元素弹出，为current，
 * 如果current小于等于help当前栈顶元素， 则将current元素push到help栈中，
 * 如果current元素大于help栈顶的元素，则将help栈顶元素弹出并压入到Stack栈中，直至current元素小于等于help栈顶元素，
 * 等Stack栈为空时，此时将help栈中元素全部弹出并压入到Stack栈中。
 * 注意，本题是从大到小排序，输出。如果是从小到大排序，那么help栈中必须是从大到小排序，所以此时的cur，即stack.pop()和helpStack.peek()的判断应该和原来的相反。
 * 
 * @author geyan
 *
 */
public class TwoStacks {

	// 使用数组来模拟help栈，help[0]表示栈底，help[n-1]表示栈顶
	public static ArrayList<Integer> twoStackSort_1(int[] numbers) {
		int n = numbers.length;
		int[] help = new int[n];
		// i用于stack栈中，即numbers，j用于help栈中，即help
		int i = 0, j = n;
		int cur;
		// 根据题目意思，numbers[0]为栈顶元素，i<n，表示stack栈不为空
		while (i < n) {
			cur = numbers[i++];
			if (j == n) {
				// 表示help数组为空，即help栈为空
				help[--j] = cur;
			} else if (cur <= help[j]) {
				// 如果Stack栈中弹出的元素小于等于help栈顶元素，则将弹出的元素push到help栈中
				help[--j] = cur;
			} else if (cur > help[j]) {
				// 如果Stack栈中弹出的元素大于help栈顶的元素，则将help栈中小于cur的元素依次弹出push到Stack栈中，将Stack弹出的元素push到help栈中
				while (j < n && cur > help[j]) {
					numbers[--i] = help[j++];
				}
				help[--j] = cur;
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int m = 0; m < n; m++) {
			list.add(help[n - m - 1]);
		}
		return list;

	}

	public static ArrayList<Integer> twoStackSort(int[] numbers) {
		// 不按题目意思来
		// 先将numbers数组压入Stack栈中
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> helpStack = new Stack<>();
		for (int i = numbers.length - 1; i >= 0; i--) {
			stack.push(numbers[i]);
		}
		// 此时对Stack栈中元素排序
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (helpStack.isEmpty()) {
				helpStack.push(cur);
			} else if (cur <= helpStack.peek()) {
				helpStack.push(cur);
			} else if (cur > helpStack.peek()) {
				while (!helpStack.isEmpty() && cur > helpStack.peek()) {
					stack.push(helpStack.pop());
				}
				helpStack.push(cur);
			}
		}
		ArrayList<Integer> al = new ArrayList<>();
		while (!helpStack.isEmpty()) {
			stack.push(helpStack.pop());
		}
		while (!stack.isEmpty()) {
			al.add(stack.pop());
		}
		return al;
	}
}
