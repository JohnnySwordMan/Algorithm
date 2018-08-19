/**
 * 面试题42：翻转单词顺序
 * 题目描述：输入一个英文句子，翻转句子中单词的顺序，但单词内字的顺序不变。
 * 
 * 参考/algorithm/string/Reverse.java
 * @author geyan
 *
 */
public class ReverseSentence {
	public String reverseSentence(String str) {
		if (str == null || str.trim().equals(""))
			return str;
		String str1 = reverse(str);
		String[] sstr = str1.split(" ");
		String result = " ";
		for (int i = 0; i < sstr.length; i++) {
			result += reverse(sstr[i]);
			result += " ";
		}
		return result.trim();
	}

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
