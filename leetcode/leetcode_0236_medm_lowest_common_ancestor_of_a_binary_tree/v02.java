package leetcode.leetcode_0236_medm_lowest_common_ancestor_of_a_binary_tree;

public class v02 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null){
                return root;
            }

            if (root == p || root == q){
                return root;
            }

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null){
                return root;
            }else if(right == null){ // both p and q are not in right 
                return left;
            }else if(left == null){ // both p and q are not in left
                return right;
            }
            return null;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val); // p=5, q=1 -> 3
        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.left.right.right).val); // p=5, q=4 -> 5
    }
}