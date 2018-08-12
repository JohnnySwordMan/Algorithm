/**
 * 链表中倒数第k个结点
 * Created by geyan on 2018/8/12.
 */
public class FindKthToTail {

    /**
     * 输入一个链表，输出该链表中倒数第k个结点
     * <p>
     * 分析：设置两个指针first,second，先由first指针走k步，然后first、second指针一起走，
     * 当first指针为null时，second指针指向位置，即为链表中倒数第k个结点
     * 注意，边界条件
     */
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        for (int i = 0; i < k; i++) {
            if (first != null) {
                first = first.next;
            } else {
                return null;
            }
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        return second;
    }
}
