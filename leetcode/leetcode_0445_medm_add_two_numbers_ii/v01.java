package leetcode.leetcode_0445_medm_add_two_numbers_ii;

public class v01 {
    static
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int l1_length = 0;
            ListNode head_1 = l1;
            while(head_1 != null){
                l1_length += 1;
                head_1 = head_1.next;
            }

            int l2_length = 0;
            ListNode head_2 = l2;
            while(head_2 != null){
                l2_length += 1;
                head_2 = head_2.next;
            }

            // make l1 is the longer linked list
            if (l1_length < l2_length){
                int t = l1_length;
                l1_length = l2_length;
                l2_length = t;

                head_1 = l2;
                head_2 = l1;
            }else{
                head_1 = l1;
                head_2 = l2;
            }

            ListNode resultDummyHead = new ListNode(-1);

            for (int i = 0; i < l1_length - l2_length; ++i){
                ListNode newNode = new ListNode(head_1.val);
                newNode.next = resultDummyHead.next;
                resultDummyHead.next = newNode;
                head_1 = head_1.next;
            }

            while(head_1 != null){
                ListNode newNode= new ListNode(head_1.val + head_2.val);
                newNode.next = resultDummyHead.next;
                resultDummyHead.next = newNode;
                head_1 = head_1.next;
                head_2 = head_2.next;
            }

            ListNode newResultDummyHead = new ListNode(-1);
            resultDummyHead = resultDummyHead.next;
            int addition = 0;
            while (resultDummyHead != null){
                int val = (resultDummyHead.val + addition) % 10;
                addition = (resultDummyHead.val + addition) / 10;
                ListNode newNode = new ListNode(val);
                newNode.next = newResultDummyHead.next;
                newResultDummyHead.next = newNode;
                resultDummyHead = resultDummyHead.next;
            }

            if (addition != 0){
                ListNode newNode = new ListNode(addition);
                newNode.next = newResultDummyHead.next;
                newResultDummyHead.next = newNode;
            }
            return newResultDummyHead.next;
        }
    }

    public static void main(String[] argv){
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(6);
        l2.next.next.next = new ListNode(4);

        ListNode result = new Solution().addTwoNumbers(l1, l2);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}