import java.util.ArrayList;
import java.util.Stack;

/**
 * 面试题：从尾到头打印链表
 * 输入一个链表，从尾到头打印链表每个节点的值
 * Created by geyan on 2018/6/7.
 */
public class PrintListFromTailToHead {

    /**
     * 栈实现
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null) {
            return null;
        }
        ListNode head = listNode;
        while (head.next != null && head != null) {
            stack.push(head);
            head = head.next;
        }
        stack.push(head);

        while (!stack.isEmpty()) {
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }

    /**
     * 递归实现，本质上也是栈
     */
    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (listNode == null)
            return arrayList;

        printListFromTailToHead_2(listNode, arrayList);
        return arrayList;
    }

    public void printListFromTailToHead_2(ListNode listNode, ArrayList<Integer> arrayList) {
        // 递归进行的条件
        if (listNode.next != null) {
            printListFromTailToHead_2(listNode.next, arrayList);
        }
        arrayList.add(listNode.val);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
