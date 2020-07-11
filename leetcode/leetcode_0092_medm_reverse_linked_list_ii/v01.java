package leetcode.leetcode_0092_medm_reverse_linked_list_ii;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null){
                return null;
            }else if(head.next == null){
                return head;
            }else if(m == n){
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;

            ListNode nh = dummyHead;
            for (int i = 0; i < m - 1; ++i){
                nh = nh.next;
            }

            ListNode pre = nh.next;
            ListNode cur = nh.next.next;
            ListNode nxt = nh.next.next.next;

            for (int i = 0; i < n - m; ++i){
                cur.next = pre;
                pre = cur;
                cur = nxt;
                nxt = nxt != null? nxt.next: null;
            }

            nh.next.next = cur;
            nh.next = pre;



            return dummyHead.next;
        }
    }

    public static void main(String[] argv){
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode result = new Solution().reverseBetween(node, 1, 2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    


}