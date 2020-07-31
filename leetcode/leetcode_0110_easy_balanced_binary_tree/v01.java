package leetcode.leetcode_0110_easy_balanced_binary_tree;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        private int height(TreeNode root){
            if (root == null){
                return 0;
            }else{
                return Integer.max(height(root.left), height(root.right)) + 1;
            }
        }
        public boolean isBalanced(TreeNode root) {
            if (root == null){
                return true;
            }
            return (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);
        System.out.println(new Solution().isBalanced(root));

    }
    
}