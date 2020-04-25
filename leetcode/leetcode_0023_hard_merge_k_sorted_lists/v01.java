package leetcode.leetcode_0023_hard_merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < lists.length; ++i){
            if (lists[i] != null){
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }
        ListNode dummy_head = new ListNode(-1);
        ListNode dummy_tail = dummy_head;
        while(queue.size() != 0){
            ListNode t = queue.poll();
            if (t.next != null){
                queue.add(t.next);
            }
            dummy_tail.next = t;
            dummy_tail = dummy_tail.next;
        }
        return dummy_head.next;
    }
}

public class v01 {
    public static void main(String[] argv){
        Solution sl = new Solution();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        var result = sl.mergeKLists(new ListNode[]{l1, l2, l3});
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}