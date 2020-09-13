public class reverse_nodes_in_k_groups {
    class ListNode {
        int val;
        ListNode next;

        ListNode (int e) {
            val = e;
            next = null;
        }
    }

    //递归方法
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        //如果链表数量不够k，则直接返回
        while (count < k) {
            if (curr == null) return head;
            curr = curr.next;
            count ++;
        }

        //此时curr指向下一个k组的头节点

        //p指向子问题的连接情况
        ListNode p = reverseKGroup(curr, k);

        while (count > 0){
            ListNode next = head.next;
            head.next = p;
            p = head;
            head = next;
            count--;
        }

        return p;
    }
}
