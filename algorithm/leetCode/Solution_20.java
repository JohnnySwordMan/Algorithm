package LeetCode;

import java.util.*;

/**
 * ���������⣺�����������ϣ�Ҫ��{A} + {B}�� ע��ͬһ�������в�����������ͬ��Ԫ�ء� 
 * 
 * �������ϲ����ϣ���˳��������������ظ�
 * @author geyan
 *
 */
public class Solution_20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int m = input.nextInt();
			TreeSet<Integer> set = new TreeSet<>();
			for (int i = 0; i < n + m; i++) {
				set.add(input.nextInt());
			}
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				System.out.print(it.next());
				if (it.hasNext())
					System.out.print(" ");
			}
		}
	}
}