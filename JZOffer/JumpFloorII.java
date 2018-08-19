/**
 * 面试题9引申：变态跳台阶 题目描述：一只青蛙一次可以跳1级台阶，也可以跳2级台阶...它也可以跳n级。求该青蛙跳上n级台阶的方法数。 
 * f(1) = 1
 * f(2) = 2 
 * f(3) = f(3-1)+f(3-2)+f(3-3)。跳上3级台阶：如果先跳1级，则有f(3-1)种方法，如果先跳2级，则有f(3-2)种方法，如果先跳3级，则有f(3-3)种方法 
 * f(4) = f(4-1)+f(4-2)+f(4-3)+f(4-4) . . . 
 * f(n) = f(n-1)+f(n-2)+f(n-3)+...f(n-n) 可以推导出f(n) = 2*f(n-1)，即f(n) = 2^(n-1)
 * 
 * @author geyan
 *
 */
public class JumpFloorII {

	public int jumpFloorII(int n) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		int f1 = 1;
		int temp = 0;
		for (int i = 2; i <= n; i++) {
			temp = 2 * f1;
			f1 = temp;
		}
		return temp;
	}
}
