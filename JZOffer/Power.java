/**
 * 面试题11：数值的整数次方 题目描述：给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 考点在于：考虑全面
 * 
 * @author geyan
 *
 */
public class Power {

	/**
	 * 考虑周全 1.指数大于，等于，小于0 2.在指数小于0的情况下，分base是否为0 时间复杂度为O(N)
	 */
	public double power_1(double base, int exponent) {
		// Math.pow(base, exponent);
		double result = 1.0;
		if (exponent > 0) {
			for (int i = 0; i < exponent; i++) {
				result *= base;
			}
		} else if (exponent == 0) {
			return result;
		} else {
			// 指数小于0
			if (base == 0) {
				return 0;
			} else {
				exponent = -exponent;
				for (int i = 0; i < exponent; i++) {
					result *= (1 / base);
				}
			}
		}
		return result;
	}

	/**
	 * 时间复杂度为O(logN)
	 * 快速幂算法
	 * 利用递归
	 * 利用公式：
	 * a^n 
	 * = {  a^(n/2) * a^(n/2) n为偶数
	 * 		a^((n-1)/2) * a^((n-1)/2) * a n为奇数
	 *   }
	 */
	public double power_2(double base, int exponent) {
		if (exponent == 0)
			return 1.0;
		else if (exponent < 0) {
			if (base != 0) {
				return powerWithUnsignedExponent(1 / base, -exponent);
			}
			return 0;
		} else {
			return powerWithUnsignedExponent(base, exponent);
		}
	}

	public double powerWithUnsignedExponent(double base, int exponent) {
		// 防止指数为小于1的小数
		if (exponent == 0)
			return 1.0;
		if (exponent == 1)
			return base;
		// 右移，相当于除以2
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result = result * result;
		if ((exponent & 1) == 1) {
			// 说明是奇数，最右位为1，必定为奇数
			result = result * base;
		}
		return result;
	}
}
