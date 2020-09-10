import java.util.ArrayDeque;
import java.util.Deque;

public class min_stack {

    Deque<Integer> stack;
    Deque<Integer> minstack;
    public min_stack () {
        stack = new ArrayDeque<>();
        minstack = new ArrayDeque<>();
    }

    public void push(int e) {
        stack.addFirst(e);

        if (minstack.isEmpty() || minstack.peekFirst() >= e) {

            //如果入栈的元素小于当前最小栈的栈顶元素，则更新此位置处的最小值
            minstack.addFirst(e);
        }
    }

    public void pop() {

        //对stack的元素出栈，再和当前最小栈的栈顶元素比较，如果相等，说明此时最小栈的索引位置和stack位置对应，则也需要出栈
        if(stack.removeFirst().equals(minstack.peekFirst())) {
            minstack.removeFirst();
        }

    }

    public int top() {
        return stack.peekFirst();
    }


    public int getMin() {
        return minstack.peekFirst();
    }


}
