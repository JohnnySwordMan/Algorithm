/**
 * 题目：栈的反转 实现一个栈的逆序，但是只能用递归函数和这个栈本身的pop操作来实现，而不能自己申请另外的数据结构。
 * 给定一个整数数组A即为给定的栈，同时给定它的大小n，请返回逆序后的栈。 测试样例： [4,3,2,1],4 返回： [1,2,3,4]
 * 
 * 分析： 对于栈的反转，可以使用两个栈，和模拟队列是一样的。但是本题只能用递归函数，不能申请另外的数据结构，递归函数本质上就是栈的实现
 * 本题要求实现栈的效果，递归函数可以实现
 * 
 * @author geyan
 *
 */
public class StackReverse {

	public int[] reverseStack(int[] A, int n) {
		if (A == null || n < 2) {
			return A;
		}
		int result = A[0];
		// 调整数组A
		for (int i = 1; i < n; i++) {
			A[i - 1] = A[i];
		}
		reverseStack(A, --n); // 先执行--操作
		A[n] = result;
		return A;
	}
}
