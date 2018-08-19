import java.util.ArrayList;

/**
 * ������41����Ϊs����������
 * ��Ŀ����������һ����������������һ������s���������в�����������ʹ�����ǵĺ�������s������ж�����ֵĺ͵���s������������ĳ˻���С�ġ�
 * 
 * @author geyan
 *
 */
public class FindNumbersWithSum {
	/**
	 * ����һ��ʱ�临�Ӷ�ΪO(N^2) ����Ƕ��forѭ����ѡ�е�һ����������֮��������ҳ���Ϊs�ġ�
	 * 
	 * ��������ʱ�临�Ӷ�ΪO(N) ��Ϊ������ģ���ô����ʹ��start,endָ��ֱ�ָ���һ�������һ��λ��, 
	 * 1.���a[start] + a[end] > sum��endָ��ǰ�� 
	 * 2.���a[start] + a[end] < sum��startָ����� 
	 * 3.���a[start] + a[end] == sum����start���ƣ�endǰ�ƣ���Ϊ���ܴ��ڶ���������������һ��������Ҫstart++,end--������Ϊ����������ֵԽ����˻���С
	 * 4.�ظ���������
	 */
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> al = new ArrayList<>();
		if (array == null || array.length <= 0) {
			return al;
		}
		int start = 0, end = array.length - 1;
		while (start <= end) {
			if ((array[start] + array[end]) > sum) {
				end--;
			} else if ((array[start] + array[end]) < sum) {
				start++;
			} else {
				// a[start] + a[end] ==
				// sum����ʵ����Ҫstart++,end--�ģ���Ϊ�����ǵ����ģ�����������ֵԽ�󣬳˻�ԽС
				al.add(array[start]);
				al.add(array[end]);
				// �˳�ѭ��
				break; 
			}
		}
		return al;
	}
}
