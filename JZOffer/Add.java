package JZOffer;

/**
 * ��Ŀ�����üӼ��˳����ӷ� 
 * ��Ŀ������дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ�üӼ��˳�
 * 
 * ������ 
 * ��5��7Ϊ������Ҫ��Ϊ��˵��5+7���������Ҳ��һ���� 
 * 5��Ӧ�Ķ�����Ϊ0101 7��Ӧ�Ķ�����Ϊ0111 
 * 1.�����ǽ�λ��0101 + 0111 = 0010 ��� 
 * 2.���½�λ��1010 �� 
 * 3.ǰ���������ӣ�0010 + 1010 = 1100,��12
 * 
 * ����> 
 * 1.����򣬵�ͬ�ڲ����ǽ�λ����� 
 * 2.��λ�룬�ҽ��������1λ����ͬ�ڽ�λ�Ľ�� 
 * 3.ǰ�������
 * 
 * @author geyan
 *
 */
public class Add {

	// �ݹ�
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
