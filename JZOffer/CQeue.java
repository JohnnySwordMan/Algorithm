import java.util.Stack;

/**
 * ������7��������ջʵ�ֶ��� ��Ŀ������������ջ��ʵ��һ�����У���ɶ��е�Push��Pop�����������е�Ԫ��Ϊint���͡� ע�⣺
 * 1.��StackPushջ�е�Ԫ��Ҫôȫ������StackPopջ�У�Ҫ��һ��������
 * 2.�ڵ���StackPushջ��Ԫ��ʱ��StackPopԪ�ر��붼Ϊ�ա�
 * @author geyan
 *
 */
public class CQeue {

	Stack<Integer> stackPush = new Stack<>();
	Stack<Integer> stackPop = new Stack<>();

	public void push(int node) {
		stackPush.push(node);
	}

	// �е��鷳
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
		// ��StackPopջΪ�յ�����£���ȥ��������
		if (stackPop.isEmpty()) {
			while (!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
}
