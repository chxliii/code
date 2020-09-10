package second_time;

import java.util.*;

public class threeSums {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, -1, 3, 5, -2, 4, 1, 9, -10, 1};

        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

//        //暴力法：三重循环
//        Arrays.sort(nums);
//        //notice!!!必须排序，因为可能有多个相同值的元素处于不同索引位置实现和为0，排序后，从小到大排序，i，j，k的位置的值是递增的
//        Set<List<Integer>> set = new HashSet<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> l = Arrays.asList(nums[i], nums[j], nums[k]);
//                        set.add(l);
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(set);

        /******************************************************/

        //hashmap + 两重循环

        //思想：遍历c的值，由于三数相加，c只能取n-2个值

//        Set<List<Integer>> set = new HashSet<>();
//
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = - nums[i];
//
//            Map<Integer, Integer> map = new HashMap<>();
//
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                int v = target - nums[j];
//
//                if(map.containsKey(v)) {
//                    List<Integer> ele = Arrays.asList(nums[i], nums[j], v);
//                    ele.sort(Comparator.naturalOrder());
//                    set.add(ele);
//                }else {
//                    map.put(nums[j], nums[j]);
//                }
//            }
//        }
//
//        return new ArrayList<>(set);

        /********************************************/

        //方法三：夹逼法，先对数组排序， 再遍历c的n-2个位置；i，j作为两个指针

        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
            //#这次忘了这个点！！！排序后，如果k都大于0，则返回空
            if (nums[k] > 0) {
                break;
            }

            //#另外忘了一点,如果此时的nums[i] == nums[i-1],则上一次已经进行了搜索，这次直接跳过
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[i] +  nums[j] + nums[k];
                if (sum > 0) {
                    //说明j可以左移动
                    while (i < j && nums[j] == nums[-- j]);
                }else if (sum < 0) {
                    //说明i可以右移动
                    while (i < j && nums[i] == nums[++ i]);
                }else {
                    //相等


                    List<Integer> ele = Arrays.asList(nums[k], nums[i], nums[j]);
                    set.add(ele);


                    //set.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));

                    //同时需要排除掉重复的元素
                    while (i < j && nums[i] == nums[ ++i]);
                    while (i < j && nums[j] == nums[ --j]);
                }
            }
        }

        return new ArrayList<>(set);

    }
}
