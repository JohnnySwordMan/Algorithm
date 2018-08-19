import java.util.HashMap;

/**
 * 面试题：数组中重复的数字
 * 题目描述：在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。 例如：如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2
 * 
 * 分析： 
 * 方法一：排序，可以做到时间复杂度为O(NlogN)
 * 
 * 方法二：HashMap，从头开始遍历数组元素，每扫描一个元素，都可以用O(1)的时间来判断哈希表是否已经包含该数字。如果不存在，则加入，如果存在，则次数+1。然再次遍历数组，每遍历一次，都去HashMap中查找对应value值是否为1。 时间复杂度为O(N)，空间复杂度为O(N)
 * 
 * 方法三：和方法二类似，可以定义int数组，int[] flag = new int[numbers.length];遍历数组元素，flag[numbers[i]]++;
 * 
 * 方法四： 企图将0~n-1插入到数组下标为0~n-1的对应位置上，
 * 从头到尾扫描数组元素，当扫描到下标为i的元素时，即arr[i]，首先比较arr[i]是否等于i，如果等于，则扫描下一个，如果不等于，则比较arr[i]与arr[arr[i]]是否相等，如果相等，则说明有重复元素，因为arr[i]和第i个，第arr[i]个元素相等，
 * 如果不相等，则把第i个元素和第arr[i]个元素交换，因为我们企图将数组元素排序，按照arr[0] = 0,arr[1] = 1...arr[n-1] = n-1排序
 * 
 * 注意：虽然代码中有两层循环，但是每个数字最多只判断，交换需要2次即可，所以总的时间复杂度为O(N)，空间复杂度为O(1)。
 * 
 * @author geyan
 *
 */
public class Duplicate {

	/**
	 * HashMap，或者用数组来模拟HashMap
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
	 * 方法四
	 */
	public int duplicate_2(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			return -1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > numbers.length - 1)
				return -1;
		}
		for (int i = 0; i < numbers.length; i++) {
			// numbers[i] == i，则扫描下一个数字
			// numbers[i] != i，我们通过判断，交换
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					// 说明有重复元素
					return numbers[i];
				} else {
					// 交换第i个元素和第numbers[i]个元素，我们的目的就是使得numbers[i] == i
					int temp = numbers[i];
					numbers[i] = numbers[temp];
					numbers[temp] = temp;
				}
			}
		}
		return -1;
	}
}
