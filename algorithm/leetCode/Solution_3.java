package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目：网易：彩色的砖块
 * 题目描述：小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串s,s中每个字符代表小易的某个砖块的颜色。
 * 小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,那么这行砖块就很漂亮的。
 * 请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,那么认为这两种方式是一样的。)
 * 例如: s = "ABAB",那么小易有六种排列的结果:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA"
 * 其中只有"AABB"和"BBAA"满足最多只有一对不同颜色的相邻砖块。
 * 
 * 输出一个整数，表示小易可以有多少种方式
 * 
 * 分析：题目描述越是复杂，就越简单，不要被字多吓到了，
 * 其实只要判断字符串中有多少种不同的字符即可
 * 只有一种，那么就是一种方式，即原来字符没有不同颜色的相邻砖块，即也满足最多只有一对不同颜色的相邻砖块。
 * 有两种不同字符，那就有两种方式。
 * 超过两种，则不会满足。
 * @author geyan
 *
 */
public class Solution_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String str = input.nextLine();
			ArrayList<Character> al = new ArrayList<>();
			char[] c = str.toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (!al.contains(c[i])) {
					al.add(c[i]);
				}
			}
			if (al.size() > 2) {
				System.out.println(0);
			} else {
				System.out.println(al.size());
			}
		}
	}
}
