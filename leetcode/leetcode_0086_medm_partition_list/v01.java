package leetcode.leetcode_0086_medm_partition_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummyHeadA = new ListNode(-1);
            ListNode dummyHeadB = new ListNode(-1);
            ListNode tailA = dummyHeadA;
            ListNode tailB = dummyHeadB;
            while (head != null){
                if (head.val < x){
                    tailA.next = head;
                    tailA = tailA.next;
                }else{
                    tailB.next = head;
                    tailB = tailB.next;
                }
                head = head.next;
            }
            tailA.next = dummyHeadB.next;
            tailB.next = null;
            return dummyHeadA.next;
        }
    }

    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

        ListNode result = new Solution().partition(node, 3);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}