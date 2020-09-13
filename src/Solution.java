import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int m = input.nextInt();

        int k = input.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        System.out.println(solution(nums, m, k));

    }

    public static int solution(int[] nums,int m,int beauty) {

        int ans = 0;
        //i指示第一个位置
        for (int i = 0; i <= nums.length - m; i++) {
            int j = i;
            boolean flag = true;
            int count = 0;
            while (j < i + m && flag) {
                //如果当前遍历的饰品美丽值小于给定beauty则跳出
                if (nums[j] < beauty) {
                    flag = false;
                    break;
                }
                count++;
                j++;
            }

            if (count == m) {
                ans++;
            }
        }

        return ans;
    }
}
