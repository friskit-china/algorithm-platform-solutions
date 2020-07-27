package leetcode.leetcode_0102_medm_binary_tree_level_order_traversal;

import java.util.*;

public class v01 {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }


    static
    class Solution {
        class Item{
            int level;
            TreeNode root;
            public Item(TreeNode root, int level){
                this.level = level;
                this.root = root;
            }
        }

        private Queue<Item> queue = new LinkedList<Item>();


        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            queue.add(new Item(root, 0));
            while (queue.size() != 0){
                Item item = queue.poll();
                if (item.root == null){
                    continue;
                }

                if (result.size() == item.level){
                    result.add(new LinkedList<Integer>());
                }
                result.get(item.level).add(item.root.val);
                queue.add(new Item(item.root.left, item.level + 1));
                queue.add(new Item(item.root.right, item.level + 1));
            }
            return result;
        }
    }


    public static void main(String[] argv){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        var result = new Solution().levelOrder(root);
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
    
}