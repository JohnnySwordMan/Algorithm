import java.util.*;

/**
 * 题目：词语变形
 * 对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，请设计一个高效算法，检查两给定串是否互为变形词。
 * 给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
 * 
 * @author geyan
 *
 */
public class Transform {

	// 使用数组可以模拟HashMap
	public boolean chkTransform(String a, int lena, String b, int lenb) {
		// 模拟map
		int[] map = new int[256];
		char[] charA = a.toCharArray();
		char[] charB = b.toCharArray();
		for (int i = 0; i < lena; i++) {
			map[charA[i]]++;
		}
		for (int i = 0; i < lenb; i++) {
			map[charB[i]]--;
		}
		for (int i = 0; i < 256; i++) {
			if (map[i] != 0)
				return false;
		}
		return true;

	}

	// 使用HashMap，但是问题在于怎么判断两个map内容一样
	public boolean chkTransform_1(String A, int lena, String B, int lenb) {
		Map<Character, Integer> mapA = new HashMap<>();
		Map<Character, Integer> mapB = new HashMap<>();
		for (int i = 0; i < lena; i++) {
			if (!mapA.containsKey(A.charAt(i))) {
				mapA.put(A.charAt(i), 1);
			} else {
				mapA.put(A.charAt(i), mapA.get(A.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < lenb; i++) {
			if (!mapB.containsKey(B.charAt(i))) {
				mapB.put(B.charAt(i), 1);
			} else {
				mapB.put(B.charAt(i), mapB.get(B.charAt(i)) + 1);
			}
		}

		// 怎么判断两个map中的内容是否一样呢
		// 我还没想到怎么较好的判断两个map中k-v值完全一样
		return true;
	}

}
