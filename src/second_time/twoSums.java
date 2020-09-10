package second_time;

import java.util.HashMap;
import java.util.Map;

public class twoSums {

    public static void main(String[] args) {
        int[] a = new int[] {1, -1, 2, 5, 3, 7, 8};

        int[] res = twoSum(a, 15);

        System.out.println(res[0]+ " "+ res[1]);

    }

    public static int[] twoSum(int[] nums, int target) {
//        //暴力法，两重循环
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if(nums[i] + nums[j] == target) {
//                    return new int[] { i, j };
//                }
//            }
//        }


        Map<Integer, Integer> map = new HashMap<>();
        //hashMap + 一重循环
        for (int i = 0; i < nums.length; i++){
            int v = target - nums[i];
            if(map.get(v) != null){ //或者使用containsKey(v)
                return new int[] {map.get(v), i};
            }else {
                map.put(nums[i], i);
            }

        }
        throw new IllegalArgumentException("No such element");
    }
}
