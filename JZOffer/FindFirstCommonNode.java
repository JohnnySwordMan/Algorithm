import java.util.Stack;

/**
 * ������37����������ĵ�һ�������ڵ� 
 * ��Ŀ�������������������ҳ����ǵĵ�һ�������ڵ�
 * 
 * @author geyan
 *
 */
public class FindFirstCommonNode {

	/**
	 * ����һ������ջ��ʱ�临�Ӷ�ΪO(n+m)���ռ临�Ӷ�ΪO(n+m)
	 * �ֱ��������������ϵĽڵ�ѹ��ջ�У�Ȼ��ͬʱ��ջ�����һ����ͬ�ڵ㣬��Ϊ��������Ĺ����ڵ�
	 */
	public ListNode findFirstCommonNode_1(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		Stack<ListNode> s1 = new Stack<>();
		Stack<ListNode> s2 = new Stack<>();
		while (pHead1 != null) {
			s1.push(pHead1);
			pHead1 = pHead1.next;
		}
		while (pHead2 != null) {
			s2.push(pHead2);
			pHead2 = pHead2.next;
		}
		ListNode commonListNode = null;
		// ���һ����ͬ�Ľڵ�
		while (!s1.isEmpty() && !s2.isEmpty() && s1.peek() == s2.peek()) {
			commonListNode = s1.pop();
			s2.pop();
		}
		return commonListNode;
	}

	/**
	 * ���������ȷֱ���������������������length1��length2�Լ����ǵĳ��Ȳ�len =
	 * length1-length2��length2-length1���ýϳ�����������len����Ȼ��ͬʱ����������������һ�α�������ͬ�ڵ�ʱ�����ظýڵ㡣
	 * ʱ�临�Ӷ�ΪO(n+m)���ռ临�Ӷ�ΪO(1)
	 */
	public ListNode findFirstCommonNode_2(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		int length1 = getLength(pHead1);
		int length2 = getLength(pHead2);
		ListNode cur1 = pHead1;
		ListNode cur2 = pHead2;
		// ����1���ȴ��ڵ�������2�ĳ��ȣ������ȱ���len����
		if (length1 >= length2) {
			int len = length1 - length2;
			while (len > 0) {
				cur1 = cur1.next;
				len--;
			}
		} else {
			int len = length2 - length1;
			while (len > 0) {
				cur2 = cur2.next;
				len--;
			}
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	private int getLength(ListNode pHead) {
		int count = 0;
		ListNode cur = pHead;
		while (cur != null) {
			count++;
			cur = cur.next;
		}
		return count;
	}
}
