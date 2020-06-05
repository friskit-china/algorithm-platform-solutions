package leetcode.leetcode_0239_hard_sliding_window_maximum;

public class v01 {
    static
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (k == 1){
                return nums;
            }
            Q queue = new Q();
            int[] resultArray = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; ++i){
                putPosition(queue, nums, i, k);
                if (i >= k - 1){
                    resultArray[i - k + 1] = nums[queue.getFirst().val];
                }
            }
            return resultArray;
        }

        private void putPosition(Q queue, int[] nums, int position, int k){
            while(queue.length != 0 && nums[queue.getLast().val] < nums[position]){
                queue.removeLast();
            }
            
            queue.pushLast(position);
            if (queue.length != 0 && queue.getFirst().val < position - k + 1){
                queue.removeFirst();
            }
            
        }

        static class ListNode{
            public int val;
            public ListNode next;
            public ListNode prev;
            public ListNode(int val){
                this.val = val;
                this.next = null;
                this.prev = null;
            }
        }
        static class Q{
            private ListNode dummyHead;
            private ListNode dummyTail;
            public int length;
            public Q(){
                this.dummyHead = new ListNode(-1);
                this.dummyTail = new ListNode(-1);
                this.dummyHead.next = this.dummyTail;
                this.dummyTail.prev = this.dummyHead;
                this.length = 0;
            }

            public ListNode getFirst(){
                if (this.length == 0){
                    return null;
                }
                return this.dummyHead.next;
            }

            public ListNode getLast(){
                if (this.length == 0){
                    return null;
                }
                return this.dummyTail.prev;
            }

            public ListNode pushFirst(int val){
                ListNode newNode = new ListNode(val);
                newNode.prev = this.dummyHead;
                newNode.next = this.dummyHead.next;
                this.dummyHead.next = newNode;
                this.dummyHead.next.prev = newNode;
                this.length += 1;
                return newNode;
            }

            public ListNode pushLast(int val){
                ListNode newNode = new ListNode(val);
                newNode.next = this.dummyTail;
                newNode.prev = this.dummyTail.prev;
                this.dummyTail.prev.next = newNode;
                this.dummyTail.prev = newNode;
                this.length += 1;
                return newNode;
            }

            public ListNode removeFirst(){
                ListNode first = this.dummyHead.next;
                this.dummyHead.next.next.prev = this.dummyHead;
                this.dummyHead.next = this.dummyHead.next.next;
                first.next = null;
                first.prev = null;
                this.length -= 1;
                return first;
            }

            public ListNode removeLast(){
                ListNode last = this.dummyTail.prev;
                this.dummyTail.prev.prev.next = this.dummyTail;
                this.dummyTail.prev = this.dummyTail.prev.prev;
                last.next = null;
                last.prev = null;
                this.length -= 1;
                return last;
            }
        }
    }

    public static void main(String[] argv){
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7}; // 3 3 5 5 6 7
        int[] nums = {1, 3, -1, -3, 2, 3, 6, 7}; // 3 3 2 3 6 7
        int k = 3;
        Solution sl = new Solution();
        int[] result = sl.maxSlidingWindow(nums, k);
        for (int i = 0; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
}