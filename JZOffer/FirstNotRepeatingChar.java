import java.util.HashMap;

/**
 * 面试题35：第一个只出现一次的字符 
 * 题目描述：在字符串中找出第一个只出现一次的字符，返回它的位置
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

	// 定义长度为256的数组，来模拟HashMap
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
