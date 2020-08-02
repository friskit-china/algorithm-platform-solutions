package leetcode.leetcode_0450_medm_delete_node_in_a_bst;

public class v01 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    static
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null){
                return null;
            }

            if (key < root.val){
                root.left = deleteNode(root.left, key);
            }else if(key > root.val){
                root.right = deleteNode(root.right, key);
            }else{ // key == root.val
                if (root.left == null){
                    return root.right;
                }

                if (root.right == null){
                    return root.left;
                }

                TreeNode maxNode = getMax(root.left);
                root.val = maxNode.val;
                root.left = deleteNode(root.left, maxNode.val);
            }
            return root;
        }
        private TreeNode getMax(TreeNode root){
            while (root.right != null){
                root = root.right;
            }
            return root;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        
        dfs(new Solution().deleteNode(root, 5));
        
    }

    private static void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        dfs(root.right);
    }
    
}