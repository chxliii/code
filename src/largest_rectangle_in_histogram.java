import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Scanner;

public class largest_rectangle_in_histogram {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String nums = input.nextLine();

        String[] tmp = nums.split(" ");

        int[] arr = new int[tmp.length];

        for (int i = 0; i < tmp.length; i++) {
            arr[i] = Integer.valueOf(tmp[i]);
        }

        System.out.println(findMaxArea(arr));
    }

    public static int findMaxArea(int[] nums) {

        //终极暴力法：三重循环
        //思想，i,j定义左右边界，然后再遍历i，j中最小的高度作为高度
//
//        int maxArea = 0;
//
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int height = Integer.MAX_VALUE;
//
//                for (int k = i; k <= j; k++){
//
//                    height = Math.min(height, nums[k]);
//                }
//                maxArea = Math.max(maxArea, height * (j - i +1));
//            }
//        }
//
//        return maxArea;

        /******************************/
        //法2：两重暴力循环，只需要遍历每个矩形高度，计算此举行高度的最大面积

        //遍历不同高度时的面积，找最大
//        int maxArea = 0;
//        for (int i = 0; i < nums.length; i++) {
//
//
//            int k = i, l = i;
//            while (k > 0 && nums[k-1] >= nums[i]){
//                k--;
//            }
//
//            while (l < nums.length - 1 && nums[l+1] >= nums[i]){
//                l++;
//            }
//
//            maxArea = Math.max(maxArea, nums[i] * (l - k + 1));
//
//        }
//
//        return maxArea;


        /***************************/
//        // 法3：两重暴力循环，采取的是采用双指针，维护每次移动的最小高度
//        int maxArea = 0;
//        for (int i = 0; i < nums.length; i++) {
//            //由于可以求单个小矩形面积，所以可以重合
//            int minHeight = Integer.MAX_VALUE;
//
//            for (int j = i; j < nums.length; j++) {
//                //每次移动j指针的时候，更新最小高度
//                minHeight = Math.min(minHeight, nums[j]);
//
//                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
//
//            }
//        }
//
//        return maxArea;


        /******************************/

        //法4：终极优化，采用栈的思想，维护一个有序栈，由于在两重暴力循环的时候，其实在找最小高度时有重复的动作，因此可以进一步优化
        //维护一个栈，从小到大进行排练，这样就可以快速知道左边界在哪
        //重点思想：如6，7，5，2，4，5，9，3 当6入栈，7入栈时比6大，说明6的右边界还不知道在哪，因此继续做入栈操作，直到找到一个小的值就说明
        //6的右边界找到了，又由于7左边的数比7小，所以可以确定当前7为高度矩形面积。


        Deque<Integer> stack = new ArrayDeque<>();
        stack.addFirst(-1);
        int maxArea = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++) {
            //失败代码
//            //入栈元素大于栈顶元素，则可以入栈
//            if(stack.peekFirst() <= nums[i]) {
//                stack.addFirst(i);
//            }else {
//                //说明入栈元素小于栈顶元素，此时栈顶元素需要出栈;但出栈后该元素还是要入栈
//                if (!stack.isEmpty()) {
//                    int peekEleIndex = stack.removeFirst();
//                    int left_bound = stack.peekFirst();
//                    maxArea = Math.max(maxArea, nums[peekEleIndex] * (i - left_bound - 1));
//                }
//            }

            //正确代码
            //应当主动拿栈顶元素(先做)和要加入的元素比较

            while (stack.peekFirst()!= - 1 && nums[stack.peekFirst()] >= nums[i]) {
                //非只有一个元素，且栈顶元素的值大于要入栈的元素，说明要出栈
                maxArea = Math.max(maxArea, nums[stack.removeFirst()] * (i - stack.peekFirst() - 1));
            }
            stack.addFirst(i);
        }

        //可能栈中还有剩余元素,剩余元素每出栈一个，宽度可以增加一个
        while (stack.peekFirst() != -1) {

            maxArea = Math.max(maxArea, nums[stack.removeFirst()] * (n - stack.peekFirst() - 1));

        }

        return maxArea;
    }
}
