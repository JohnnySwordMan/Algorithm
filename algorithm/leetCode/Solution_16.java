package LeetCode;

import java.util.*;

/**
 * ��Ŀ������һ��Ӣ���ַ���,��дһ�δ����ҳ�����ַ��������ȳ������ε��Ǹ�Ӣ���ַ���
 * @author geyan
 *
 */
public class Solution_16 {
	public static void main(String[] args) {
		/*
		 * Scanner input = new Scanner(System.in); while (input.hasNext()) {
		 * String str = input.nextLine(); function(str); }
		 */
		String str = "Have you ever gone shopping and";
		function(str);
	}

	public static void function(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if ((c[i] >= 'a' && c[i] <= 'z') || (c[i] >= 'A' && c[i] <= 'Z')) {
				if (!map.containsKey(c[i])) {
					map.put(c[i], 1);
				} else {
					map.put(c[i], map.get(c[i]) + 1);
				}
				// �ڱ����Ĺ����У�ֻҪ�����ַ����ִ�������3����ֹͣ����������Ҫ�ȱ�����һ�Σ��ڶ��α�����ʱ����ȥ�ж�
				if (map.get(c[i]) == 3) {
					System.out.println(c[i]);
					break;
				}
			}
		}
	}
}