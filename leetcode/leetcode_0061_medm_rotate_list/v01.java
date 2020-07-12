package leetcode.leetcode_0061_medm_rotate_list;

public class v01 {
    static
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    static
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (k == 0){
                return head;
            }

            if (head == null || head.next == null){
                return head;
            }

            ListNode p = head;
            int len = 1;
            while (p.next != null){
                len += 1;
                p = p.next;
            }
            p.next = head;
            ListNode q = head;
            for (int i = 0; i < len - k % len - 1; ++i){
                q = q.next;
            }
            ListNode newHead = q.next;
            q.next = null;
            return newHead;
        }
    }
    
    public static void main(String[] argv){

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        var result = new Solution().rotateRight(head, 4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
    
}