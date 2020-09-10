public class linked_list_cycle2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode (int e) {
            val = e;
            next = null;
        }
    }

    public ListNode detectCycle (ListNode head) {
        ListNode slow = head, fast = head;

        while (true) {
            //快指针走到头还没相遇或者只有0个或1个节点
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        //有环才会执行下面代码
        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
