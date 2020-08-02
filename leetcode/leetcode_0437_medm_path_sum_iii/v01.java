package leetcode.leetcode_0437_medm_path_sum_iii;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null){
                return 0;
            }

            var result = 0;
            result += process(root, sum);
            
            result += pathSum(root.left, sum);
            result += pathSum(root.right, sum);

            return result;
        }

        private int process(TreeNode root, int sum){
            if (root == null){
                return 0;
            }

            var result = 0;
            if (root.val == sum){
                result += 1;
            }

            result += process(root.left, sum - root.val);
            result += process(root.right, sum - root.val);

            return result;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        System.out.println(new Solution().pathSum(root, 8));
    }
    
}