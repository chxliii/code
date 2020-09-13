package second_time;


public class swap_nodes_in_pairs {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);


        ListNode second = new ListNode(2);
        head.next = second;

        ListNode third = new ListNode(3);
        second.next = third;

        ListNode fourth = new ListNode(4);
        third.next = fourth;

        ListNode fiveth = new ListNode(5);
        fourth.next = fiveth;

        ListNode node = swapPairs(head);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }

    public static ListNode swapPairs(ListNode head) {

        //递归方法

//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode firstNode = head;
//
//        ListNode secondNode = head.next;
//
//        //递归本身就相当于循环，只不过循环结束在递归调用方法中的结束条件
//
//        firstNode.next = swapPairs(secondNode.next);
//
//        secondNode.next = firstNode;
//
//        return secondNode;


        //迭代方法

        //哑节点主要用来记录头
        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        //prevNode记录记录下一对节点的头部
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
