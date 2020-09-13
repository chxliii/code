import java.util.Scanner;

public class Main {

    public static int count = 0;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        int n = input.nextInt();

        int k = input.nextInt();

        int d = input.nextInt();


        solutions(n, k, d, 0, 0);
        System.out.println(count);

    }


    public static int solutions(int n, int k, int d, int max, int sum) {

        if(sum == n) {
            if (max >= d) {
                count++;
                return 0;
            }
            return 0;
        } else if (sum < n) {
            for (int i = k; i > 0; i--) {
                int tmpMax = Math.max(i, max);
                int tmpSum = sum + i;
                solutions(n, k, d, tmpMax, tmpSum);
            }
        }

        return 0;
    }
}


//        if (d > n) {
//            return 0;
//        }
//
//        //索引i代表和为i的总共方案数量
//        int[] dp = new int[n+1];
//
//        dp[0] = 0;
//
//        dp[1] = 0;
//
//
//
//        //和要求大于1但是
//        for (int i = 2; i < n + 1; i++) {
//            //遍历最大值的方案数量
//            for (int j = d; i >= j && j <= k; j++){
//                dp[i] += dp[i - j] + j;
//             }
//        }
//
//        return dp[n];