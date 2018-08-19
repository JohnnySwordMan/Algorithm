/**
 * ��Ŀ���������죺����n����������ֲ�ͬ��ɫ��С������������һ����ͨ��������������������ʹ�ô������ң�������һЩ����һЩ����һЩ����
 * 
 * ��һ��ֻ��0��1��2����Ԫ�ع��ɵ��������飬��ʹ�ý�����ԭ�����������ʹ�ü�����������
 * ����һ��ֻ��0��1��2����������a�����Ĵ�С���뷵�����������顣��֤�����СС�ڵ���500.
 * 
 * @author geyan
 *
 */
public class TreeColor {

	public static void main(String[] args) {
		int[] a = { 0, 1, 1, 0, 2, 2 };
		int[] arr = sortThreeColor(a, 6);
		for (int i = 0; i < a.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * ������������partition���ι��̣���ÿһ����������У���������з�Ԫ�أ�������ֳ������֣��з�Ԫ�ص����<=�з�Ԫ��<=�з�Ԫ�ص��ұ�
	 * ���Խ�����ţ�ʹ��begin��end��current����ָ�룬beginָ��0�������һ��Ԫ�أ�endָ��2�����һ��Ԫ�أ�
	 * currentָ��ǰ����Ԫ�� 1. currentָ��Ԫ��0ʱ����beginָ���Ԫ�ؽ�����Ȼ��current++��begin++�� 2.
	 * currentָ��Ԫ��1ʱ�������κν�����Ȼ��current++ 3.
	 * currentָ��Ԫ��2ʱ����endָ���Ԫ�ؽ�����Ȼ��currentָ�򲻱䣬end--;
	 */
	public static int[] sortThreeColor(int[] a, int n) {
		int begin = 0, current = 0, end = n - 1;
		int temp = 0;
		while (current <= end) {
			if (a[current] == 0) {
				temp = a[current];
				a[current] = a[begin];
				a[begin] = temp;
				// swap(a,current,begin); ���ô���
				current++;
				begin++;
			} else if (a[current] == 1) {
				current++;
			} else {
				temp = a[current];
				a[current] = a[end];
				a[end] = temp;
				// swap(a,current,end);
				end--;
			}
		}
		return a;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// ֵ���ݣ����������ı�ԭ������Ԫ��λ��
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	/**
	 * ������������ȱ������飬�ֱ��¼��0��1��2�ֱ������Ȼ������������
	 */
	public static int[] sortThreeColor_1(int[] a, int n) {
		int red = 0, white = 0, blue = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == 0) {
				red++;
			} else if (a[i] == 1) {
				white++;
			} else {
				blue++;
			}
		}

		// ��������
		for (int i = 0; i < n; i++) {
			if (red > 0) {
				a[i] = 0;
				red--;
			} else if (white > 0) {
				a[i] = 1;
				white--;
			} else {
				a[i] = 2;
				blue--;
			}
		}
		return a;
	}

}
