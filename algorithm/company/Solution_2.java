import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 题目：餐馆
 * 题目描述：某餐馆有n张桌子，每张桌子有一个参数：a可容纳的最大人数;有m批客人，每批客人有两个参数：b人数，c预计消费金额。在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大。
 * 
 * 分析：
 * 先按桌子可容纳的最大人数排序，从小到大排序，而对于客人，以金额递减排序，通过优先队列可以实现。
 * 
 * @author geyan
 *
 */
public class Solution_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			// 桌子可容纳的最大人数
			int[] table = new int[n];
			for (int i = 0; i < n; i++) {
				table[i] = sc.nextInt();
			}
			// 按照可容纳的人数，将table数组排序，比如2，2，4
			Arrays.sort(table);
			// 客人
			PriorityQueue<Customer> pq = new PriorityQueue<Customer>();
			for (int i = 0; i < m; i++) {
				// 每批客人数
				int person = sc.nextInt();
				// 预计消费金额
				int money = sc.nextInt();
				if (person <= table[n - 1]) {
					// 最大容量的桌子可以坐下时，将客户加入队列
					pq.offer(new Customer(person, money));
				}
			}
			// ---------------------
			// 不能用int
			long sum = 0;
			int count = 0;
			// 桌子是否被占用
			boolean[] visited = new boolean[n];
			while (!pq.isEmpty()) {
				// 顶多把队列中的安排完
				// 由于列队中的都有资格吃，且排在前边的最有资格，应该安排；
				// 安排的时候注意先从小桌子安排，不行再换大桌子
				Customer cus = pq.poll();
				for (int i = 0; i < n; i++) {
					if (table[i] >= cus.peopleCount && !visited[i]) {
						// 可以坐下
						sum += cus.moneyCount;
						visited[i] = true;
						count++;
						break;
					}
				}
				if (count == n) {
					break;
				}
			}
			System.out.println(sum);
		}
	}
}

class Customer implements Comparable<Customer> {
	public int peopleCount = 0;
	public int moneyCount = 0;

	public Customer(int peopleCount, int moneyCount) {
		this.peopleCount = peopleCount;
		this.moneyCount = moneyCount;
	}

	@Override
	public int compareTo(Customer cus) {
		// 按钱数大小排，从大到小排
		if (this.moneyCount > cus.moneyCount)
			return -1;
		else if (this.moneyCount < cus.moneyCount) {
			return 1;
		} else {
			return 0;
		}
	}
}
