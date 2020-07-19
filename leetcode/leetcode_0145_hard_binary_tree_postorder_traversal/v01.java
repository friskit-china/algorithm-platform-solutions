package leetcode.leetcode_0145_hard_binary_tree_postorder_traversal;

import java.util.*;

public class v01 {
    static
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    static
    class Solution {
        static
        class OP{
            String cmd;
            TreeNode node;
            OP(String cmd, TreeNode node){
                this.cmd = cmd;
                this.node = node;
            }
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<OP> stack = new Stack<>();
            stack.push(new OP("visit", root));

            while (stack.isEmpty() == false){
                OP op = stack.pop();
                if (op.node == null){
                    continue;
                }
                if (op.cmd.equals("visit")){
                    stack.push(new OP("print", op.node));
                    stack.push(new OP("visit", op.node.right));
                    stack.push(new OP("visit", op.node.left));
                }else if(op.cmd.equals("print")){
                    result.add(op.node.val);
                }
            }
            
            return result;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new Solution().postorderTraversal(root);
        for (var i: result){
            System.out.println(i);
        }
    }
}