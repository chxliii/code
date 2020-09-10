package second_time;

import java.util.Scanner;

public class maxV {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();

        String[] tmp = s.split(",");

        int[] nums = new int[tmp.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.valueOf(tmp[i]);
        }

        System.out.println(findMax(nums));
    }

    public static int findMax(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }

        return dp[n];
    }
}
