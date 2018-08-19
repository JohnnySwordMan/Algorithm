package LeetCode;

/**
 * ��Ŀ���������������
 * ��Ŀ��������������L0��L1������Ln-1��Ln����������� L0��Ln ��L1��Ln-1��L2��Ln-2����
 * 
 * ������
 * 1.����ָ�룬�ҳ��м�ڵ�
 * 2.��ת��벿������
 * 3.�ϲ�����
 * @author geyan
 *
 */
public class ReOrderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// 1.����ָ�룬�ҳ��м�ڵ�
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// ��Ϊ��벿�ֵ�����������Ҫ��ת
		ListNode alter = slow.next;
		// ǰ�벿����������
		slow.next = null;

		// 2.��ת��벿�ֵ�����pre��������ͷ�ڵ�
		ListNode pre = null;
		while (alter != null) {
			// ������һ���ڵ�
			ListNode temp = alter.next;
			alter.next = pre;
			pre = alter;
			alter = temp;
		}

		// 3.�ϲ���������
		ListNode first = head;
		alter = pre;
		while (first != null && alter != null) {
			ListNode firstNext = first.next;
			ListNode alterNext = alter.next;

			alter.next = first.next;
			first.next = alter;

			first = firstNext;
			alter = alterNext;
		}
	}
}
