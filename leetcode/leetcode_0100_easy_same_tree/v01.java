package leetcode.leetcode_0100_easy_same_tree;

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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null){
                return true;
            }
            if ((p == null && q != null) || (p != null && q == null)){
                return false;
            }
            if (p.val == q.val){
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }else{
                return false;
            }
            
        }
    }

    public static void main(String[] argv){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        System.out.println(new Solution().isSameTree(root1, root2));
    }
    
}