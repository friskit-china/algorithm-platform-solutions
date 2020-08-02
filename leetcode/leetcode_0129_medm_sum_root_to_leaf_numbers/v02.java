package leetcode.leetcode_0129_medm_sum_root_to_leaf_numbers;

public class v02 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int sumNumbers(TreeNode root) {
            return process(root, 0);
        }

        private int process(TreeNode root, Integer prefix){
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return prefix * 10 + root.val;
            }

            return process(root.left, prefix * 10 + root.val) + process(root.right, prefix * 10 + root.val);
        }
    }

    


    public static void main(String[] argv){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        // root.left.left = new TreeNode(5);
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