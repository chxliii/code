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


        //使用队列来 实现
    }
}
