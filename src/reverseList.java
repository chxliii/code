public class reverseList {
    class ListNode {
        int data;
        ListNode next;

        ListNode (int e) {
            this.data = e;
        }
    }



    public ListNode reverseList(ListNode head) {
        //循环替换
        // ListNode prev = null;
        // ListNode curr = head;
        // while(curr != null){
        //     ListNode tmp = curr.next;
        //     curr.next = prev;
        //     prev = curr;
        //     curr = tmp;
        // }

        // return prev;



        //递归！！！非常重要练习10遍！
        //如果有0个或1个节点
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
