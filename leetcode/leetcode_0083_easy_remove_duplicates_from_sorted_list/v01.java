package leetcode.leetcode_0083_easy_remove_duplicates_from_sorted_list;

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
            if (head == null){
                return null;
            }else if(head.next == null){
                return head;
            }
            ListNode p = head;
            do{
                if (p.next.val == p.val){
                    p.next = p.next.next;
                }else{
                    p = p.next;
                }
            }while(p.next != null);

            return head;
        }
    }

    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        ListNode result = new Solution().deleteDuplicates(node);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}