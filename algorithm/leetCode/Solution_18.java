package LeetCode;

import java.util.*;


/**
 * ���������⣺���ƾ�ֵ
 * ��Ŀ������������һ��CSרҵ��ѧ����СB����ѧ�����ܺò�����ֵ���������ر����Ȥ��ϲ���ü���������������ѧ���⣬���ڣ���������һ����ֵ�任����Ϸ��
 * �����ּ�����о����ò�ͬ�Ľ��Ʊ�ʾһ��������ʮ������123���Ϊ16����ʱֻ������λ��7��11��B�����ð˽��Ʊ�ʾΪ��λ��1��7��3������ͬ���Ʊ��ʱ������λ���ĺ�Ҳ��ͬ��
 * ������������ʮ�����ƺͰ˽����и�λ���ĺͷֱ���18��11,�� СB����Ȥ���ǣ�һ����A�����2��A-1���Ʊ��ʱ������λ��֮�͵ľ�ֵ�Ƕ��٣�
 * ��ϣ�����ܰ������������⣿ ���еļ��������ʮ���ƽ��У����Ҳ��ʮ���Ʊ�ʾΪ����Լ��ķ�����ʽ��
 * @author geyan
 *
 */
public class Solution_18 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int num = input.nextInt();
			int sum = 0;
			for (int i = 2; i < num; i++) {
				// ת������
				sum += function(num, i);
			}
			int k = num - 2;
			getgcd(sum, k);
		}
	}

	public static int function(int num, int k) {
		int res = 0;
		while (num != 0) {
			res += num % k;
			num /= k;
		}
		return res;
	}

	// �򻯷�������k��ʼ�������Ǵ�2��ʼ��
	public static void getgcd(int num, int k) {
		for (int i = k; i > 1; i--) {
			if (num % i == 0 && k % i == 0) {
				num = num / i;
				k = k / i;
				break;
			}
		}
		System.out.println(num + "/" + k);
	}
}
