package LeetCode;

import java.util.*;

/**
 * 京东笔试题：给你两个集合，要求{A} + {B}。 注：同一个集合中不会有两个相同的元素。 
 * 
 * 分析：合并集合，按顺序输出，不能有重复
 * @author geyan
 *
 */
public class Solution_20 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int m = input.nextInt();
			TreeSet<Integer> set = new TreeSet<>();
			for (int i = 0; i < n + m; i++) {
				set.add(input.nextInt());
			}
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				System.out.print(it.next());
				if (it.hasNext())
					System.out.print(" ");
			}
		}
	}
}