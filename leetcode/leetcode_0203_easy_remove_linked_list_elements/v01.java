package leetcode.leetcode_0203_easy_remove_linked_list_elements;


public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode p = dummyHead;
            while (p.next != null){
                if (p.next.val == val){
                    p.next = p.next.next;
                }else{
                    p = p.next;
                }
            }
            return dummyHead.next;
        }
    }



    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(6);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next.next = new ListNode(6);
        
        ListNode result = new Solution().removeElements(node, 1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}