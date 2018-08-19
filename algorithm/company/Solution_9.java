import java.util.Scanner;
import java.util.Stack;

/**
 * ��Ŀ����������� 
 * ��Ŀ����������һ��Ǹ�������ɵ�����h������һ����״ͼ�ĸ߶ȣ�����ÿ�����ӵĿ��Ϊ1.��������״ͼ���ҵ�����ɵ������ε���� ���磺
 * ���룺2 1 5 6 2 3 �����10
 * 
 * ���Ž⣺ʱ�临�Ӷ�ΪO(N),�ռ临�Ӷ�ΪO(N)
 * @author geyan
 *
 */
public class Solution_9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(solution_2(arr, n));
		}
	}

	/**
	 * ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(N)
	 * ���������ڸ߶�arr[i]�����֪���Ҳ��һ��С��arr[i]���±꣬����һ��С��arr[i]���±꣬
	 * ��ô���ڰ����ø߶ȵľ��ε�����������arr[i]*(right-left-1)
	 * ʵ�֣������ұ�������Ԫ�أ����ջΪ�ջ��ߵ�ǰ������Ԫ�ش���ջ��Ԫ�أ������ѹ��ջ��;�����ǰ����Ԫ��С��ջ��Ԫ�أ�����ջ��Ԫ��cur��
	 * �򵯳���ջ��Ԫ�ض�Ӧ�ĸ߶�Ϊarr[cur]����ǰ����Ԫ��Ϊarr[cur]���Ҳ��һ��С������Ԫ��;
	 * ����ǰջ��Ԫ�ض�Ӧ�ĸ߶�Ϊarr[cur]����һ��С������Ԫ�ء� ֻҪ����һ�μ���
	 */
	private static int solution_2(int[] arr, int n) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int i = 0;
		while (i <= n) {
			// i=n���������ô�ʱ�ĸ߶�Ϊ0����Ҫ��Ϊ�˽��������һ��Ԫ�أ������һ���߶Ⱥ�֮ǰ���ܹ�����һ����
			int height = (i == n) ? 0 : arr[i];
			if (stack.empty() || height > arr[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				// ���arr[i]<=arr[stack.peek()]����ʱarr[i]Ϊ��ǰջ��Ԫ�ص��ұߵ�һ��С������Ԫ���±�
				// ���ǻ�Ҫ�õ���ǰջ��Ԫ�����С�����ĵ�һ��
				int cur = stack.pop();
				// ��ջ�󣬴�ʱջ��Ԫ�ؾ�����ߵ�һ��С��cur��Ԫ���±�
				sum = Math.max(sum, arr[cur] * (stack.empty() ? i : i - stack.peek() - 1));
			}
		}
		return sum;
	}

	// ���������ʱ�临�Ӷ�ΪO(N^2)
	private static long solution_1(int[] arr, int n) {
		long res = 0;
		for (int i = 0; i < n; i++) {
			long minHeight = arr[i];
			long area = minHeight;
			for (int j = i; j < n; j++) {
				if (minHeight > arr[j]) {
					minHeight = arr[j];
				}
				area = minHeight * (j - i + 1);
				res = Math.max(res, area);
			}
		}
		return res;
	}
}
