public class swap_nodes_in_pairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }

    //递归法
//    public ListNode swapPairs(ListNode head) {
//        //如果节点数小于等于1个
//
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode firstNode  = head;
//        ListNode secondNode = head.next;
//
//        firstNode.next = swapPairs(secondNode.next);
//        secondNode.next = firstNode;
//
//        return secondNode;
//    }

    //迭代法
    public ListNode swapPairs(ListNode head) {
        // f    s
        // 1 -> 2  -> 3 -> 4 -> 5
        //head

        //把链表分为两部分，奇数位置集合的所有节点A，偶数位置集合达所有节点B

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode prevNode = dummy;

        while (head != null && head.next != null) {
            ListNode firstNode = head;

            ListNode secondNode = head.next;

            prevNode.next = secondNode;

            firstNode.next = secondNode.next;

            secondNode.next = firstNode;

            prevNode = firstNode;

            head = firstNode.next;
        }

        return dummy.next;

    }


}
