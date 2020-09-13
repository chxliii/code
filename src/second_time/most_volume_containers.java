package second_time;

/**
 *@Author chxliii
 *@Description 盛水最多的容器
 *@Date 09:50 2020-09-12
 *@Param
 *@Return
 **/
public class most_volume_containers {

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(nums));
    }


    public static int maxArea(int[] nums) {
//        //法1两重循环暴力法：遍历所有的ij索引
//        int maxArea = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                maxArea = Math.max(maxArea, Math.min(nums[i], nums[j]) * (j - i));
//            }
//        }
//
//        return maxArea;


        //法2：双指针方法
        //思想: 初始化左右两指针在左右边界位置，谁当前值较小，就向中间进行移动，如果找到值比之前大，则有可能面积更大

        int maxArea = 0;
        int i = 0, j = nums.length - 1;

        while (i < j) {
            //这处写的非常好，即指明了移动方向，有同时对高度进行了准确的赋值
            int height = (nums[i] < nums[j]) ? nums[i++] : nums[j--];
            maxArea = Math.max(maxArea, height * (j-i + 1));

        }

        return maxArea;
    }
}
