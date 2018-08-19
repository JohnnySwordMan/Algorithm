/**
 * 题目：拼接最小字典序 
 * 对于一个给定的字符串数组，请找到一种拼接顺序，使所有小字符串拼接成的大字符串是所有可能的拼接中字典序最小的。
 * 给定一个字符串数组strs，同时给定它的大小，请返回拼接成的串。 测试样例： ["abc","de"],2 返回： "abcde"
 * 
 * 分析： 
 * 举例： str={"abc","de"};可以拼接成"abcde"，也可以拼接成"deabc"，但是前者顺序更小，所以返回"abcde"
 * str={"b","ba"};可以拼成"bba"，也可以拼成"bab"，选后者 
 * --->所以比较str1与str2的大小，谁小放在前面。 这是错误的。
 * 正确的比较方法是str1+str2与str2+str1比较大小 如果str1+str2<str2+str1，则将str1放在前面
 * 
 * 方法一：插入排序
 * 
 * @author geyan
 *
 */
public class Prior {

	// 方法一：插入排序比较贴近该问题，时间复杂度为O(N^2)
	public String findSmallest_1(String[] strs, int n) {
		String result = "";  // 可以使用StringBuilder
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if ((strs[j - 1] + strs[j]).compareTo(strs[j] + strs[j - 1]) <= 0) {
					continue;
				} else {
					// 交换strs[j-1]与strs[j]位置
					String temp = strs[j - 1];
					strs[j - 1] = strs[j];
					strs[j] = temp;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			result += strs[i];
		}
		return result;
	}
}
