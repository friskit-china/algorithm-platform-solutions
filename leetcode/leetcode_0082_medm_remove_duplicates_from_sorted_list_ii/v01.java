package leetcode.leetcode_0082_medm_remove_duplicates_from_sorted_list_ii;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        
    }

    static
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            
            ListNode p = dummyHead;
            ListNode q = p.next;
            boolean moved = false;
            while (q != null){
                moved = false;
                while(q.next != null && p.next.val == q.next.val){
                    moved = true;
                    q = q.next;
                }
                if (moved == true){
                    p.next = q.next;
                    q = p.next;
                }else{
                    p = q;
                    q = q.next;
                }
            }
            return dummyHead.next;
        }
    }

    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        ListNode result = new Solution().deleteDuplicates(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}