package leetcode.leetcode_0237_easy_delete_node_in_a_linked_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public void deleteNode(ListNode node) {
            if (node == null){
                return;
            }
            
            while (node.next != null){
                node.val = node.next.val;
                if (node.next.next == null){
                    node.next = null;
                    return;
                }
                node = node.next;
            }
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(8);
        // l1.next.next.next.next.next = new ListNode(7);
        // l1.next.next.next.next.next.next = new ListNode(2);
        // l1.next.next.next.next.next.next.next = new ListNode(4);
        Solution sl = new Solution();
        sl.deleteNode(l1.next.next.next);
        while (l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
    
}