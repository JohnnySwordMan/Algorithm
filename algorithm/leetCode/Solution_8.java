package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 题目：输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * @author geyan
 *
 */
public class Solution_8 {

	static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int n = input.nextInt();
			int m = input.nextInt();
			dfs(1, m, n);
			for (int i = 0; i < res.size(); i++) {
				for (int j = 0; j < res.get(i).size() - 1; j++) {
					System.out.print(res.get(i).get(j) + " ");
				}
				System.out.println(res.get(i).get(res.get(i).size() - 1));
			}
		}
	}

	public static void dfs(int index, int m, int n) {
		if (m == 0) {
			res.add(new ArrayList<>(al));
		} else {
			for (int i = index; i <= m && i <= n; i++) {
				al.add(i);
				dfs(i + 1, m - i, n);
				al.remove(al.size() - 1);
			}
		}
	}
}
