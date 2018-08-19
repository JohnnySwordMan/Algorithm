/**
 * ������13����O(1)ʱ��ɾ������ڵ�
 * ��Ŀ���������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ�
 * @author geyan
 *
 */
public class DeleteNode {
	
	/**
	 * ������ɾ��һ���ڵ㣬���������Ǵ�ͷ�ڵ㿪ʼ������ɾ����ʱ�临�Ӷ�ΪO(N)
	 * O(1)�������ҵ�Ҫɾ���ڵ�ĺ�һ���ڵ㣬����һ���ڵ����ݸ��Ƶ�Ҫɾ���Ľڵ��У��ٰ���һ���ڵ�ɾ����
	 * ��Ҫ�����Ƿ������һ���ڵ�
	 * @param head �����ͷ�ڵ�
	 * @param p ��Ҫɾ���Ľڵ�
	 */
	public static ListNode deleteNode(ListNode head,ListNode p){
		if(head == null || p == null){
			return head;  // ����head����дnull
		}
		if(head == p)
			return head.next;
		// ���p�������һ���ڵ�
		if(p.next != null){
			ListNode pNext = p.next;
			p.val = pNext.val;  // ����p = pNext����ֵ����
			p.next = pNext.next;
		}
		 else {
			ListNode pNode = head;
			// p��β�ڵ㣬�ҳ�p��ǰһ���ڵ�
			while(pNode.next != p){
				pNode = pNode.next;
			}
			pNode.next = null;
		}	
		return head;
	}
}
