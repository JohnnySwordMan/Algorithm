/**
 * 题目：字符串移位 对于一个字符串，请设计一个算法，将字符串的长度为len的前缀平移到字符串的最后。
 * 给定一个字符串A和它的长度，同时给定len，请返回平移后的字符串。 测试样例： "ABCDE",5,3 返回： "DEABC"
 * 
 * 分析：
 * 给定一个字符串str，和整数i，i代表str中的位置，将str[0...i]移动到右侧，str[i+1...N-1]移动到左侧。要求时间复杂度为O(N),额外空间复杂度为O(1) 
 * 1.将str[0...i]部分字符逆序 "ABCDE"--->"CBADE" 
 * 2.将str[i+1...N-1]部分字符逆序 "CBADE" --->"CBAED"
 * 3.将str整体的字符逆序 "CBAED" --->"DEABC"
 * 
 * @author geyan
 *
 */
public class Translation {
	public String stringTranslation(String A, int n, int len) {
		// String str1 = null;
		// String str2 = null;
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < len; i++) {
			str1 += A.charAt(i);
		}
		for (int i = len; i < n; i++) {
			str2 += A.charAt(i);
		}
		return reverse(reverse(str1) + reverse(str2));
	}

	/**
	 * 实现字符串逆序
	 * 
	 * @param str
	 * @return
	 */
	public static String reverse(String str) {
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length / 2; i++) {
			char temp = c[i];
			c[i] = c[c.length - 1 - i];
			c[c.length - 1 - i] = temp;
		}
		return new String(c);
	}
}
