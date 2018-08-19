package LeetCode;

import java.util.ArrayList;

/**
 * 题目：拆分回文字串
 * 题目描述：给定字符串，找出所有可能的回文子串的切分 例如：s = "aab" 则[["aa","b"],["a","a","b"]]
 * 
 * @author geyan
 *
 */
public class PalindromePartition {
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		if (s == null || s.length() == 0)
			return result;
		dfs(result, list, s);
		return result;
	}

	private void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> list, String str) {
		// 当处理到传入的字符串长度等于0,则这个集合list满足条件，加入到结果集中
		if (str.length() == 0)
			result.add(new ArrayList<String>(list));

		// 递归调用
		// 字符串由前往后，先判断str.substring(0, i)是否是回文字符串
		// 如果是的话，继续调用函数dfs，把str.substring(i)字符串传入做处理
		for (int i = 1; i <= str.length(); ++i) {
			String subStr = str.substring(0, i);
			if (isPalindrome(subStr)) {
				list.add(subStr);
				String restSubStr = str.substring(i);
				dfs(result, list, restSubStr);
				list.remove(list.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
