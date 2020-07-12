package leetcode.leetcode_0143_medm_reorder_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null){
                return;
            }
            
            ListNode p = head;
            ListNode q = head;
            while (q.next != null && q.next.next != null){
                p = p.next;
                q = q.next.next;
            }

            ListNode head1 = head;
            ListNode head2 = p.next;
            p.next = null;

            // reverse linkedlist 2
            ListNode prev = null;
            ListNode cur = head2;
            ListNode next = cur.next;
            while (cur.next != null){
                cur.next = prev;
                prev = cur;
                cur = next;
                next = next.next;
            }
            cur.next = prev;
            head2 = cur;

            // merge two linkedlist
            p = head1;
            q = head2;
            ListNode dummyHead = new ListNode(-1);
            ListNode current = dummyHead;
            int counter = 0;
            while(p != null || q != null){
                if (counter % 2 == 0){
                    current.next = p;
                    p = p.next;
                }else{
                    current.next = q;
                    q = q.next;
                }
                current = current.next;
                counter += 1;
            }
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(0);
        // l1.next = new ListNode(1);
        // l1.next.next = new ListNode(2);
        // l1.next.next.next = new ListNode(3);
        // l1.next.next.next.next = new ListNode(4);
        // l1.next.next.next.next.next = new ListNode(7);
        // l1.next.next.next.next.next.next = new ListNode(2);
        // l1.next.next.next.next.next.next.next = new ListNode(4);
        Solution sl = new Solution();
        sl.reorderList(l1);
        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
    
}