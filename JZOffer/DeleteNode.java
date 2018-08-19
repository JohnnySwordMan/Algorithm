/**
 * 面试题13：在O(1)时间删除链表节点
 * 题目：给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点
 * @author geyan
 *
 */
public class DeleteNode {
	
	/**
	 * 单链表删除一个节点，最常规的做法是从头节点开始遍历，删除，时间复杂度为O(N)
	 * O(1)做法：找到要删除节点的后一个节点，将后一个节点内容复制到要删除的节点中，再把下一个节点删除。
	 * 需要考虑是否是最后一个节点
	 * @param head 链表的头节点
	 * @param p 需要删除的节点
	 */
	public static ListNode deleteNode(ListNode head,ListNode p){
		if(head == null || p == null){
			return head;  // 返回head，不写null
		}
		if(head == p)
			return head.next;
		// 如果p不是最后一个节点
		if(p.next != null){
			ListNode pNext = p.next;
			p.val = pNext.val;  // 不是p = pNext，是值复制
			p.next = pNext.next;
		}
		 else {
			ListNode pNode = head;
			// p是尾节点，找出p的前一个节点
			while(pNode.next != p){
				pNode = pNode.next;
			}
			pNode.next = null;
		}	
		return head;
	}
}
