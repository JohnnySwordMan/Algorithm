package LeetCode;

/**
 * ��Ŀ��ʹ�ò�������ķ�ʽ������������
 * @author geyan
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		// �½������ڵ�
		ListNode dumy = new ListNode(Integer.MIN_VALUE);
		ListNode cur = head;
		ListNode pre = dumy;
		while (cur != null) {
			// ���浱ǰ�ڵ����һ���ڵ�
			ListNode temp = cur.next;
			pre = dumy;

			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			// cur�ڵ����pre��pre.next֮��
			cur.next = pre.next;
			pre.next = cur;

			// ������һ��������ڵ�
			cur = temp;
		}
		return dumy.next;
	}
}
