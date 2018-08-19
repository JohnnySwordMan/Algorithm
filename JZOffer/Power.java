/**
 * ������11����ֵ�������η� ��Ŀ����������һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * �������ڣ�����ȫ��
 * 
 * @author geyan
 *
 */
public class Power {

	/**
	 * ������ȫ 1.ָ�����ڣ����ڣ�С��0 2.��ָ��С��0������£���base�Ƿ�Ϊ0 ʱ�临�Ӷ�ΪO(N)
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
			// ָ��С��0
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
	 * ʱ�临�Ӷ�ΪO(logN)
	 * �������㷨
	 * ���õݹ�
	 * ���ù�ʽ��
	 * a^n 
	 * = {  a^(n/2) * a^(n/2) nΪż��
	 * 		a^((n-1)/2) * a^((n-1)/2) * a nΪ����
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
		// ��ָֹ��ΪС��1��С��
		if (exponent == 0)
			return 1.0;
		if (exponent == 1)
			return base;
		// ���ƣ��൱�ڳ���2
		double result = powerWithUnsignedExponent(base, exponent >> 1);
		result = result * result;
		if ((exponent & 1) == 1) {
			// ˵��������������λΪ1���ض�Ϊ����
			result = result * base;
		}
		return result;
	}
}
