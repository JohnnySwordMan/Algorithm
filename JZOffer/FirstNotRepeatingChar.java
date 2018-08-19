import java.util.HashMap;

/**
 * ������35����һ��ֻ����һ�ε��ַ� 
 * ��Ŀ���������ַ������ҳ���һ��ֻ����һ�ε��ַ�����������λ��
 * 
 * @author geyan
 *
 */
public class FirstNotRepeatingChar {

	// HashMap
	public int firstNotRepeatingChar_1(String str) {
		if (str == null || str.length() <= 0)
			return -1;
		HashMap<Character, Integer> map = new HashMap<>();
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (!map.containsKey(c[i])) {
				map.put(c[i], 1);
			} else {
				map.put(c[i], map.get(c[i]) + 1);
			}
		}
		for (int i = 0; i < c.length; i++) {
			if (map.get(c[i]) == 1) {
				return i;
			}
		}
		return 0;
	}

	// ���峤��Ϊ256�����飬��ģ��HashMap
	public int firstNotRepeatingChar_2(String str) {
		if (str == null || str.length() <= 0)
			return -1;
		int[] arr = new int[256];
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			arr[c[i]]++;
		}

		for (int i = 0; i < c.length; i++) {
			if (arr[c[i]] == 1)
				return i;
		}
		return 0;
	}
}
