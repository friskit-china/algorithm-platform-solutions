package leetcode.leetcode_0147_medm_insertion_sort_list;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null){
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode nextStart = dummyHead.next.next;
            ListNode tail = dummyHead.next;
            while (nextStart != null){
                ListNode current = nextStart;
                nextStart = nextStart.next;

                ListNode p = dummyHead;
                while(p.next != nextStart && p.next.val < current.val){
                    p = p.next;
                }

                if (p.next == current){
                    tail = tail.next;
                }else{
                    current.next = p.next;
                    p.next = current;
                    tail.next = nextStart;
                }
            }

            return dummyHead.next;
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(5);
        l1.next = new ListNode(7);
        l1.next.next = new ListNode(6);
        l1.next.next.next = new ListNode(1);
        l1.next.next.next.next = new ListNode(8);
        l1.next.next.next.next.next = new ListNode(7);
        l1.next.next.next.next.next.next = new ListNode(2);
        l1.next.next.next.next.next.next.next = new ListNode(4);
        Solution sl = new Solution();
        var result = sl.insertionSortList(l1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}