import java.util.PriorityQueue;

public class Solution {

    private static ListNode root1;
    private static ListNode root2;
    private static ListNode root3;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        ListNode sHead = new ListNode(), sTail = sHead;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        root1 = node1;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        root2 = node4;

        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        node7.next = node8;
        root3 = node7;

        ListNode[] lists = new ListNode[]{root3, root1, root2};

        ListNode temp1 = mergeKLists(lists);

        ListNode temp = temp1;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }



    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode sHead = new ListNode();
        ListNode sTail = sHead;
        ListNode temp1;
        ListNode temp2;

        if (lists.length == 0 || (lists.length == 1 && lists[0] == null)) {
            return sHead.next;
        }

        temp1 = lists[0];
        for (int i = 1; i< lists.length; i++) {

            temp2 = lists[i];

            while (temp1 != null && temp2 != null) {

                if (temp1.val <= temp2.val) {
                    sTail.next = temp1;
                    sTail = temp1;
                    temp1 = temp1.next;
                } else {
                    sTail.next = temp2;
                    sTail = temp2;
                    temp2 = temp2.next;
                }
            }

            if (temp1 == null) {
                sTail.next = temp2;
            } else {
                sTail.next = temp1;
            }

            temp1 = sHead.next;
            sHead = new ListNode();
            sTail = sHead;
        }
        return temp1;
    }
}
