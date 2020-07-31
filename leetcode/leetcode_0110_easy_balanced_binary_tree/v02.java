package leetcode.leetcode_0110_easy_balanced_binary_tree;

// bottom-up

public class v02 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        private int checkHeight(TreeNode root){
            if (root == null){
                return 0;
            }

            int left = checkHeight(root.left);
            if (left == -1){
                return -1;
            }

            int right = checkHeight(root.right);
            if (right == -1){
                return -1;
            }

            return Math.abs(left - right) <= 1 ? Integer.max(left, right) + 1 : -1;
        }

        public boolean isBalanced(TreeNode root) {
            return checkHeight(root) != -1;
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
        // root.left.left.left = new TreeNode(8);
        // root.left.left.right = new TreeNode(9);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);
        System.out.println(new Solution().isBalanced(root));

    }
    
}