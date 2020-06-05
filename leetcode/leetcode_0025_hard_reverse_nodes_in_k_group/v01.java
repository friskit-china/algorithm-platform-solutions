package leetcode.leetcode_0025_hard_reverse_nodes_in_k_group;



public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static 
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null){
                return null;
            }
            if(k == 1){
                return head;
            }

            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ResultPair rp = process(dummyHead, k);
            ListNode newHead = rp.first;
            dummyHead = rp.last;
            while(dummyHead.next != null){
                rp = process(dummyHead, k);
                dummyHead = rp.last;
            }
            return newHead;
        }

        public ResultPair process(ListNode dummyHead, int k){
            int counter = 0;
            ListNode last = dummyHead;
            while(last.next != null && counter < k){
                last = last.next;
                counter += 1;
            }
            if (counter < k){
                return new ResultPair(dummyHead.next, last);
            }else{
                ListNode p = dummyHead.next;
                ListNode q = p.next;
                ListNode r = q.next;

                while (p != last){
                    q.next = p;
                    p = q;
                    q = r;
                    if(r == null){
                        break;
                    }
                    r = r.next;
                }
                last = dummyHead.next;
                dummyHead.next.next = q;
                dummyHead.next = p;
            }
            return new ResultPair(dummyHead.next, last);
        }

        public class ResultPair{
            private ListNode first;
            private ListNode last;
            public ResultPair(ListNode first, ListNode last){
                this.first = first;
                this.last = last;
            }
            public ListNode getFirst(){
                return this.first;
            }
            public ListNode getLast(){
                return this.last;
            }
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);
        l1.next.next.next.next.next = new ListNode(6);
        l1.next.next.next.next.next.next = new ListNode(7);
        Solution sl = new Solution();
        var result = sl.reverseKGroup(l1, 1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
    
}