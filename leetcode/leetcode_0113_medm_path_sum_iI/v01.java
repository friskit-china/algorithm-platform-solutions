package leetcode.leetcode_0113_medm_path_sum_iI;

import java.util.*;

public class v01 {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    static
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            if (root == null){
                return new ArrayList<List<Integer>>();
            }

            if (root.val == sum && root.left == null && root.right == null){
                var result = new ArrayList<List<Integer>>();
                result.add(Arrays.asList(new Integer[]{root.val}));
                return result;
            }


            var result = new ArrayList<List<Integer>>();
            for (var item : pathSum(root.left, sum - root.val)){
                var tmp = new ArrayList<Integer>();
                tmp.add(root.val);
                tmp.addAll(item);
                result.add(tmp);
            }

            for (var item : pathSum(root.right, sum - root.val)){
                var tmp = new ArrayList<Integer>();
                tmp.add(root.val);
                tmp.addAll(item);
                result.add(tmp);
            }

            return result;

        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        var result = new Solution().pathSum(root, 22);

        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    
}