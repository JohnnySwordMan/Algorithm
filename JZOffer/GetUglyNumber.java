/**
 * 面试题34：丑数
 * 题目描述：我们把只包含因子2，3，5的数称作丑数。求从小到大的顺序的第1500个丑数。例如6，8都是丑数，但14不是，因为它包含因子7。习惯上我们把1当做第一个丑数。
 * @author geyan
 *
 */
public class GetUglyNumber {

	/**
	 * 方法一：不管一个数是不是丑数，都需要计算，效率比较低下
	 * @param index
	 * @return
	 */
	public int getUglyNumber_1(int index) {
		if (index <= 0)
			return 0;
		int num = 1;
		int count = 0;
		while (count < index) {
			if (isUgly(num)) {
				count++;
			}
			num++;
		}
		return num;
	}

	/**
	 * 方法二：用空间换时间的解法
	 * 创建数组，用来保存已经找到的丑数。显然，一个丑数是比它小的丑数×2/×3/×5的结果。
	 * 举例说明：
	 * arr[0] = 1 第一个丑数，那么第二个丑数，一定是min(arr[0]*2,arr[0]*3,arr[0]*5)的结果
	 * arr[1] = 2 第二个丑数，那么第三个丑数，一定是arr[0]/arr[1]×2/×3/×5的最小值
	 * 
	 * 即min(arr[p2]*2,arr[p3]*3,arr[p5]*5)
	 * @param index
	 * @return
	 */
	public int getUglyNumber_2(int index) {
		if (index <= 0)
			return 0;
		int[] uglyNumbers = new int[index];
		// 1是第一个丑数
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;
		int p2 = 0, p3 = 0, p5 = 0;
		while (nextUglyIndex < index) {
			int min = Math.min(uglyNumbers[p2] * 2, Math.min(uglyNumbers[p3] * 3, uglyNumbers[p5] * 5));
			uglyNumbers[nextUglyIndex] = min;
			// 更新p2,p3,p5的值，只要求出第一个大于当前数组最新更新的元素即可
			while (uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyIndex]) {
				p2++;
			}
			while (uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyIndex]) {
				p3++;
			}
			while (uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyIndex]) {
				p5++;
			}
			nextUglyIndex++;
		}
		return uglyNumbers[nextUglyIndex - 1];
	}

	public boolean isUgly(int number) {
		while (number % 2 == 0) {
			number /= 2;
		}
		while (number % 3 == 0) {
			number /= 3;
		}
		while (number % 5 == 0) {
			number /= 5;
		}
		return (number == 1) ? true : false;
	}
}
