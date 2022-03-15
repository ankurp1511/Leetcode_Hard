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

        PriorityQueue<ListNode> mh = createMinHeap(lists);

        while (!mh.isEmpty()) {
            ListNode node = mh.poll();

            sTail.next = node;
            sTail = node;

            if (node.next != null) {
                mh.add(node.next);
            }
        }

        ListNode temp = sHead.next;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    private static PriorityQueue<ListNode> createMinHeap(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);

        for (ListNode list: lists) {
            if (list != null) {
                minHeap.add(list);
            }
        }
        return minHeap;
    }
}
