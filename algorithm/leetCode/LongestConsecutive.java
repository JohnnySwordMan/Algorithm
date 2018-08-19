package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目：最长连续序列
 * 题目描述：给定一个没有排序的数组，求出最长的连续序列，比如[100,4,200,1,3,2]，最长的连续数组为[1,2,3,4]，所以返回4。复杂度为O(n)
 * 
 * 分析：由于时间复杂度为O(n)，所以不能使用排序。
 * 使用Set集合，将数组中元素都添加到set集合中，遍历数组，对于数组中的任意一个元素a，先在Set集合中删除，然后在Set集合中查找a-1与a+1是否也在数组中，如果在，继续查找a-2,a+2是否还在Set集合中，
 * 直至在Set集合中查找不到。
 * @author geyan
 *
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<>();
		for (int item : num) {
			set.add(item);
		}
		int ans = 0;
		for (int item : num) {
			if (set.contains(item)) {
				set.remove(item);
				int pre = item - 1;
				int next = item + 1;
				while (set.contains(pre)) {
					set.remove(pre);
					pre--;
				}
				while (set.contains(next)) {
					set.remove(next);
					next++;
				}
				ans = Math.max(ans, next - pre - 1);
			}
		}
		return ans;
	}
}
