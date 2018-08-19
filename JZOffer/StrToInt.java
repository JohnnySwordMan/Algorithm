/**
 * 题目：把字符串转换成整数
 * 题目描述：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * @author geyan
 *
 */
public class StrToInt {

	public int strToInt(String str) {
		if (str == null || str.length() <= 0) {
			return 0;
		}
		int sum = 0;
		char[] c = str.toCharArray();
		// 判断给出的字符串第一个字符是否为'+','-'
		boolean flag = false;
		/*
		 * if (c[0] == '+') { flag = true; }
		 */
		// 判断是否为-，假如考虑判断是否为+，如果第一个为数字，那么flag就会为false，显然不对
		if (c[0] == '-') {
			flag = true;
		}
		for (int i = 0; i < c.length; i++) {
			if (i == 0 && c[0] == '+' || c[0] == '-') {
				continue;
			}
			if (c[i] < '0' || c[i] > '9') {
				return 0;
			}
			sum = sum * 10 + (c[i] - '0');
		}
		return flag ? -sum : sum;
	}
}
