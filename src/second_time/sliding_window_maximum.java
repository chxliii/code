package second_time;

import java.util.ArrayDeque;
import java.util.Deque;

public class sliding_window_maximum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};

        int k = 3;

        int[] result = maxV(nums, k);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]  + " ");
        }
     }


    public static int[] maxV(int[] nums, int k) {

        int len = nums.length - k + 1;

        int[] result = new int[len];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            //如果是1,-1，则进入的还是单调的,即当前分组的最大值不在队头
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            //如果入队的元素大于当前队列的队尾元素，则进行出队操作,直到该队列再次为单调的
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i - k + 1  >= 0) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
