package leetcode.leetcode_0108_easy_convert_sorted_array_to_binary_search_tree;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return process(nums, 0, nums.length - 1);
        }

        private TreeNode process(int[] nums, int from, int to){
            while (from <= to){
                //int mid = (from + to) / 2;
                int mid = from + (to - from) / 2;
                TreeNode node = new TreeNode(nums[mid]);
                node.left = process(nums, from, mid - 1);
                node.right = process(nums, mid + 1, to);
                return node;
            }
            return null;
        }
    }

    public static void main(String[] argv){
        var result = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        dfs(result);
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