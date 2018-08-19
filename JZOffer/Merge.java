/**
 * 合并两个排序的链表
 * Created by geyan on 2018/8/19.
 */
public class Merge {

    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     *
     * 有点归并排序的意思
     */
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode root = new ListNode(Integer.MAX_VALUE);
        ListNode cur = root;
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return root.next;
    }
}
