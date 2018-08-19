/**
 * 题目：正则表达式匹配
 * 题目描述：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次(包括0次)。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 
 * 分析： 
 * 当模式中的第二个字符不是'*'时， 
 * 1.如果字符串第一个字符与模式中的第一个字符相匹配，那么字符串和模式都后移一个字符
 * 2.如果字符串第一个字符和模式中的第一个字符不匹配，直接返回false
 * 
 * 当模式中的第二个字符是'*'时， 
 * 1.如果字符串第一个字符与模式第一个字符不匹配，则模式后移2个字符，继续匹配
 * 2.如果字符串第一个字符与模式第一个字符匹配，可以有3种匹配方式： 
 * 	1.模式后移2位，相当于x*被忽略
 * 	2.字符串后移一位，模式后移2位，相当于'*'看作1 
 * 	3.字符串后移1位，模式不变，继续匹配，相当于'*'看作大于1
 * 
 * 时刻检查数组是否越界
 * @author geyan
 *
 */
public class Match {

	public boolean match(char[] str, char[] pattern) {
		if (str == null || pattern == null) {
			return false;
		}
		return matchCore(str, 0, pattern, 0);
	}

	public boolean matchCore(char[] str, int i, char[] pattern, int j) {
		// 匹配串与模式串都遍历到最后，说明匹配成功
		if (i >= str.length && j >= pattern.length) {
			return true;
		}
		// 只有模式串达到串尾，则匹配失败。匹配串达到串尾不一定失败，因为有可能模式串后面存在'*'
		if (i != str.length && j >= pattern.length) {
			return false;
		}

		// -------------------
		// 模式串下一个字符为'*'
		if (j + 1 < pattern.length && pattern[j + 1] == '*') {
			// 匹配串已经结束
			if (i >= str.length) {
				return matchCore(str, i, pattern, j + 2);
			} else {
				// 匹配串没有结束
				if (str[i] == pattern[j] || pattern[j] == '.') {
					// 有3种匹配方式
					boolean result = matchCore(str, i, pattern, j + 2) || matchCore(str, i + 1, pattern, j + 2)
							|| matchCore(str, i + 1, pattern, j);
					return result;
				} else {
					// 匹配串第一个字符与模式串第一个字符不匹配
					return matchCore(str, i, pattern, j + 2);
				}
			}
		}

		// --------------------
		// 模式串下一个字符不是'*'
		// 需要判断匹配串是否结束
		if (i >= str.length) {
			return false;
		} else {
			if (str[i] == pattern[j] || pattern[j] == '.') {
				return matchCore(str, i + 1, pattern, j + 1);
			}
		}
		return false;
	}
}
