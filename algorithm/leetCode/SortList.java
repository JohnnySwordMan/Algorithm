package LeetCode;

/**
 * ��Ŀ����������
 * ��Ŀ������ʹ�ú㶨�Ŀռ临�Ӷȣ�ʱ�临�Ӷ�ΪO(nlogn)
 * 
 * ��������ʱ�临�Ӷ�ΪO(nlogn)������������ݹ鲢������ʵ�֣����ҵ�������м�ڵ㣬ʹ��slow��fast���Խ�ԭ��������ֳ�һ��
 * @author geyan
 *
 */
public class SortList {

	public ListNode sortList(ListNode head) {
		// ����Ϊ�գ���ֻ��һ���ڵ㣬��Ϊʹ�ù鲢��ֻ��һ���ڵ㣬���ö��ַ�ѽ
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		
		return merge(left, right);
	}

	// ��������ĺϲ�
	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode root = new ListNode(0);
		ListNode node = root;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				node.next = head1;
				head1 = head1.next;
			} else {
				node.next = head2;
				head2 = head2.next;
			}
			// ����������һ��
			node = node.next;
		}
		if (head1 != null) {
			node.next = head1;
		}
		if (head2 != null) {
			node.next = head2;
		}
		return root.next;
	}
}
