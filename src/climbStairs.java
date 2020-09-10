public class climbStairs {

    public static void main(String[] args) {
        System.out.print(climbStair(3));
    }

    public static int climbStair(int n) {
        if (n <= 2) {
            return n;
        }

//        //法1：递归
//        return climbStair(n-1) + climbStair(n-2);
        //法2：数组传入函数，做存储，如果不为0直接返回
        //法3：动态规划
//        int[] dp = new int[n + 1];
//
//        dp[1] = 1;
//        dp[2] = 2;
//
//        for (int i = 3; i <= n; i++){
//            dp[i] = dp[i - 1] + dp[i -2];
//        }
//
//        return dp[n];
        //法4：进一步压缩空间
        int first = 1, second = 2;
        int sum = 3;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }

        return sum;
    }
}
