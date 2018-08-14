/**
 * 反转链表
 * Created by geyan on 2018/8/13.
 */
public class ReverseList {

    /**
     * 输入一个链表，反转链表后，输出新链表的表头
     */
    public ListNode reverseList(ListNode head){
        if(head == null)
            return head;
        ListNode cur = head;
        ListNode reverseHead = null;
        ListNode pre = null;
        while (cur != null){
            // 先保存cur的下一个节点
            ListNode temp = cur.next;
            if(temp == null){
                reverseHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return reverseHead;
    }
}
