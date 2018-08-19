import java.util.Scanner;
import java.util.Stack;

/**
 * 题目：进制转换 题目描述：给定一个十进制M，以及需要转换的进制数N。将十进制M转化为N进制数
 * 
 * 分析： 
 * 1.注意m可能为负数 
 * 2.可以先定义一个char数组，简单明了
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

	// 最多16进制，需要考虑m是否为负数
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

	// 这个只能过50%，而且很麻烦
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
