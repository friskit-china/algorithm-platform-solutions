package leetcode.leetcode_0222_medm_count_complete_tree_nodes;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int countNodes(TreeNode root) {
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return 1;
            }
            if (root.right == null){
                return 2;
            }

            TreeNode p = root;
            int depthL = 0;
            while (p != null){
                depthL += 1;
                p = p.left;
            }

            p = root;
            int depthR = 0;
            while (p != null){
                depthR += 1;
                p = p.right;
            }

            if (depthL == depthR){ // full binary tree
                return (1 << depthL) - 1;
            }

            int result = (1 << depthR) - 1;

            // not full binary tree
            TreeNode currentRoot = root;
            int flag = 0;
            while (true){
                TreeNode leftRoot = currentRoot.left;
                TreeNode rightRoot = currentRoot.right;
                if(leftRoot == null && rightRoot == null){
                    break;
                }
                depthL = 0;
                depthR = 0;

                while (leftRoot != null){
                    depthL += 1;
                    leftRoot = leftRoot.left;
                }

                while (rightRoot != null){
                    depthR += 1;
                    rightRoot = rightRoot.left;
                }
                if (depthL != depthR){ // pivot in the left
                    flag = (flag << 1);
                    currentRoot = currentRoot.left;
                }else{ // pivot in the right
                    flag = (flag << 1) + 1;
                    currentRoot = currentRoot.right;
                }
                leftRoot = currentRoot.left;
                rightRoot = currentRoot.right;
            }
            return result + flag + 1;
        }
    }


    public static void main(String[] argv){
        TreeNode root = null;
        // TreeNode root = new TreeNode(1);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.left = new TreeNode(4);
        // root.left.right = new TreeNode(5);
        // root.right.left = new TreeNode(6);
        // root.right.right = new TreeNode(7);
        // root.left.left.left = new TreeNode(8);
        // root.left.left.right = new TreeNode(9);
        // root.left.right.left = new TreeNode(10);
        // root.left.right.right = new TreeNode(11);
        // root.right.left.left = new TreeNode(12);

        System.out.println(new Solution().countNodes(root));
    }
    
}