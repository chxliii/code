package second_time;

class ListNode {
    int val;
    ListNode next;

    public ListNode (int e) {
        val = e;
        next = null;
    }
}

public class reverseList {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = head;
        ListNode second = new ListNode(2);
        head.next = second;
        ListNode third = new ListNode(3);
        second.next = third;

        while (tail != null) {
            System.out.print(tail.val + " ");
            tail = tail.next;
        }

        ListNode newH = reverse(head);
        //System.out.println(newH.next.next.next);
        while (newH != null) {
            System.out.print(newH.val + " ");
            newH = newH.next;
        }
    }


    public static ListNode reverse(ListNode head) {

        //迭代循环方法
        /*
        ListNode pre = null;

        ListNode curr = head;

        //交换方式进行reverse
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr= tmp;
        }

        return pre;
        */

        //递归方法
        //递归出口
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverse(head.next);

        //p为最后一个节点
        head.next.next = head; //这句话很重要就是把一个节点的前面一个节点变成该节点的后一个节点
        head.next = null;

        return p;

    }
}

