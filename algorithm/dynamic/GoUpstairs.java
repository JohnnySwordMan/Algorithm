/**
 * 台阶问题 有n级台阶，一个人每次上一级或者两级，问有多少种走完n级台阶的方法。为了防止溢出，请将结果Mod 1000000007
 * 给定一个正整数n，请返回一个数，代表上楼的方式数。保证n小于等于100000
 * 参考JZOffer/JumpFloor
 * @author geyan
 *
 */
public class GoUpstairs {

	/**
	 * f(i) = f(i-1)+f(i-2)，若想走上i级台阶，要么是从第i-1级台阶迈一步，要么是从第i-2级台阶迈两步。
	 * 所以说走上第i级台阶的方法数就是走上第i-1级台阶的方法数与走上第i-2级台阶的方法数之和。 f(1) = 1, f(2) = 2 
	 * public int f(n){ 
	 * 	if(n<1) return 0; 
	 * 	if(n == 1 || n == 2) return n; 
	 * 	return f(n-1) + f(n-2); 
	 * }
	 */
	public int countWays(int n) {
		int f1 = 1, f2 = 2;
		int count = 0;
		for (int i = 3; i <= n; i++) {
			count = (f1 + f2) % 1000000007;
			f1= f2;
			f2 = count;
		}
		return count;
	}
	
	public int JumpFloor(int target){
		if(target < 1)
			return 0;
		if(target == 1 || target == 2)
			return target;
		return JumpFloor(target-1) + JumpFloor(target-2);
	}
}
