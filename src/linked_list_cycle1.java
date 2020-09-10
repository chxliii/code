public class linked_list_cycle1 {

    class ListNode {
        int val;
        ListNode next;

        ListNode (int e) {
            val = e;
            next = null;
        }
    }

    //快慢指针法
    public boolean hasCycle(ListNode head) {
        //列表有环至少有两个节点
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;

        ListNode fast = head.next;
        while (slow != fast) {
            //如果没有环，则fast先到底终点
            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
