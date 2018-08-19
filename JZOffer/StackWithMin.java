import java.util.Stack;

/**
 * ������21������min������ջ
 * ��Ŀ����������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����Сֵ��min�������ڸ�ջ�У�����min��push����pop��ʱ�临�Ӷ�Ϊ����O(1)
 * 
 * �������ܹ�ʱ�̵õ�ջ����Сֵ��
 * ��ÿ�ε���СԪ�ض���������ѹ�뵽���⸨��ջ�У�����temp��������¼֮ǰ����Сֵ����pushԪ�ص�ջ�У��Ƚ�temp�͸�Ԫ�أ����nodeԪ�ش���temp����ֱ�ӽ�nodeѹ��ջ�У�
 * ���node<temp����˵����ʱѹ��ջ�е�Ԫ�ر�֮ǰ����СԪ�ػ�ҪС����temp = node������nodeѹ��ջ��ͬʱ��Ҳѹ�뵽����ջ�С�
 * ���ÿ�ζ�����СԪ��ѹ�븨��ջ�У���ô���ܱ�֤����ջ��ջ��һֱ����ջ����СԪ�أ�����СԪ�ش�����ջ�ڱ�����֮��ͬʱ��������ջ��ջ��Ԫ�أ���ʱ����ջ��ջ��Ԫ�ؾ�����һ����СԪ�ء�
 * @author geyan
 *
 */
public class StackWithMin {
	private Stack<Integer> minStack = new Stack<>();
	private Stack<Integer> dataStack = new Stack<>();

	// minStack��ջ��Ԫ�أ���֮ǰ��dataStackջ�е���СԪ��
	Integer temp = null;

	public void push(int node) {
		if (temp != null) {
			// �����ѹ��ջ�е�Ԫ�أ�С�ڵ���֮ǰջ�е���СԪ�أ�������Ҫ����ѹ��ջ�е�Ԫ��ѹ��ջ�У�����Ҫ����ѹ�뵽����ջ��
			if (node <= temp) {
				temp = node;
				minStack.push(node);
			} 
			dataStack.push(node);
		} else {
			// ջ��û��Ԫ��
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
