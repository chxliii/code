import java.util.*;

public class threeSums {

    public static void main(String[] args) {
        int[] nums = {1, 0, -2, 1, 2, 5};

        List<List<Integer>> r = threeSum(nums);

        System.out.println(r);


    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

//        Arrays.sort(nums);
//        //1.暴力解法
//        Set<List<Integer>> result = new LinkedHashSet<>();
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if(nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> ele = Arrays.asList(nums[i], nums[j], nums[k]);
//                        result.add(ele);
//                    }
//                }
//            }
//        }
//
//        return new ArrayList<>(result);



        //hash + 两重循环 【也超时】

        //先确定c的值，三数相加，留两个位置给另外两个数
//        for (int i = 0; i < nums.length - 2; i++) {
//            int target = - nums[i];
//            Map<Integer, Integer> map = new HashMap<>();
//
//            for (int j = i + 1; j < nums.length - 1; j++){
//                int v = target - nums[j];
//                Integer exits = map.get(v);
//                if (exits != null) {
//                    List<Integer> ele = Arrays.asList(nums[i], nums[j], v);
//                    ele.sort(Comparator.naturalOrder());
//                    result.add(ele);
//                } else {
//                    map.put(nums[j], nums[j]);
//                }
//            }
//
//        }
//
//        return new ArrayList<>(result);

        //双指针实现

        //先排序，遍历c的值，再在另一个区间中移动双指针

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++){
            if (nums[k] > 0) {
                break;
            }

            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1, j = nums.length - 1;

            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                }else {
                    res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));

                    while (i < j && nums[i] == nums[++i]);

                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }

        return res;

    }
}

