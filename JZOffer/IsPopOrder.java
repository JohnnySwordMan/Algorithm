import java.util.Stack;

/**
 * ������22��ջ��ѹ�롢��������
 * ��Ŀ���������������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * 
 * ����������һ������ջ��������ĵ�һ�������е���������ѹ��ø���ջ�������յڶ������е�˳�����δӸ�ջ�е������֡�
 * �ܽ�������ջ����ջ�Ĺ��̣����ǿ����ҵ��ж�һ�������ǲ���ջ�ĵ������еĹ��ɣ�
 * 1.�����һ�����������ָոպ���ջ�����֣���ôֱ�ӵ�����
 * 2.�����һ�����������ֲ���ջ�������ǰ�ѹջ�����л�û����ջ������ѹ�븨��ջ��ֱ������һ����Ҫ����������ѹ��ջ��Ϊֹ��
 * 3.������е����ֶ�ѹ��ջ����Ȼû���ҵ���һ�����������֣���ô�����в�������һ���������С�
 * @author geyan
 *
 */
public class IsPopOrder {

	public boolean isPopOrder(int[] pushA, int[] popA) {
		// ���ڼ�¼�жϳ�ջ˳���ǲ�����ջ
		boolean isPossible = false;
		// ����ջ�ͳ�ջ���鶼��Ϊ�գ��������ݣ����ݸ���Ҳһ��
		if (pushA != null && popA != null && pushA.length == popA.length) {
			// ���帨��ջ�����ڴ洢��ջ������
			Stack<Integer> stack = new Stack<>();
			// ��¼��һ��Ҫ�������ջԪ�ص�λ��
			int nextPush = 0;
			// ��¼��һ��Ҫ����ĳ�ջԪ�ص�λ��
			int nextPop = 0;
			// ����popA�����е�Ԫ�������������
			// 1.�����ǰ����ջΪ�գ����߸���ջ��ջ��Ԫ�ز�����popA[nextPop]����pushA������Ԫ��������ջ��ֱ��ջ��Ԫ�ص���popA[nextPop]
			// 2.�����������У������ʱnextPush���ڵ���pushA.length��˵����ʵpopA[nextPop]�Ѿ��ڸ���ջ�У�������ջ��������˵Ҫ�ȵ���popA[nextPop]Ԫ�أ������ȵ�������ջ��ջ��Ԫ�أ�����ȻpopA����pushA�ĳ�ջ˳��
			while (nextPop < popA.length) {
				while (stack.empty() || stack.peek() != popA[nextPop]) {
					// �����ջԪ���Ѿ�ȫ����ջ���˳��ڲ�ѭ��
					if (nextPush >= pushA.length) {
						break;
					}
					stack.push(pushA[nextPush]);
					nextPush++;
				}

				// ִ��������whileѭ�������������1.��ջ���ҵ���popA[nextPop]��ȵ�Ԫ�أ�2.�Ѿ���pushA�����е�Ԫ��ȫ��ѹ��ջ��
				if (stack.peek() != popA[nextPop]) {
					// ����Ȼ����ʱ�Ѿ���pushA������Ԫ��ȫ��ѹ��ջ�У�����ջ��Ԫ�ز�����popA[nextPop]��˵��popA�����������ǳ�ջ˳��
					break;
				}

				stack.pop();
				// ������һ����ջԪ��
				nextPop++;
			}
			// ����ջ��Ԫ��Ϊ�գ�˵�������������裬popA�ǳ�ջ˳���һ��
			if (stack.empty()) {
				isPossible = true;
			}
		}
		return isPossible;
	}
}
