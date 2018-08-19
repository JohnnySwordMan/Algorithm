package LeetCode;

import java.util.*;

/**
 * ���������⣺������
 * ��Ŀ������С��ͬѧѧϰ�˲�ͬ�Ľ���֮��������һЩ������������Ϸ��С��ͬѧ֪�������ճ�������������õ���ʮ�����������ڼ�����У���������Ҳ�ܳ��á�
 * ���ڶ���һ������x��С��ͬѧ���������������f(x)��g(x)�� f(x)��ʾ��x�������ʮ����д���������λ�ϵ�����֮�͡�
 * ��f(123)=1+2+3=6�� g(x)��ʾ��x������ö�����д���������λ�ϵ�����֮�͡���123�Ķ����Ʊ�ʾΪ1111011����ô��g(123)=1+1+1+1+0+1+1=6�� 
 * С��ͬѧ���ֶ���һЩ������x����f(x)=g(x)��������������Ϊ����������������֪����С�ڵ���n���������ж��ٸ���
 * @author geyan
 *
 */
public class Solution_19 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int count = 0;
			for (int i = 1; i <= n; i++) {
				if (function(i)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	public static boolean function(int n) {
		int sum1 = 0;
		int temp = n;
		while (n != 0) {
			sum1 += n % 10;
			n /= 10;
		}

		int sum2 = 0;
		while (temp != 0) {
			sum2 += temp % 2;
			temp /= 2;
		}
		return sum1 == sum2 ? true : false;
	}
}