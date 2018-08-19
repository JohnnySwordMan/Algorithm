package listNode;

/**
 * ��Ŀ������ָ��ֵ��� ��Ŀ������������һ��������������ÿ���ڵ㱣��һ���������ٸ���һ��ֵval�������е���val�Ľڵ�ɾ����
 * ����һ���������ͷ�ڵ�head��ͬʱ����һ��ֵval���뷵�������������ͷ�ڵ㣬��֤�������в����ڸ�ֵ������ֵ���뱣֤����Ԫ�ص����˳��
 * 
 * @author geyan
 *
 */
public class ClearValue {

	/**
	 * ���������������жϽڵ��ֵ�Ƿ���ڸ���val���ڱ�������Ĺ����У���¼��ǰ�ڵ��ǰһ���ڵ㡣ͬʱ��Ҫ�ж�ɾ���Ľڵ����Ƿ���ͷ�ڵ��β�ڵ�
	 * ���������ڲ����Ĺ����У����Է�ͷ�ڵ㣬�м�ڵ㣬β�ڵ�
	 */
	public ListNode clear(ListNode head, int val) {
		if (head == null)
			return head;
		// ��¼��ǰ�ڵ�
		ListNode cur = head;
		// ��¼��ǰ�ڵ��ǰ���ڵ�
		ListNode pre = cur;
		// ��ʱ������β�ڵ�
		while (cur.next != null) {
			if (cur.val != val) {
				// ��¼��ǰ�ڵ��ǰ���ڵ�
				pre = cur;
				// ָ����һ���ڵ�
				cur = cur.next;
			} else {
				// ��ͷ�ڵ��ֵ���ڸ���valʱ����û�н���ɾ������Ҫ��������
				pre.next = cur.next;
				cur = cur.next;
			}
		}
		// β�ڵ㣬β�ڵ��ֵ���õ��ڸ�����val����ֱ�ӽ�pre.next = null
		if (cur.val == val) {
			pre.next = null;
		}

		// ���ͷ�ڵ��ֵ���ڸ���val
		if (head.val == val) {
			return head.next;
		}
		return head;
	}

	/**
	 * ��������������Ĳ��������Դ���һ�������ڵ���Ϊͷ�ڵ㣬��ȥ�ж�ͷ�ڵ��ɾ�����������԰�head�ڵ㵱���м�ڵ�
	 */
	public ListNode clear_1(ListNode head, int val) {
		if (head == null)
			return head;
		ListNode node = new ListNode(0);
		node.next = head;
		ListNode cur = node;
		ListNode pre = cur;
		while (cur.next != null) {
			if (cur.val != val) {
				pre = cur;
				cur = cur.next;
			} else {
				pre.next = cur.next;
				cur = cur.next;
			}
		}
		if (cur.val == val) {
			pre.next = null;
		}
		return node.next;
	}
}
