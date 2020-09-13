package second_time;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack () {
        stack = new ArrayDeque<>();

        minStack = new ArrayDeque<>();
    }

    public void push(int e) {
        stack.addFirst(e);

        if (minStack.isEmpty() || e <= minStack.peekFirst()) {

            minStack.addFirst(e);
        }
    }

    public void pop() {
        //stack肯定要出栈，可以放到判断条件中
        if (minStack.peekFirst().equals(stack.removeFirst())) {
            minStack.removeFirst();
        }
    }


    public int top() {
        return stack.peekFirst();
    }

    public int getMin() {
        return minStack.peekFirst();
    }



}

class MinStackWithoutExtraMemory {
    Deque<Integer> diff;
    int minValue;

    public MinStackWithoutExtraMemory() {
        diff = new ArrayDeque<>();
    }

    public void push(int x) {
        //如果diff为空说明为第一个元素
        if (diff.isEmpty()) {
            minValue = x;
            diff.addFirst(x);
        } else {
            diff.addFirst(x - minValue);
            minValue = (x - minValue) > 0 ? minValue : x;
        }
    }

    public void pop() {
        // 出栈时只用维护其最小值
        minValue = (diff.peekFirst() < 0)? minValue - diff.peekFirst() : minValue;

        diff.removeFirst();

    }

    public int top() {
        int topValue = (diff.peekFirst() >= 0)? diff.peekFirst() + minValue : minValue;
        return topValue;
    }

    public int getMinValue() {
        return minValue;
    }


}

public class min_stack {

    public static void main(String[] args) {
        MinStackWithoutExtraMemory stack = new MinStackWithoutExtraMemory();
        stack.push(2);
    }
}
