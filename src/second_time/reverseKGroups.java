package second_time;

public class reverseKGroups {

    public static void main(String[] args) {

        //一次reverseK函数则排好一段，则需要调用n/k次，同时每次需要调整k个位置，大概复杂度为o(n)
        //空间复杂度o(n/k).
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 12};

        ListNode head = new ListNode(-1);
        ListNode rear = head;

        for (int i = 0; i < arr.length; i++) {
            ListNode s = new ListNode(arr[i]);

            rear.next = s;

            rear = rear.next;
        }

        head = head.next;

//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

        ListNode h = reverseKGroup(head, 2);

        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head;

        int count = 0;

        //找到下一段的首位置
        while (count < k) {
            //也是递归的结束条件之一
            if (curr == null) {
                return head;
            }
            count++;
            curr = curr.next;

        }

        ListNode p = reverseKGroup(curr, k);

        //找到了后面子问题的答案后，再调整前一段部分中的节点指向
        while (count > 0) {
            ListNode node = head.next;
            head.next = p;
            p = head;
            head = node;
            count--;
        }

        //return head; 错误
        //p返回始终要求的reverse序列
        return p;
    }

    //递归总结：主要是写对结束递归的条件！！！非常重要，可能有多个出口
    //简单的验证方法是：看最外层的行为动作是否符合要求的形式。如果符合，则在写对递归退出条件情况下，代码一定是正确的！！！
    //如本题中，正确的循环调整前三个节点和p之间指向
}
