package leetcode.leetcode_0101_easy_symmetric_tree;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    
    static
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return check(root.left, root.right);
        }

        private boolean check(TreeNode treeA, TreeNode treeB){
            if (treeA == null && treeB == null){
                return true;
            }

            if (treeA == null || treeB == null){
                return false;
            }

            if (treeA.val != treeB.val){
                return false;
            }

            return check(treeA.left, treeB.right) && check(treeA.right, treeB.left);
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(new Solution().isSymmetric(root));
    }
    
}