/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null){
            return null;
        }

        ListNode q = head;
        while (n + 1 != 0){
            q = q.next;
            n -= 1;
            if(q == null){
                if (n == 0){
                    head = head.next;
                    return head;
                }else if(n == -1){
                    head.next = head.next.next;
                    return head;
                }
            }
        }
        ListNode p = head;
        while (q != null){
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.println(sl.removeNthFromEnd(head, 2)); // 1->2->3->5

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // System.out.println(sl.removeNthFromEnd(head, 1)); // 1->2->3->4

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // System.out.println(sl.removeNthFromEnd(head, 5)); // 2->3->4->5

        // ListNode head = new ListNode(1);
        // System.out.println(sl.removeNthFromEnd(head, 1)); // null?

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // System.out.println(sl.removeNthFromEnd(head, 2)); // 2

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // System.out.println(sl.removeNthFromEnd(head, 1)); // 1

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // System.out.println(sl.removeNthFromEnd(head, 1)); // 1->2

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // System.out.println(sl.removeNthFromEnd(head, 2)); // 1->3

        // ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // System.out.println(sl.removeNthFromEnd(head, 3)); // 2->3
        
    }

}