/**
 * ð��������һ�ֽ������������˼���ǣ����������Ƚ�(Ҫ���С��������)������С��ǰ�ߣ��򽻻��� ƽ��ʱ�临�ӶȺ��ʱ�临�ӶȾ�ΪO(n^2)
 * �ؼ����Ӷ�ΪO(1) �ȶ�
 * 
 * @author geyan
 *
 */
public class BubbleSort {

	/**
	 * ����������������{2,1,3,4,5,6,7,8,9}�����Կ�������1��2��Ҫ����֮�⣬������Ԫ���ǲ���Ҫ�����ġ�
	 * ����һ�α�������Ԫ��ʱ������1��2����ʱ����Ӧ��������ģ�û�б�Ҫ��ȥ�����ڶ����� �Ľ����룬���ӱ��flag
	 * 
	 * @param a
	 */
	private static void sort_2(int[] a) {
		// flagΪtrue����ʾ�����ݽ���
		boolean flag = true;
		for (int i = 0; i < a.length && flag; i++) {
			flag = false;
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					// ���ݽ���
					flag = true;
				}
			}
		}
	}

	// �������д��
	private static void sort_1(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = a.length - 1; j > i; j--) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 1, 5, 8, 3, 7, 4, 6, 2 };
		System.out.print("����ǰ��");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		// sort_1(a);
		sort_2(a);
		System.out.print("�����");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
