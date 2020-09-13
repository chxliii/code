import java.util.Scanner;

public class MyClass {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int m = input.nextInt();

        int[][] target = new int[n][m];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                target[i][j] = input.nextInt();
            }
        }

        solutions(target);

    }

    public static void solutions(int[][] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            //j为列索引
            int j = 0;
            int count = 0;
            boolean flag = true;
            while ( j < nums[0].length && flag) {

                if (nums[i][j] != nums[i+1][j] ) {
                    flag = false;
                    break;
                }
                count++;
            }

            if (count == nums[0].length) {

                for (int l = 0; l <= i; l++ ){
                    for (int k = 0; k <= nums[0].length; k++) {
                        System.out.print(nums[l][k]);
                    }
                    System.out.println();
                }

                break;

            }


        }


    }


}
