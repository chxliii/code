package second_time;

import java.util.ArrayDeque;
import java.util.Deque;

public class trapping_rain_water {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trapping_water(nums));

    }

    //去掉头尾两根柱子，因为雨水不会在两端积蓄
    public static int trapping_water(int[] nums) {
        //暴力方法:对于每根有效的柱子遍历其左右的最大高度，找出其中的最小值，减去当前柱子的高度就是可以确定积水的高度
        //此暴力法是以高度为标准的
//        int ans = 0;
//        for (int i = 1; i < nums.length - 1; i++) {
//            int k = i, l = i;
//            int leftMax = 0, rightMax = 0;
//
//            while (k > 0) {
//                leftMax = Math.max(leftMax, nums[k]);
//                k--;
//            }
//
//            while (l < nums.length) {
//                rightMax = Math.max(rightMax, nums[l]);
//                l++;
//            }
//
//            ans += (Math.min(leftMax, rightMax) - nums[i]);
//        }
//
//        return ans;


//        //方法2：双指针思想，对于从左往右扫描的指针，可以确定左边的最大值，如果满足左边最大值小于当前所知的右边最大值，则此时的高度可以确定
//
//        int i = 1, j = nums.length - 2;
//        int leftMax = Math.max(nums[0], nums[i]);
//        int rightMax = Math.max(nums[nums.length - 1], nums[j]);
//        int ans = 0;
//
//        while (i <= j) {
//            if (leftMax < rightMax) {
//                ans += Math.max(leftMax - nums[i], 0);
//                i++;
//                leftMax = Math.max(leftMax, nums[i]);
//
//            } else {
//                ans += Math.max(rightMax - nums[j], 0);
//                j--;
//                rightMax = Math.max(rightMax, nums[j]);
//            }
//        }
//
//        return ans;


        //由于该问题具有最近相关性，因此也可以采用单调栈的方法

        int ans = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[i]) {
                //用于确定相邻的高度
                int topIndex = deque.peekFirst();
                deque.removeFirst();

                //为空时需要特殊处理
                if (deque.isEmpty()) {
                    break;
                }

                //此时可以确定此出栈索引位置的雨水情况
                //左边由于单调递减，因此左边最高高度可以确定，即栈底元素，由于右边此时的
                int boundedH = Math.min(nums[i], nums[deque.peekFirst()]) - nums[topIndex];

                ans += boundedH * (i - deque.peekFirst() - 1);
            }

            deque.addFirst(i);
        }

        return ans;
    }
}
