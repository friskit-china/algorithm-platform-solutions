package leetcode.leetcode_0098_medm_validate_binary_search_tree;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean check(TreeNode root, long from, long to){
            if (root == null){
                return true;
            }

            if (root.val > to || root.val < from){
                return false;
            }
            return check(root.left, from, (long)root.val - 1) && check(root.right, (long)root.val + 1, to);
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(new Solution().isValidBST(root));
    }
    
}