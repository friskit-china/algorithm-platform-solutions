package leetcode.leetcode_0103_medm_binary_tree_zigzag_level_order_traversal;

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
            TreeNode node;
            public Item(TreeNode node, int level){
                this.level = level;
                this.node = node;
            }
        }

        private Deque<Item> currentQueue = new ArrayDeque<Item>();
        private Deque<Item> nextQueue = new ArrayDeque<Item>();


        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            currentQueue.add(new Item(root, 0));
            while (currentQueue.size() != 0){
                while (currentQueue.size() != 0){
                    var item = currentQueue.pollFirst();
                
                    if (item.node == null){
                        continue;
                    }
                    if (result.size() == item.level){
                        result.add(new LinkedList<Integer>());
                    }
                    result.get(item.level).add(item.node.val);

                    if (item.level % 2 == 1){ // 1, 3, ...
                        nextQueue.addFirst(new Item(item.node.right, item.level + 1));
                        nextQueue.addFirst(new Item(item.node.left, item.level + 1));
                    }else{ // 0, 2, ...
                        nextQueue.addFirst(new Item(item.node.left, item.level + 1));
                        nextQueue.addFirst(new Item(item.node.right, item.level + 1));
                    }
                }
                var tmp = currentQueue;
                currentQueue = nextQueue;
                nextQueue = tmp;
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

        var result = new Solution().zigzagLevelOrder(root);
        for (var i : result){
            for (var j : i){
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
    
}