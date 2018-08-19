package LeetCode;

import java.util.*;

/**
 * 题目：头条的2017校招开始了！为了这次校招，我们组织了一个规模宏大的出题团队，每个出题人都出了一些有趣的题目，而我们现在想把这些题目组合成若干场考试出来，
 * 在选题之前，我们对题目进行了盲审，并定出了每道题的难度系统。一场考试包含3道开放性题目，假设他们的难度从小到大分别为a,b,c，我们希望这3道题能满足下列条件：
 * a<=b<=c
 * b-a<=10
 * c-b<=10
 * 所有出题人一共出了n道开放性题目。
 * 现在我们想把这n道题分布到若干场考试中（1场或多场，每道题都必须使用且只能用一次），
 * 然而由于上述条件的限制，可能有一些考试没法凑够3道题，因此出题人就需要多出一些适当难度的题目来让每场考试都达到要求，然而我们出题已经出得很累了，你能计算出我们最少还需要再出几道题吗？
 * 
 * 分析：遍历数组，判断前后差值是否小于等于10，如果小于等于10的话，我们只需要依次往后遍历，不需要考虑添加元素，等到遍历结束后，最后一组的元素如果不满3个，再添加。
 * 如果前后差值大于10，那么我们应该要考虑是否需要添加元素，使其成为一组
 * @author geyan
 *
 */
public class Solution_13 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = input.nextInt();
			}
			function(arr, n);
		}
	}

	public static void function(int[] arr, int n) {
		// 按照从小到大的顺序排序
		Arrays.sort(arr);
		// 需要添加的个数
		int sum = 0;
		// 当前一组中元素的个数，arr[0]是第一组中的第一个
		int curSum = 1;

		for (int i = 1; i < n; i++) {
			// 不需要添加
			if (arr[i] - arr[i - 1] <= 10) {
				if (curSum == 3) {
					// 正好为一组，那么从第二组开始
					curSum = 1;
				} else {
					// 小于3，即不满一组
					curSum++;
				}
			} else {
				// 前后相邻差值大于10，比如a[i]-a[i-1],此时有两种情况，1.前面正好构成3个一组，即a[i-3],a[i-2],a[i-1]为一组，即curSum
				// == 3，则curSum = 1，重新开始计算下一组
				// 2.不满一组，那么就计算出前面缺几个能成为一组，a[i-1]还缺几个能构成一组，而a[i]为下一组的第一个
				if (curSum < 3) {
					sum += 3 - curSum;
					curSum = 1;
				} else {
					curSum = 1;
				}
			}
		}
		// 如果最后遍历结束，剩下一组中元素不满3个，则需要添加使其能够成为一组
		if (curSum < 3) {
			sum += 3 - curSum;
		}
		System.out.println(sum);
	}
}