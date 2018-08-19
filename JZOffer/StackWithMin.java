import java.util.Stack;

/**
 * 面试题21：包含min函数的栈
 * 题目描述：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小值的min函数。在该栈中，调用min、push、及pop的时间复杂度为都是O(1)
 * 
 * 分析：能够时刻得到栈中最小值的
 * 把每次的最小元素都保存起来压入到另外辅助栈中，定义temp变量，记录之前的最小值，当push元素到栈中，比较temp和该元素，如果node元素大于temp，则直接将node压入栈中，
 * 如果node<temp，则说明此时压入栈中的元素比之前的最小元素还要小，即temp = node，并将node压入栈的同时，也压入到辅助栈中。
 * 如果每次都把最小元素压入辅助栈中，那么就能保证辅助栈的栈顶一直都是栈的最小元素，当最小元素从数据栈内被弹出之后，同时弹出辅助栈的栈顶元素，此时辅助栈的栈顶元素就是下一个最小元素。
 * @author geyan
 *
 */
public class StackWithMin {
	private Stack<Integer> minStack = new Stack<>();
	private Stack<Integer> dataStack = new Stack<>();

	// minStack的栈顶元素，即之前的dataStack栈中的最小元素
	Integer temp = null;

	public void push(int node) {
		if (temp != null) {
			// 如果待压入栈中的元素，小于等于之前栈中的最小元素，不仅需要将待压入栈中的元素压入栈中，还需要将其压入到辅助栈中
			if (node <= temp) {
				temp = node;
				minStack.push(node);
			} 
			dataStack.push(node);
		} else {
			// 栈中没有元素
			temp = node;
			dataStack.push(node);
			minStack.push(node);
		}
	}

	public void pop() {
		int num = dataStack.pop();
		int num2 = minStack.peek();
		if(num == num2)
			minStack.pop();
	}

	public int top() {
		return dataStack.peek();
	}

	public int min() {
		return minStack.peek();
	}
}
