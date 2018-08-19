/**
 * ̨������ ��n��̨�ף�һ����ÿ����һ���������������ж���������n��̨�׵ķ�����Ϊ�˷�ֹ������뽫���Mod 1000000007
 * ����һ��������n���뷵��һ������������¥�ķ�ʽ������֤nС�ڵ���100000
 * �ο�JZOffer/JumpFloor
 * @author geyan
 *
 */
public class GoUpstairs {

	/**
	 * f(i) = f(i-1)+f(i-2)����������i��̨�ף�Ҫô�Ǵӵ�i-1��̨����һ����Ҫô�Ǵӵ�i-2��̨����������
	 * ����˵���ϵ�i��̨�׵ķ������������ϵ�i-1��̨�׵ķ����������ϵ�i-2��̨�׵ķ�����֮�͡� f(1) = 1, f(2) = 2 
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
