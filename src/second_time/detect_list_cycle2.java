package second_time;

public class detect_list_cycle2 {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6};

        ListNode dummy = new ListNode(-1);

        ListNode rear = dummy;

        ListNode tag = null;

        for (int i = 0; i < nums.length; i++) {
            ListNode s = new ListNode(nums[i]);

            rear.next = s;

            rear = s;


            if (i == 2) {
                tag = s;
            }

        }

        rear.next = tag;
        ListNode head = dummy.next;

        System.out.println(detectAndFindEnterNode(head).val);

    }

    public static ListNode detectAndFindEnterNode(ListNode head) {
        //首先找到环中的相遇节点
        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head;

        ListNode second = head.next;


        while (first != second) {
            if (second == null || second.next == null) {
                //相等说明找到相遇节点
                return null;
            }

            first = first.next;

            second = second.next.next;

            if (first ==  second) {
                return second;
            }
        }


        second = head;

        while (second != first) {
            second = second.next;
            first = first.next;
        }

        return first;
    }
}
