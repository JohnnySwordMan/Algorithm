/**
 * �����⣺ɾ���������ظ��Ľڵ�
 * ��Ŀ��������һ������������У������ظ��Ľڵ㣬��ɾ�����������ظ��Ľڵ㣬�ظ��Ľڵ㲻���������������ͷָ�롣
 * 
 * ��������ظ��ڵ㣬ȫ��ɾ��
 * @author geyan
 *
 */
public class DeleteDuplication {

	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return pHead;
		// ���ֻ��һ���ڵ�
		if (pHead.next == null)
			return pHead;
		// �´���һ�������ڵ㣬���Խ���һ���ڵ���֮��Ľڵ�һ������
		ListNode root = new ListNode(-1);
		root.next = pHead;
		// ��¼��ǰ����ڵ�
		ListNode cur = pHead;
		// ��¼ǰ���ڵ�
		ListNode pre = root;
		while (cur != null && cur.next != null) {
			// ���ظ��ڵ�
			if (cur.val == cur.next.val) {
				// �ҵ���һ����curֵ��ͬ�Ľڵ�
				while (cur.next != null && cur.val == cur.next.val) {
					cur = cur.next;
				}
				// ����Ҫ�ж����һ���ڵ㣬ԭ����������������1->2->5->5->5���ڲ�whileѭ���˳�����ʱcurָ�����һ��5����ôpre.next
				// = cur.next����pre.next = null;
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		// ���ﲢ����Ҫ�ж����һ���ڵ�
		return root.next;
	}
}
