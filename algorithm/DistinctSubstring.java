import java.util.HashSet;
import java.util.Set;

/**
 * 题目：最长无重复字符子串 对于一个字符串，请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 * 
 * 测试样例： "aabcb",5 返回： 3 "pwwkew" "pwpkew"
 * 
 * @author geyan
 *
 */
public class DistinctSubstring {
	// 方法一：set集合
	public int longestSubstring_1(String A, int n) {
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, max = 0;
		while (j < A.length()) {
			if (!set.contains(A.charAt(j))) {
				// 如果set集合中没有该字符，则存入
				set.add(A.charAt(j++));
				max = Math.max(max, set.size());
			} else {
				// 如果当前字符已经存在于set集合中，则从字符串第一个字符开始删除，直至将已存入set集合的该字符删除
				// 将该字符删除后，再次进行if判断，将当前字符添加到集合中，每一次的添加，都要求出max和set.size()中较大值
				set.remove(A.charAt(i++));
			}
		}
		return max;
	}

	// 没看懂
	public int longestSubstring_2(String A, int n) {
		if (A == null || n == 0)
			return 0;
		char[] chas = A.toCharArray();
		int[] map = new int[256]; // 模拟map集合
		for (int i = 0; i < n; i++) {
			map[i] = -1;
		}
		int len = 0;
		int pre = -1;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chas[i]] = i;
		}
		return len;
	}
}
