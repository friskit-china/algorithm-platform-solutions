package leetcode.leetcode_0112_easy_path_sum;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null){
                return false;
            }
            if (root.left == null && root.right == null){
                return sum == root.val;
            }
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        // root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution().hasPathSum(root, 22));
    }
    
}