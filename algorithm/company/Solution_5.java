import java.util.Scanner;
import java.util.Stack;

/**
 * ��Ŀ������ת�� ��Ŀ����������һ��ʮ����M���Լ���Ҫת���Ľ�����N����ʮ����Mת��ΪN������
 * 
 * ������ 
 * 1.ע��m����Ϊ���� 
 * 2.�����ȶ���һ��char���飬������
 * 
 * @author geyan
 *
 */
public class Solution_5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			test_2(m, n);
		}
	}

	// ���16���ƣ���Ҫ����m�Ƿ�Ϊ����
	private static void test_2(int m, int n) {
		char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		if (m < 0) {
			flag = false;
			m = Math.abs(m);
		}
		while (m != 0) {
			stack.push(digit[m % n]);
			m /= n;
		}
		if (!flag) {
			System.out.print("-");
		}
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	// ���ֻ�ܹ�50%�����Һ��鷳
	private static int test_1(int m, int n) {
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while (m != 0) {
			int temp = m % n;
			stack.push(temp);
			m /= n;
		}
		if (n <= 9) {
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
		} else {
			while (!stack.isEmpty()) {
				int temp = stack.pop();
				if (temp <= 9) {
					sb.append(temp);
				} else {
					char c = (char) (temp - 10 + 'A');
					sb.append(c);
				}
			}
		}
		return Integer.parseInt(sb.toString());
	}
}
