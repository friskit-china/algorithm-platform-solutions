package leetcode.leetcode_0243_easy_palindrome_linked_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (head == null){
                return true;
            }

            if (head.next == null){
                return true;
            }

            if (head.next.next == null){
                return head.val == head.next.val;
            }

            ListNode p = head;
            ListNode q = head;

            while (q.next != null && q.next.next != null){
                p = p.next;
                q = q.next.next;
            }

            // reverse linkedlist 2
            ListNode prev = null;
            ListNode cur = p.next;
            ListNode next = cur.next;

            while (next != null){
                cur.next = prev;
                prev = cur;
                cur = next;
                next = next.next;
            }
            cur.next = prev;
            ListNode head1 = head;
            ListNode head2 = cur;

            while (head2 != null){
                if (head1.val != head2.val){
                    return false;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            return true;
        }
    }


    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);
        // l1.next.next.next.next = new ListNode(2);
        // l1.next.next.next.next.next = new ListNode(1);
        // l1.next.next.next.next.next.next = new ListNode(0);
        // l1.next.next.next.next.next.next.next = new ListNode(4);
        System.out.println(new Solution().isPalindrome(l1));
    }
    
}