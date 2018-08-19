/**
 * ��Ŀ������ķֻ�
 * ����һ������������Ҫ��һ���ض�����ֵ��ɶ����ķֻ���ʹ��С�ڵ������ֵ�Ľڵ��Ƶ�ǰ�棬���ڸ�ֵ�Ľڵ��ں��棬ͬʱ��֤����ڵ��ڲ���λ�ù�ϵ���䡣
 * ����һ�������ͷ�ڵ�head��ͬʱ������ֵval���뷵��һ������ʹС�ڵ������Ľڵ���ǰ�����ڵ��������ں󣬱�֤�ڵ�ֵ���ظ���
 * 
 * ������ ����ֻ���������ֳ�2����.��һ������С�ڵ���val����������Ǵ���val���������ϲ�����
 * 
 * @author geyan
 *
 */
public class Divide {

	/**
	 * ָ��ĸ�ֵ��������⣬ֱ�ӿ������ڴ��ַ�ĸ�ֵ�������������
	 */
	public ListNode listDivide_1(ListNode head, int val) {
		if (head == null || head.next == null)
			return head;

		// С�ڲ���
		ListNode leftHead = null;
		ListNode leftTail = null;

		// ���ڲ���
		ListNode rightHead = null;
		ListNode rightTail = null;

		ListNode p = head;
		ListNode next = null;
		while (p != null) {
			// �ȱ���p����һ���ڵ�
			next = p.next;
			// p�ǿ�����Ϊ�����һ�������������������ֻ����������p.next����Ϊnull����ô��p�ڵ㸳��leftHead��rightHead�Ļ�������Ὣp����Ľڵ�һ�����ӵ�leftHead��rightHead��
			p.next = null;
			if (p.val <= val) { // =�ǶԵ�
				if (leftHead == null) {
					leftHead = p;
					leftTail = p;
				} else {
					leftTail.next = p;
					leftTail = p;
				}
			} else {
				if (rightHead == null) {
					rightHead = p;
					rightTail = p;
				} else {
					rightTail.next = p;
					rightTail = p;
				}
			}
			p = next;
		}
		if (leftTail != null) {
			leftTail.next = rightHead;
		}
		return leftHead != null ? leftHead : rightHead;
	}

	/**
	 * ��Ŀ��˼��ʵ��ﲻ�ã���Ŀԭ���ǽ�С�ڵ���val��������ߣ�����val�ķ����ұ� ����������{1620,1134,861,563,1},1134
	 * ����Ӧ����{1134,861,563,1,1620} ���´����������{861,563,1,1134,1620}���ı��˽ڵ��ڲ�λ�ù�ϵ
	 */
	public ListNode listDivide_2(ListNode head, int val) {
		if (head == null || head.next == null)
			return head;

		// С�ڲ���
		ListNode leftHead = null;
		ListNode leftTail = null;

		// ���ڲ���
		ListNode valHead = null;
		ListNode valTail = null;

		// ���ڲ���
		ListNode rightHead = null;
		ListNode rightTail = null;

		ListNode p = head;
		ListNode next = null;
		while (p != null) {
			// �ȱ���p����һ���ڵ�
			next = p.next;
			// p�ǿ�����Ϊ�����һ�������������������ֻ����������p.next����Ϊnull����ô��p�ڵ㸳��leftHead��rightHead�Ļ�������Ὣp����Ľڵ�һ�����ӵ�leftHead��rightHead��
			p.next = null;
			if (p.val < val) {
				if (leftHead == null) {
					leftHead = p;
					leftTail = p;
				} else {
					leftTail.next = p;
					leftTail = p;
				}
			} else if (p.val > val) {
				if (rightHead == null) {
					rightHead = p;
					rightTail = p;
				} else {
					rightTail.next = p;
					rightTail = p;
				}
			} else {
				if (valHead == null) {
					valHead = p;
					valTail = p;
				} else {
					valTail.next = p;
					valTail = p;
				}
			}
			p = next;
		}
		if (leftTail != null) {
			leftTail.next = valHead;
		}
		if (valTail != null) {
			valTail.next = rightHead;
		}
		if (leftHead != null) {
			return leftHead;
		} else if (valHead != null)
			return valHead;
		else
			return rightHead;
	}

	// errorд��
	public ListNode listDivide_error(ListNode head, int val) {
		ListNode head1 = null;
		ListNode head2 = null;
		ListNode head3 = null;
		// ������ʱ��headָ�����ƶ�����Ӧ��pָ��ͷ�ڵ㣬�ƶ�pָ��
		while (head != null) {
			if (head.val < val) {
				head1 = head;
			} else if (head.val > val) {
				head3 = head;
			} else {
				head2 = head;
			}
			head = head.next;
		}
		ListNode p1 = head1;
		while (p1.next != null) {
			p1 = p1.next;
		}
		ListNode p2 = head2;
		while (p2.next != null) {
			p2 = p2.next;

		}

		p1.next = head2;
		p2.next = head3;
		return head;
	}

}
