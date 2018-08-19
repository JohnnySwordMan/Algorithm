/**
 * 题目：首个重复字符
 * 题目描述：给定一个字符串(不一定全为字母)A及它的长度n。
 * 请返回第一个重复出现的字符。保证字符串中有重复字符，字符串的长度小于等于500。
 * 
 * 分析：HashMap、HashSet、数组[256]
 * 而且不需要遍历char数组，将所有字符都计算出出现次数，然后再去遍历arr数组。
 * 只需要在遍历char数组的时候，判断对应的arr[c[i]]是否为0
 * @author geyan
 *
 */
public class FirstRepeat {

	// 数组实现，不需要全部遍历c之后，再去遍历数组arr
	public char findFirstRepeat(String A, int n) {
		int[] arr = new int[256];
		char[] c = A.toCharArray();
		for (int i = 0; i < n; i++) {
			if (arr[c[i] - '0'] == 0) {
				arr[c[i] - '0'] = 1;
			} else {
				return c[i];
			}
		}
		return '\n';
	}
}
