/**
 * ϣ��������һ�ָĽ���ֱ�Ӳ�������(��a[i],���뵽a[i-h],a[i-2*h]...��)�������������ڵ�Ԫ���Զ�����ľֲ���������
 * �������ò������򽫾ֲ��������������ʹ������������Ϊh��Ԫ������
 * Ŀǰ���޷�׼ȷ�����ϣ�������ʱ�临�Ӷȣ��������������£����㷨�ıȽϴ�����N^(3/2)������ 
 * ƽ��ʱ�临�Ӷ�ΪO(NlogN)
 * �ռ临�Ӷ�ΪO(1) 
 * ���ȶ�
 * 
 * @author geyan
 *
 */
public class ShellSort {
	/**
	 * ϣ�����򣬸Ľ�ֱ�Ӳ�������ʹ������������Ϊh��Ԫ������
	 * 
	 * @param a
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (a[j].compareTo(a[j - h]) < 0) {
						Comparable temp = a[j];
						a[j] = a[j - h];
						a[j - h] = temp;
					}
				}
			}
			h = h / 3;
		}
	}

}
