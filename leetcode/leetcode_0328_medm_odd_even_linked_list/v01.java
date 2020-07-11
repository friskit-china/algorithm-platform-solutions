package leetcode.leetcode_0328_medm_odd_even_linked_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null || head.next.next == null){
                return head;
            }
            ListNode p = head;
            ListNode q = head.next;
            ListNode q_head = head.next;
            while (true){
                p.next = p.next.next;
                p = p.next;
                if (p.next == null){
                    q.next = null;
                    break;
                }
                q.next = q.next.next;
                q = q.next;
                if (q.next == null){
                    p.next = null;
                    break;
                }
            }
            p.next = q_head;
            return head;
        }
    }
    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        
        ListNode result = new Solution().oddEvenList(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}