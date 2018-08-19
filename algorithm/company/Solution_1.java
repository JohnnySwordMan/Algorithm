import java.util.Scanner;

/**
 * ��Ŀ���������� 
 * ��Ŀ������һ��������N��Ԫ�أ�����������������͡����磺[-1,2,1]������������������Ϊ[2,1]�����Ϊ3
 * 
 * ��ʵ���ǽ�ָOffer������31
 * @author geyan
 *
 */
public class Solution_1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = Integer.parseInt(input.nextLine());
			int[] array = new int[n];
			for (int i = 0; i < n; i++) {
				array[i] = input.nextInt();
			}
			System.out.println(max(array, n));
		}
	}

	private static int max(int[] array, int n) {
		int curSum = array[0], maxSum = curSum;
		for (int i = 1; i < n; i++) {
			// ����array[i]��β������£��Ƚ�curSum + array[i] �� array[i]�Ĵ�С
			curSum = Math.max(curSum + array[i], array[i]);
			maxSum = Math.max(curSum, maxSum);
		}
		return maxSum;
	}
}
