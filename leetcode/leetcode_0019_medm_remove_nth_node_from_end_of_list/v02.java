package leetcode.leetcode_0019_medm_remove_nth_node_from_end_of_list;

public class v02 {
    static
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null || head.next == null){
                return null;
            }
    
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = dummyHead;
            for (int i = 0; i < n; ++i){
                p = p.next;
            }

            ListNode q = dummyHead;
            while (p.next != null){
                q = q.next;
                p = p.next;
            }
            q.next = q.next.next;
            return dummyHead.next;
        }
    }

    public static void main(String[] argv){

        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        var result = new Solution().removeNthFromEnd(head, 1);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }

}