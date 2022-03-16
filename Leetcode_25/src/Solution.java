public class Solution {

    private static ListNode root1;

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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        root1 = node1;

        ListNode n1 = root1, n2 = root1;
        ListNode next;
        int count = 0;
        int k = 2;

        while (n2 != null) {
            next = n2.next;
            count++;

            if (count == k) {
                n2.next = null;
                ListNode[] rev = reverse(n1);
                sTail.next = rev[0];
                sTail = rev[1];
                n1 = next;
                count = 0;
            }
            n2 = next;
        }
        sTail.next = n1;

        ListNode temp1 = sHead.next;

        while (temp1 != null) {
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }

    }

    private static ListNode[] reverse (ListNode n1) {

        ListNode rHead = null;
        ListNode rTail = null;

        while (n1 != null) {
            ListNode next = n1.next;
            n1.next = rHead;
            rHead = n1;
            n1 = next;

            if (rTail == null) {
                rTail = rHead;
            }
        }

        return new ListNode[]{rHead, rTail};
    }
}
