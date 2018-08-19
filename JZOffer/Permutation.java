import java.util.ArrayList;
import java.util.Collections;

/**
 * 面试题28：字符串的排列
 * 题目描述：输入一个字符串，按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 
 * 分析：先不考虑字典序打印，我们把一个字符串看成由两部分组成：第一部分为它的第一个字符，第二部分是后面的所有字符。
 * 1.首先求出所有可能出现在第一个位置的字符，即把第一个字符与后面所有的字符交换
 * 2.固定第一个字符，求后面所有字符的排列
 * 
 * 比如：abc
 * 当a在第一个位置，abc,固定a的位置，求bc排列，即bc,cb
 * bac,cba
 * 上述过程是一个递归
 * @author geyan
 *
 */
public class Permutation {
	public ArrayList<String> permutation(String str) {
		ArrayList<String> al = new ArrayList<>();
		if (str != null && str.length() > 0) {
			permutation(str.toCharArray(), 0, al);
		}
		Collections.sort(al);
		return al;
	}

	// 递归：1.递归结束时，需要做什么；2.递归的条件
	public void permutation(char[] c, int start, ArrayList<String> al) {
		if (start == c.length - 1) {
			// 已经到了最后一个元素，则直接将该字符数组添加到list中
			al.add(String.valueOf(c));
		} else {
			for (int i = start; i < c.length; i++) {
				// 重复字符跳过，当i==start时，也需要遍历其后面的所有字符，当i!=start时，先交换，让所有不等于c[start]的字符出现在第一个，然后在遍历后面所有字符
				if (i == start || c[i] != c[start]) {
					// 将i位置字符与start位置字符交换，固定住，在从start+1开始递归
					swap(c, i, start);
					permutation(c, start + 1, al);
					// 为了防止重复的情况，还需要将start处的元素重新换回来
					swap(c, i, start);
				}

			}
		}
	}

	public void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}
}
