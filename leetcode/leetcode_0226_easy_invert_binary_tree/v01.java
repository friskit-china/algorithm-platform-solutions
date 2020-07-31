package leetcode.leetcode_0226_easy_invert_binary_tree;


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
        public TreeNode invertTree(TreeNode root) {
            if (root == null){
                return root;
            }
            var invLeft = invertTree(root.left);
            var invRight = invertTree(root.right);
            root.left = invRight;
            root.right = invLeft;
            return root;
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        root = new Solution().invertTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val + " " + root.right.val);
        System.out.println(root.left.left.val + " " + root.left.right.val + " " + root.right.left.val + " " + root.right.right.val);
    }
    
}