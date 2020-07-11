package leetcode.leetcode_0206_easy_reverse_linked_list;

public class v01 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null){
                return null;
            }else if(head.next == null){
                return head;
            }

            ListNode p = null;
            ListNode q = head;
            ListNode r = head.next;
            
            while(true){
                q.next = p;
                p = q;
                q = r;
                if (r == null){
                    return p;
                }else{
                    r = r.next;
                }
            }
        }
    }

    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        
        ListNode result = new Solution().reverseList(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}