package leetcode.leetcode_0021_easy_merge_two_sorted_lists;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode tail = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                tail.next = l1;
                tail = tail.next;
                l1 = l1.next;
            }else{
                tail.next = l2;
                tail = tail.next;
                l2 = l2.next;
            }
        }

        if (l1 == null){
            tail.next = l2;
        }else{
            tail.next = l1;
        }
        return head.next;
    }
}

public class v01 {
    public static void main(String[] argv){

        // Solution sl = new Solution();
        // ListNode l1 = new ListNode(1);
        // l1.next = new ListNode(2);
        // l1.next.next = new ListNode(4);

        // ListNode l2 = new ListNode(1);
        // l2.next = new ListNode(3);
        // l2.next.next = new ListNode(4);
        // l2.next.next.next = new ListNode(5);

        Solution sl = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = null;

        ListNode result = sl.mergeTwoLists(l1, l2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}