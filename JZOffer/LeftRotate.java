/**
 * 面试题42引申：左旋转字符串 
 * 题目描述：给定字符序列s，请将其循环左移k位后的序列输出。
 * 
 * 相似题目：Learning/algorithm/string/Translation.java
 * @author geyan
 *
 */
public class LeftRotate {

	public String LeftRotateString(String str, int n) {
		if (str.length() < n)
			return "";
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < n; i++) {
			str1 += str.charAt(i);
		}
		for (int i = n; i < str.length(); i++) {
			str2 += str.charAt(i);
		}
		return reverse(reverse(str1) + reverse(str2));
	}

	/**
	 * 实现字符串逆序
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
