import java.util.HashMap;

/**
 * �����⣺�������ظ�������
 * ��Ŀ��������һ������Ϊn����������������ֶ���0~n-1�ķ�Χ�ڡ�������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�Ҳ��֪��ÿ�������ظ����Ρ�
 * ���ҳ������е�һ���ظ������֡� ���磺������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ������ǵ�һ���ظ�������2
 * 
 * ������ 
 * ����һ�����򣬿�������ʱ�临�Ӷ�ΪO(NlogN)
 * 
 * ��������HashMap����ͷ��ʼ��������Ԫ�أ�ÿɨ��һ��Ԫ�أ���������O(1)��ʱ�����жϹ�ϣ���Ƿ��Ѿ����������֡���������ڣ�����룬������ڣ������+1��Ȼ�ٴα������飬ÿ����һ�Σ���ȥHashMap�в��Ҷ�Ӧvalueֵ�Ƿ�Ϊ1�� ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(N)
 * 
 * ���������ͷ��������ƣ����Զ���int���飬int[] flag = new int[numbers.length];��������Ԫ�أ�flag[numbers[i]]++;
 * 
 * �����ģ� ��ͼ��0~n-1���뵽�����±�Ϊ0~n-1�Ķ�Ӧλ���ϣ�
 * ��ͷ��βɨ������Ԫ�أ���ɨ�赽�±�Ϊi��Ԫ��ʱ����arr[i]�����ȱȽ�arr[i]�Ƿ����i��������ڣ���ɨ����һ������������ڣ���Ƚ�arr[i]��arr[arr[i]]�Ƿ���ȣ������ȣ���˵�����ظ�Ԫ�أ���Ϊarr[i]�͵�i������arr[i]��Ԫ����ȣ�
 * �������ȣ���ѵ�i��Ԫ�غ͵�arr[i]��Ԫ�ؽ�������Ϊ������ͼ������Ԫ�����򣬰���arr[0] = 0,arr[1] = 1...arr[n-1] = n-1����
 * 
 * ע�⣺��Ȼ������������ѭ��������ÿ���������ֻ�жϣ�������Ҫ2�μ��ɣ������ܵ�ʱ�临�Ӷ�ΪO(N)���ռ临�Ӷ�ΪO(1)��
 * 
 * @author geyan
 *
 */
public class Duplicate {

	/**
	 * HashMap��������������ģ��HashMap
	 */
	public int duplicate_1(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			return -1;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < numbers.length; i++) {
			if (!map.containsKey(numbers[i])) {
				map.put(numbers[i], 1);
			} else {
				map.put(numbers[i], map.get(numbers[i]) + 1);
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			if (map.get(numbers[i]) == 1) {
				return numbers[i];
			}
		}
		return -1;
	}

	/**
	 * ������
	 */
	public int duplicate_2(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			return -1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
				return -1;
		}
		for (int i = 0; i < numbers.length; i++) {
			// numbers[i] == i����ɨ����һ������
			// numbers[i] != i������ͨ���жϣ�����
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					// ˵�����ظ�Ԫ��
					return numbers[i];
				} else {
					// ������i��Ԫ�غ͵�numbers[i]��Ԫ�أ����ǵ�Ŀ�ľ���ʹ��numbers[i] == i
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
		return -1;
	}
}
