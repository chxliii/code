import java.util.HashMap;
import java.util.Map;

public class twoSums {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 7};
        twoSum(nums, 5);
    }

    public static int[] twoSum(int[] nums, int target) {
//        //两重暴力循环
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    int[] result = new int[2];
//                    result[0] = i;
//                    result[1] = j;
//
//                    System.out.print("i:"+i+ " "+"j:"+j);
//
//                    return result;
//                }
//            }
//        }
        //hash + 一重循环
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[] {map.get(component), i};
            }

            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
