package leetcode.leetcode_0071_medm_simplify_path;

public class v01 {
    static 
    class Solution {
        public String simplifyPath(String path) {
            Stack stack = new Stack();
            String[] pathList = path.split("/");
            for (int i = 0; i < pathList.length; ++i){
                String folderName = pathList[i];
                if (folderName.equals(".") || folderName.isEmpty()){
                    //ignore
                }else if(folderName.equals("..")){
                    if(stack.length != 0){
                        stack.pop();
                    }
                }else{
                    stack.push(folderName);
                }
            }

            if (stack.length == 0){
                return "/";
            }

            String resultStr = "";
            while(stack.length != 0){
                resultStr = "/" + stack.pop() + resultStr;
            }
            return resultStr;
        }

        static public class ListNode{
            public ListNode next;
            public String val;
            public ListNode(String val){
                this.next = null;
                this.val = val;
            }
        }
    
        static public class Stack{
            private ListNode head;
            public int length;
            public Stack(){
                this.head = new ListNode("head");
                length = 0;
            }
    
            public void push(String val){
                ListNode node = new ListNode(val);
                node.next = this.head.next;
                this.head.next = node;
                length += 1;
            }
    
            public String pop(){
                ListNode node = this.head.next;
                this.head.next = this.head.next.next;
                node.next = null;
                length -= 1;
                return node.val;
            }
        }
    }


    public static void main(String[] argv){
        Solution sl = new Solution();
        System.out.println(sl.simplifyPath("/home/")); // /home
        System.out.println(sl.simplifyPath("/../")); // /
        System.out.println(sl.simplifyPath("/home//foo/")); // /home/foo
        System.out.println(sl.simplifyPath("/a/./b/../../c/")); // /c
        System.out.println(sl.simplifyPath("/a/../../b/../c//.//")); // /c
        System.out.println(sl.simplifyPath("/a/b/c")); // /a/b/c
    }
}