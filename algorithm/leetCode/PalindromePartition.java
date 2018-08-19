package LeetCode;

import java.util.ArrayList;

/**
 * ��Ŀ����ֻ����ִ�
 * ��Ŀ�����������ַ������ҳ����п��ܵĻ����Ӵ����з� ���磺s = "aab" ��[["aa","b"],["a","a","b"]]
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
		// ������������ַ������ȵ���0,���������list�������������뵽�������
		if (str.length() == 0)
			result.add(new ArrayList<String>(list));

		// �ݹ����
		// �ַ�����ǰ�������ж�str.substring(0, i)�Ƿ��ǻ����ַ���
		// ����ǵĻ����������ú���dfs����str.substring(i)�ַ�������������
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
