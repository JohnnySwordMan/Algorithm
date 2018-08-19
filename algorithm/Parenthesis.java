/**
 * 题目：合法括号序列判断 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 * 测试样例：
 * "(()())",6
 * 返回：
 * true
 * 
 * 测试样例：
 * "()a()()",7
 * 返回：
 * false
 * 
 * 测试样例：
 * "()(()()",7
 * 返回：
 * fasle
 * 
 * 分析：最优解 时间复杂度为O(N)，空间复杂度为O(1) 
 * 1.整型变量num，表示'('出现次数与')'出现次数的差值
 * 2.遍历过程中，如果遇到'('，则num++; 
 * 3.遍历过程中，如果遇到')'，则num--; 
 * 4.遍历过程中，如果num<0，则直接返回false
 * 5.如果没有出现情况4，则一直遍历下去 
 * 6.遍历结束，如果num=0，则返回true，否则返回false;
 * 
 * @author geyan
 *
 */
public class Parenthesis {

	public boolean chkParentthesis(String A, int n) {
		int num = 0;
		char[] str = A.toCharArray();
		for (int i = 0; i < n; i++) {
			if (str[i] != '(' && str[i] != ')')
				return false;
			if (str[i] == '(')
				num++;
			else
				num--;
			if (num < 0)
				return false;
		}
		if (num == 0)
			return true;
		else
			return false;
	}
}
