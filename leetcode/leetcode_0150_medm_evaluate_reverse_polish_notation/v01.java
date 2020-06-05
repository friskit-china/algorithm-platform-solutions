package leetcode.leetcode_0150_medm_evaluate_reverse_polish_notation;

public class v01 {
    static
    class Solution {
        public int evalRPN(String[] tokens) {
            // if (tokens.length == 0){
            //     return 0;
            // }
            // if (tokens.length == 1){
            //     return atoi(tokens[0]);
            // }
            Stack<Integer> valueStack = new Stack<Integer>();
            for (int i = 0; i < tokens.length; ++i){
                String token = tokens[i];
                if (isOperator(token)){
                    int val2 = valueStack.pop().val;
                    int val1 = valueStack.pop().val;
                    if (token.equals("+")){
                        valueStack.push(val1 + val2);
                    }else if(token.equals("-")){
                        valueStack.push(val1 - val2);
                    }else if(token.equals("*")){
                        valueStack.push(val1 * val2);
                    }else if(token.equals("/")){
                        valueStack.push(val1 / val2);
                    }
                }else{
                    valueStack.push(atoi(token));
                }
            }
            return valueStack.pop().val;
        }

        public static boolean isOperator(String token){
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                return true;
            }else{
                return false;
            }
        }

        public static int atoi(String token){
            int val = 0;
            boolean isMinus = false;
            char[] charArr = token.toCharArray();
            for (int i = 0; i < charArr.length; ++i){
                if (charArr[i] == '-'){
                    isMinus = true;
                    continue;
                }
                val = val * 10 + charArr[i] - '0';
            }

            if (isMinus){
                return -val;
            }else{
                return val;
            }
        }

        static
        public class LinkNode<T>{
            private LinkNode<T> next;
            public T val;
            public LinkNode(T val){
                this.next = null;
                this.val = val;
            }
        }

        static
        public class Stack<T>{
            private LinkNode<T> head;
            private int length;
            public Stack(){
                this.length = 0;
                this.head = new LinkNode<T>(null);
            }

            public LinkNode<T> push(T val){
                LinkNode<T> node = new LinkNode<T>(val);
                node.next = head.next;
                head.next = node;
                this.length += 1;
                return node;
            }

            public LinkNode<T> pop(){
                LinkNode<T> node = this.head.next;
                this.head.next = node.next;
                node.next = null;
                this.length -= 1;
                return node;
            }
        }

    }

    

    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.evalRPN(new String[]{"2", "1", "+", "3", "*"})); // 9
        System.out.println(sl.evalRPN(new String[]{"4", "13", "5", "/", "+"})); // 6
        System.out.println(sl.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})); // 22
    }
}