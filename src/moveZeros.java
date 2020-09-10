public class moveZeros {
    /*
     *@Author chxliii
     *@Description 关键思想：将非0元素移动到数组前面，定义一个j索引，指向下一个放置非0元素的索引位置；
     * 每次非0元素交换到j位置后，移动到下个遍历的元素和j的位置。
     *@Date 15:25 2020-09-07
     *@Param [args]
     *@Return void
     **/
    public static void main(String[] args) {
        int[] a = {3, 4, 1, 0, 7, 0, 9};
        //         0  1  2  3  4  5  6
        move0(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
        }
    }

    public static int[] move0(int[] a) {
        int length = a.length;
        //指向非0元素的索引
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (a[i] != 0) {
                a[j] = a[i];

                //i处非0元素移动到j处后，i处就应该变为0
                if (i != j) {
                    a[i] = 0;
                }
                j++;
            }
        }
        return a;
    }
}
