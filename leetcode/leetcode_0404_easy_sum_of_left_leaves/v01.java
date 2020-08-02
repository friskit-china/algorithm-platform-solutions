package leetcode.leetcode_0404_easy_sum_of_left_leaves;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null){
                return 0;
            }
            return process(root.left, true) + process(root.right, false);
        }

        private int process(TreeNode root, boolean isLeft){
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null && isLeft == true){
                return root.val;
            }

            return process(root.left, true) + process(root.right, false);
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().process(root, false));
    }
    
}