package leetcode.leetcode_0024_medm_swap_nodes_in_pairs;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        boolean first = true;

        ListNode new_dummy_head = new ListNode(-1);
        ListNode dummy_tail = new ListNode(-1);
        new_dummy_head.next = head;
        ListNode dummy_head = new ListNode(-1);
        if (head == null || head.next == null){
            return head;
        }
        while (new_dummy_head.next != null){
            if (new_dummy_head.next.next == null){
                return head;
            }
            dummy_head.next = new_dummy_head.next;
            new_dummy_head.next = new_dummy_head.next.next.next;
            if(first){
                head = dummy_head.next.next;
                first = false;
            }else{
                dummy_tail.next.next = dummy_head.next.next;
            }
            dummy_head.next.next.next = dummy_head.next;
            dummy_head.next.next = new_dummy_head.next;
            dummy_tail.next = dummy_head.next;

        }
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
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        var result = sl.swapPairs(head);
        while (result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}