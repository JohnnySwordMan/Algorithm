/**
 * 题目：求所有字符串的最长公共前缀 
 * 题目描述：给定数组，如{"abcd","abcdef","abcde"}，求出所有字符串的最长公共前缀
 * 
 * @author geyan
 *
 */
public class LongestCommonPrefix {

	/**
	 * 既然是最长公共前缀，那么这个结果也包含在所有字符串中 将第一个字符串作为基准，依次与后面的比较，如和第二个字符串比较，得到这两个字符串的公共前缀，
	 * 然后将该前缀与第三个字符串比较
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		}
		// 将第一个字符串作为基准
		String prefix = strs[0];
		int j = 0;
		for (int i = 1; i < strs.length; i++) {
			while (j < prefix.length() && j < strs[i].length() && prefix.charAt(j) == strs[i].charAt(j)) {
				j++;
			}
			// 没有公共前缀
			if (j == 0) {
				return "";
			}
			// 更新公共前缀
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}
}
