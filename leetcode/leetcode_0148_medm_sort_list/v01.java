package leetcode.leetcode_0148_medm_sort_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }
            
            ListNode tail = head;
            while (tail.next!=null){
                tail = tail.next;
            }
            return mergeSort(head, tail);
        }

        private ListNode mergeSort(ListNode head, ListNode tail){
            if (head == tail){
                head.next = null;
                return head;
            }

            // partition into two split
            ListNode p1 = head;
            ListNode p2 = head;
            while (p2 != tail && p2.next != tail){
                p1 = p1.next;
                p2 = p2.next.next;
            }

            // sort the two split
            ListNode head1 = head;
            ListNode head2 = p1.next;
            ListNode tail1 = p1;
            ListNode tail2 = tail;

            ListNode result1 = mergeSort(head1, tail1);
            ListNode result2 = mergeSort(head2, tail2);

            // merge two sorted linkedlist
            ListNode dummyHead = new ListNode(-1);
            ListNode p = dummyHead;
            // while (result1 != p1 && result2 != tail){ // iterate until reach the tail of each linkedlist
            while (result1 != null && result2 != null){ // iterate until reach the tail of each linkedlist
                    if (result1.val < result2.val){
                    p.next = result1;
                    result1 = result1.next;
                }else{
                    p.next = result2;
                    result2 = result2.next;
                }
                p = p.next;
            }

            // append the remains
            while(result1 != null){
                p.next = result1;
                result1 = result1.next;
                p = p.next;
            }

            while(result2 != null){
                p.next = result2;
                result2 = result2.next;
                p = p.next;
            }

            return dummyHead.next;
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        // l1.next.next = new ListNode(6);
        // l1.next.next.next = new ListNode(1);
        // l1.next.next.next.next = new ListNode(8);
        // l1.next.next.next.next.next = new ListNode(7);
        // l1.next.next.next.next.next.next = new ListNode(2);
        // l1.next.next.next.next.next.next.next = new ListNode(4);
        Solution sl = new Solution();
        var result = sl.sortList(l1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}