package second_time;

public class linked_list_cycle1 {

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

        System.out.println(detectCycle(head));

    }

    public static boolean detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null || second.next != null) {
            if (second == first) {
                return true;
            }

            first = first.next;
            second = second.next.next;
        }

        return false;
    }
}
