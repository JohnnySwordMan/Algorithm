package LeetCode;

import java.util.Scanner;

/**
 * ��Ŀ���ַ������ҳ�����������ִ�
 * 
 * ������
 * ������������count��max��count��¼���������ָ�����max��¼�������������ָ�����
 * �������end����¼���������������ִ������һ����
 * �����ַ�������������֣�count++��ͬʱ����maxֵ����¼���������������ִ������һ��
 * @author geyan
 *
 */
public class Solution_4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			getMaxStr(str);
		}
	}

	public static void getMaxStr(String str) {
		int max = 0;
		int count = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				// �������ֳ��ֵĸ���
				count++;
				if (max < count) {
					// �������ֵ
					max = count;
					// endָ���������������ֵ����һλ
					end = i;
				}
			} else {
				// ������ַ��������¼���
				count = 0;
			}
		}
		System.out.println(str.substring(end - max + 1, end + 1));
	}
}
