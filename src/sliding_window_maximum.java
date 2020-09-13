import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class sliding_window_maximum {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        int k = input.nextInt();
        String[] tmp = s.split(",");


        int[] nums = new int[tmp.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(tmp[i]);
        }

        int[] arr = maxSlidingWindows(nums, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }


    public static int[] maxSlidingWindows(int[] nums, int k) {


//        int[] result = new int[nums.length - k + 1];
//        //暴力求解，做两重循环复杂度为nk，
//
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int j = i;
//            int currMax = Integer.MIN_VALUE;
//            while (j < i + k) {
//                currMax = Math.max(currMax, nums[j]);
//                j++;
//            }
//            result[i] = currMax;
//        }
//        return result;

        int n = nums.length;
        int len = n - k + 1;

        int[] result = new int[len];

        //使用队列来 实现

        //此栈是一个单调队列！！！！队头到队尾索引对应的值是从大到小的
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            //此处的位置是为了防止1，-1这样的情况出现，即最大值还是在队头，但实际的当前分组的最大值不在队头的情况
            if (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.removeFirst();
            }


            //如果此时入栈的元素大于队尾元素的值，则对尾出队；同时循环该过程，直到此队列再一次是单调的
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }

            queue.addLast(i);

            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[queue.peekFirst()];
            }
        }

        return result;

    }
}
