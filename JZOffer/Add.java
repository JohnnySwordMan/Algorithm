package JZOffer;

/**
 * 题目：不用加减乘除做加法 
 * 题目描述：写一个函数，求两个整数之和，要求在函数体内不得使用加减乘除
 * 
 * 分析： 
 * 以5与7为例，主要是为了说明5+7对其二进制也是一样的 
 * 5对应的二进制为0101 7对应的二进制为0111 
 * 1.不考虑进位，0101 + 0111 = 0010 异或 
 * 2.记下进位，1010 与 
 * 3.前两步结果相加，0010 + 1010 = 1100,即12
 * 
 * ——> 
 * 1.先异或，等同于不考虑进位，相加 
 * 2.按位与，且将结果左移1位，等同于进位的结果 
 * 3.前两步相加
 * 
 * @author geyan
 *
 */
public class Add {

	// 递归
	public int add_1(int num1, int num2) {
		if (num2 == 0)
			return num1;
		return add_1(num1 ^ num2, (num1 & num2) << 1);
	}

	public int add_2(int num1, int num2) {
		while (num2 != 0) {
			int sum = num1 ^ num2;
			int carry = (num1 & num2) << 1;
			num1 = sum;
			num2 = carry;
		}
		return num1;
	}
}
