import java.util.ArrayList;
import java.util.Stack;

/**
 * ��Ŀ��˫ջ���� ���дһ�����򣬰������ջ��������(�����Ԫ��λ��ջ��)��Ҫ�����ֻ��ʹ��һ�������ջ�����ʱ���ݣ������ý�Ԫ�ظ��Ƶ�������ݽṹ�С�
 * ����һ��int[] numbers�����е�һ��Ԫ��Ϊջ�����뷵��������ջ����ע������һ��ջ����ζ�������������ֻ�ܷ��ʵ���һ��Ԫ�ء�
 * ����������[1,2,3,4,5] ���أ�[5,4,3,2,1]
 * 
 * ������ �����Stackջ�����ݽ��дӵ�С���򣬴���һ���µ�helpջ�����Ƚ�Stackջ��Ԫ�ص�����Ϊcurrent��
 * ���currentС�ڵ���help��ǰջ��Ԫ�أ� ��currentԪ��push��helpջ�У�
 * ���currentԪ�ش���helpջ����Ԫ�أ���helpջ��Ԫ�ص�����ѹ�뵽Stackջ�У�ֱ��currentԪ��С�ڵ���helpջ��Ԫ�أ�
 * ��StackջΪ��ʱ����ʱ��helpջ��Ԫ��ȫ��������ѹ�뵽Stackջ�С�
 * ע�⣬�����ǴӴ�С�������������Ǵ�С����������ôhelpջ�б����ǴӴ�С�������Դ�ʱ��cur����stack.pop()��helpStack.peek()���ж�Ӧ�ú�ԭ�����෴��
 * 
 * @author geyan
 *
 */
public class TwoStacks {

	// ʹ��������ģ��helpջ��help[0]��ʾջ�ף�help[n-1]��ʾջ��
	public static ArrayList<Integer> twoStackSort_1(int[] numbers) {
		int n = numbers.length;
		int[] help = new int[n];
		// i����stackջ�У���numbers��j����helpջ�У���help
		int i = 0, j = n;
		int cur;
		// ������Ŀ��˼��numbers[0]Ϊջ��Ԫ�أ�i<n����ʾstackջ��Ϊ��
		while (i < n) {
			cur = numbers[i++];
			if (j == n) {
				// ��ʾhelp����Ϊ�գ���helpջΪ��
				help[--j] = cur;
			} else if (cur <= help[j]) {
				// ���Stackջ�е�����Ԫ��С�ڵ���helpջ��Ԫ�أ��򽫵�����Ԫ��push��helpջ��
				help[--j] = cur;
			} else if (cur > help[j]) {
				// ���Stackջ�е�����Ԫ�ش���helpջ����Ԫ�أ���helpջ��С��cur��Ԫ�����ε���push��Stackջ�У���Stack������Ԫ��push��helpջ��
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
		// ������Ŀ��˼��
		// �Ƚ�numbers����ѹ��Stackջ��
		Stack<Integer> stack = new Stack<>();
		Stack<Integer> helpStack = new Stack<>();
		for (int i = numbers.length - 1; i >= 0; i--) {
			stack.push(numbers[i]);
		}
		// ��ʱ��Stackջ��Ԫ������
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
