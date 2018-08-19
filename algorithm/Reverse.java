/**
 * 题目：句子的逆序 
 * 对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
 * 给定一个原字符串A和他的长度，请返回逆序后的字符串。 测试样例： "pig loves dog",13 返回： "dog loves pig"
 * 
 * 分析： 
 * 1.实现将字符串局部所有字符逆序的函数f 
 * 2.利用f将字符串所有字符逆序 "pig loves dog" ---> "god sevol gip"
 * 3.找到逆序后的字符串中每一个单词的区域，利用f将每一个单词的区域逆序 "god sevol gip" ---> "dog loves pig"
 * 
 * @author geyan
 *
 */
public class Reverse {
	public String reverseSentence(String A, int n) {
		if (n == 0)
			return null;
		String str = reverse(A);
		String[] sstr = str.split(" ");
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
