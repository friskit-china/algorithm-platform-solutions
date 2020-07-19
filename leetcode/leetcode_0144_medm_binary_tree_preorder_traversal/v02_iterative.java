package leetcode.leetcode_0144_medm_binary_tree_preorder_traversal;

import java.util.*;

public class v02_iterative {
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
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (stack.isEmpty() == false){
                TreeNode item = stack.pop();
                if (item != null){
                    result.add(item.val);
                    stack.push(item.right);
                    stack.push(item.left);
                }
            }
            return result;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new Solution().preorderTraversal(root);
        for (var i: result){
            System.out.println(i);
        }
    }
    
}