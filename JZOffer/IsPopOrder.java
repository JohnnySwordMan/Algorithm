import java.util.Stack;

/**
 * 面试题22：栈的压入、弹出序列
 * 题目描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 
 * 分析：建立一个辅助栈，把输入的第一个序列中的数字依次压入该辅助栈，并按照第二个序列的顺序依次从该栈中弹出数字。
 * 总结上述入栈、出栈的过程，我们可以找到判断一个序列是不是栈的弹出序列的规律：
 * 1.如果下一个弹出的数字刚刚好是栈顶数字，那么直接弹出。
 * 2.如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
 * 3.如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
 * @author geyan
 *
 */
public class IsPopOrder {

	public boolean isPopOrder(int[] pushA, int[] popA) {
		// 用于记录判断出栈顺序是不是入栈
		boolean isPossible = false;
		// 当入栈和出栈数组都不为空，都有数据，数据个数也一样
		if (pushA != null && popA != null && pushA.length == popA.length) {
			// 定义辅助栈，用于存储入栈的数据
			Stack<Integer> stack = new Stack<>();
			// 记录下一个要处理的入栈元素的位置
			int nextPush = 0;
			// 记录下一个要处理的出栈元素的位置
			int nextPop = 0;
			// 根据popA数组中的元素来处理问题的
			// 1.如果当前辅助栈为空，或者辅助栈的栈顶元素不等于popA[nextPop]，则将pushA数组中元素依次入栈，直到栈顶元素等于popA[nextPop]
			// 2.在上述步骤中，如果此时nextPush大于等于pushA.length，说明其实popA[nextPop]已经在辅助栈中，但不在栈顶，所以说要先弹出popA[nextPop]元素，必须先弹出辅助栈的栈顶元素，很显然popA不是pushA的出栈顺序
			while (nextPop < popA.length) {
				while (stack.empty() || stack.peek() != popA[nextPop]) {
					// 如果入栈元素已经全部入栈，退出内层循环
					if (nextPush >= pushA.length) {
						break;
					}
					stack.push(pushA[nextPush]);
					nextPush++;
				}

				// 执行完上述while循环有两种情况：1.在栈顶找到与popA[nextPop]相等的元素；2.已经将pushA数组中的元素全部压入栈中
				if (stack.peek() != popA[nextPop]) {
					// 很显然，此时已经将pushA数组中元素全部压入栈中，但是栈顶元素不等于popA[nextPop]，说明popA根本不可能是出栈顺序
					break;
				}

				stack.pop();
				// 处理下一个出栈元素
				nextPop++;
			}
			// 辅助栈中元素为空，说明按照上述步骤，popA是出栈顺序的一种
			if (stack.empty()) {
				isPossible = true;
			}
		}
		return isPossible;
	}
}
