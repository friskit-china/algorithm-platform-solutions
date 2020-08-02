package leetcode.leetcode_0236_medm_lowest_common_ancestor_of_a_binary_tree;

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
            boolean isLeftP = dfs(root.left, p);
            boolean isLeftQ = dfs(root.left, q);
            boolean isRightP = dfs(root.right, p);
            boolean isRightQ = dfs(root.right, q);

            if (isLeftP && isLeftQ){
                return lowestCommonAncestor(root.left, p, q);
            }else if(isRightP && isRightQ){
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }

        private boolean dfs(TreeNode root, TreeNode target){
            if (root == null){
                return false;
            }

            if (root == target){
                return true;
            }
            return dfs(root.left, target) || dfs(root.right, target);
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