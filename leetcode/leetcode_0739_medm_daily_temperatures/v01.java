package leetcode.leetcode_0739_medm_daily_temperatures;

public class v01 {
    static
    class Solution {
        public int[] dailyTemperatures(int[] T) {
            if (T.length == 1){
                return new int[]{0};
            }
            int result[] = new int[T.length];

            Stack stack = new Stack();
            stack.push(0);
            for (int i = 1; i < T.length; ++i){
                while (stack.length != 0 && T[i] > T[stack.probe().val]){
                    LinkNode t = stack.pop();
                    result[t.val] = i - t.val;
                }
                stack.push(i);
            }
            while(stack.length != 0){
                LinkNode t = stack.pop();
                result[t.val] = 0;
            }
            return result;
        }
        static class LinkNode{
            public int val;
            public LinkNode next;
            public LinkNode(int val){
                this.val = val;
                this.next = null;
            }
        }

        static class Stack{
            private LinkNode top;
            public int length;
            public Stack(){
                this.top = new LinkNode(-1);
                this.length = 0;
            }

            public LinkNode push(int val){
                LinkNode newNode = new LinkNode(val);
                newNode.next = this.top.next;
                this.top.next = newNode;
                this.length += 1;
                return newNode;
            }

            public LinkNode pop(){
                if (this.length == 0){
                    return null;
                }
                LinkNode topNode = this.top.next;
                this.top.next = topNode.next;
                topNode.next = null;
                this.length -= 1;
                return topNode;
            }

            public LinkNode probe(){
                if (this.length == 0){
                    return null;
                }
                return this.top.next;
            }
        }

    }

    public static void main(String[] argv){
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution sl = new Solution();
        int[] result = sl.dailyTemperatures(temperatures);
        for (int i = 0; i < result.length; ++i){
            System.out.println(result[i]);
        }
    }
}