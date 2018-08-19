/**
 * 
 * 面试题33：把数组排成最小的数
 * 题目描述：输入一个正整数数组，把数组里所有数字拼接起来拍成一个数，打印能拼接处的所有数字中最小的一个。例如输入数组{3,32,321}，则打印出这三个数字能拍成的最小数字为321332.
 * 该题目和Learning/algorithm/string/Prior.java 拼接最小字典序基本一样。不同的是，我们需要将整数转换成字符串，方便比较。
 * 
 * 正确的比较方法是给定两个字符串str1和str2，如果str1+str2<str2+str1，则str1放在前面，否则str2放在前面。而不是单纯的比较str1和str2的大小。
 * 
 * @author geyan
 *
 */
public class PrintMinNumber {

	public String printMinNumber(int[] numbers) {
		String result = "";
		for (int i = 1; i < numbers.length; i++) {
			for (int j = i; j > 0; j--) {
				String str1 = numbers[j - 1] + "";
				String str2 = numbers[j] + "";
				if ((str1 + str2).compareTo(str2 + str1) <= 0) {
					continue;
				} else {
					int temp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			result += numbers[i];
		}
		return result;
	}
}
