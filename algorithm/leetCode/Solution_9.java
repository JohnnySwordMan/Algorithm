package LeetCode;

import java.util.*;

/**
 * ��Ŀ��������һ�����飬��ֵΪ��1��10000���������������֡�����ĳ��żȻ������������������ж�ʧ��ĳ����Ԫ�أ�ͬʱ˳�򱻴��ң�
 * ������Ҫ�������ķ����ҳ���ʧ��������Ԫ�أ����ҽ�������Ԫ�ظ��ݴ�С��������ƴ��Ϊһ�������֣����������7��������
 * ������ʧ��Ԫ��Ϊ336��10��8435���õ���������Ϊ103368435�������ߵ�����Ϊ2��
 * 
 * 
 * ��������Ϊ��1~10000�������������飬��СΪ10001��ÿ����һ�����֣��ʹ���ڶ�Ӧ������λ�ã���������3��������a[3]��λ�ã�һ������9997�Ρ�
 * Ȼ���������a�����±�1��ʼ��������������±��Ӧ��ֵΪ0��˵��û�������ֵ����ʧ��ֵΪ��Ӧ�±�
 * @author geyan
 *
 */
public class Solution_9 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int[] arr = new int[10001];
			// ���i�������������������
			for (int i = 0; i < 9997; i++) {
				int num = input.nextInt();
				arr[num] = num; // ������٣���Ӧ������Ӧλ��
			}
			int[] res = new int[3];
			int index = 0;
			for (int i = 1; i < 10001; i++) {
				if (arr[i] == 0) {
					res[index++] = i; // ˵��
				}
			}
			Arrays.sort(res);
			String result = "";
			for (int i = 0; i < res.length - 1; i++) {
				result += res[i];
			}
			result += res[2];
			// long��
			long number = Long.parseLong(result);
			System.out.println(number % 7);
		}

	}
}