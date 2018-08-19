import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列 题目描述：用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型。 注意：
 * 1.将StackPush栈中的元素要么全部倒入StackPop栈中，要不一个不倒。
 * 2.在倒入StackPush栈中元素时，StackPop元素必须都为空。
 * @author geyan
 *
 */
public class CQeue {

	Stack<Integer> stackPush = new Stack<>();
	Stack<Integer> stackPop = new Stack<>();

	public void push(int node) {
		stackPush.push(node);
	}

	// 有点麻烦
	public int pop_1() {
		while (!stackPush.isEmpty()) {
			stackPop.push(stackPush.pop());
		}
		int popNum = stackPop.pop();
		while (!stackPop.isEmpty()) {
			stackPush.push(stackPop.pop());
		}
		return popNum;
	}

	public int pop() {
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		// 在StackPop栈为空的情况下，才去倒入数据
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
}
