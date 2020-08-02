package leetcode.leetcode_0129_medm_sum_root_to_leaf_numbers;

import java.util.*;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int sumNumbers(TreeNode root) {
            int result = 0;
            for (var item : process(root)){
                result += Integer.parseInt(item);
            }
            return result;
        }

        private List<String> process(TreeNode root){
            if (root == null){
                return new LinkedList<>();
            }
    
            if (root.left == null && root.right == null){
                return Arrays.asList(new String[]{root.val + ""});
            }
    
            List<String> result = new LinkedList<>();
            for (var item : process(root.left)){
                result.add(root.val + item);
            }
    
            for (var item : process(root.right)){
                result.add(root.val + item);
            }
    
            return result;
        }
    }

    


    public static void main(String[] argv){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        // root.right.left = new TreeNode(13);
        // root.right.right = new TreeNode(4);
        // root.left.left.left = new TreeNode(7);
        // root.left.left.right = new TreeNode(2);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);
        // root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().sumNumbers(root));
    }
}