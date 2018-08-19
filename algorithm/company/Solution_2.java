import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ��Ŀ���͹�
 * ��Ŀ������ĳ�͹���n�����ӣ�ÿ��������һ��������a�����ɵ��������;��m�����ˣ�ÿ������������������b������cԤ�����ѽ��ڲ�����ƴ��������£���ʵ��һ���㷨ѡ������һ���ֿ��ˣ�ʹ����Ԥ�����ѽ�����
 * 
 * ������
 * �Ȱ����ӿ����ɵ�����������򣬴�С�������򣬶����ڿ��ˣ��Խ��ݼ�����ͨ�����ȶ��п���ʵ�֡�
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
			// ���ӿ����ɵ��������
			int[] table = new int[n];
			for (int i = 0; i < n; i++) {
				table[i] = sc.nextInt();
			}
			// ���տ����ɵ���������table�������򣬱���2��2��4
			Arrays.sort(table);
			// ����
			PriorityQueue<Customer> pq = new PriorityQueue<Customer>();
			for (int i = 0; i < m; i++) {
				// ÿ��������
				int person = sc.nextInt();
				// Ԥ�����ѽ��
				int money = sc.nextInt();
				if (person <= table[n - 1]) {
					// ������������ӿ�������ʱ�����ͻ��������
					pq.offer(new Customer(person, money));
				}
			}
			// ---------------------
			// ������int
			long sum = 0;
			int count = 0;
			// �����Ƿ�ռ��
			boolean[] visited = new boolean[n];
			while (!pq.isEmpty()) {
				// ����Ѷ����еİ�����
				// �����ж��еĶ����ʸ�ԣ�������ǰ�ߵ������ʸ�Ӧ�ð��ţ�
				// ���ŵ�ʱ��ע���ȴ�С���Ӱ��ţ������ٻ�������
				Customer cus = pq.poll();
				for (int i = 0; i < n; i++) {
					if (table[i] >= cus.peopleCount && !visited[i]) {
						// ��������
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
		// ��Ǯ����С�ţ��Ӵ�С��
		if (this.moneyCount > cus.moneyCount)
			return -1;
		else if (this.moneyCount < cus.moneyCount) {
			return 1;
		} else {
			return 0;
		}
	}
}
