import java.util.Stack;

/**
 * 两个栈实现队列，完成队列的Push和Pop操作。队列中的元素为int类型。
 * Created by geyan on 2018/8/11.
 */
public class TwoStack {

    /**
     * 分析：stack1做Push操作，stack2做Pop操作
     * 当Pop的时候，需要将stack1栈中元素加入到stack2中。保证：1.stack1元素全部加入到stack2中；2.加入元素之前，stack2无栈元素
     */

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
             stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
