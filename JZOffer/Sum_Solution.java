/**
 * 面试题：求1+2+3+...+n
 * 题目描述：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
 * 
 * 分析：利用短路求值，递归
 * @author geyan
 *
 */
public class Sum_Solution {

	public int sum_solution(int n) {
		int sum = n;
		boolean flag = (n > 0) && ((sum += sum_solution(n - 1)) > 0);
		return sum;
	}
}
