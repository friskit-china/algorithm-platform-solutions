package leetcode.leetcode_0111_easy_minimum_depth_of_binary_tree;

public class v01 {
    static
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return 1;
            }
            return Integer.min(root.left != null ? minDepth(root.left) : Integer.MAX_VALUE, root.right != null ? minDepth(root.right) : Integer.MAX_VALUE) + 1;
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().minDepth(root));
    }
    
}