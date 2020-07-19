package leetcode.leetcode_0144_medm_binary_tree_preorder_traversal;

import java.util.*;

public class v01_recursive {
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
            access(root, result);
            return result;
        }

        public void access(TreeNode root, List<Integer> result){
            if (root == null){
                return;
            }

            result.add(root.val);
            access(root.left, result);
            access(root.right, result);

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