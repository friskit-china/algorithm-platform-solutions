package leetcode.leetcode_0235_easy_lowest_common_ancestor_of_a_binary_search_tree;

public class v01 {
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
                return null;
            }

            if (p.val < root.val && q.val < root.val){
                return lowestCommonAncestor(root.left, p, q);
            }

            if (p.val > root.val && q.val > root.val){
                return lowestCommonAncestor(root.right, p, q);
            }

            return root;
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val); // 2, 8 -> 6
    }
    
}