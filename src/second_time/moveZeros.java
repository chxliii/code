package second_time;

public class moveZeros {

    //对于[1,0,8,4,0,2],所有的0移动到左边

    //思路：遍历数组元素，用指针j指向下一个放置非0元素的位置

    public static void main(String[] args) {
        int[] a = new int[]{1, 0, 8, 4, 0, 2};

        int[] nums = moveZero(a);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
    }

    public static int[] moveZero(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }

        return nums;
    }
}
