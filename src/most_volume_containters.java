public class most_volume_containters {
    /*
     *@Author chxliii
     *@Description 盛水最多的容器
     * 法1：遍历所有的区间，两重循环
     *@Date 15:51 2020-09-07
     *@Param [args]
     *@Return void
     **/
    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(maxArea(a));


    }

    public static int maxArea(int[] a) {
        //法1：两重循环
//        int max = 0;
//        for (int i = 0; i < a.length - 1; i++) {
//            for (int j = i + 1; j < a.length; j++) {
//                int area = (j - i) * Math.min(a[i], a[j]);
//                max = Math.max(max, area);
//            }
//        }
//        return max;

        //法2：双指针往中间收敛
        int max = 0;

        for (int i = 0, j = a.length - 1; i < j;){
            int maxHeight = a[i] < a[j] ? a[i ++] : a[j --];
            int area = maxHeight * (j - i + 1);
            max = Math.max(area, max);
        }
        return max;
    }
}
