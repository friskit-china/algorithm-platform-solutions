package leetcode.leetcode_0257_easy_binary_tree_paths;

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
        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null){
                return new LinkedList<>();
            }

            if (root.left == null && root.right == null){
                return Arrays.asList(new String[]{root.val + ""});
            }

            var result = new ArrayList<String>();
            
            var resultLeft = binaryTreePaths(root.left);
            for (var item: resultLeft){
                result.add(root.val + "->" + item);
            }

            var resultRight = binaryTreePaths(root.right);
            for (var item: resultRight){
                result.add(root.val + "->" + item);
            }
            return result;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        var result = new Solution().binaryTreePaths(root);
        for (var r : result){
            System.out.println(r);
        }
    }
}