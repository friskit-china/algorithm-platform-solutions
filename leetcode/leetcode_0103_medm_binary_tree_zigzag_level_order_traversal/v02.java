package leetcode.leetcode_0103_medm_binary_tree_zigzag_level_order_traversal;

import java.util.*;

public class v02 {
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

        private Stack<Item> currentStack = new Stack<>();
        private Stack<Item> nextStack = new Stack<>();



        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            currentStack.push(new Item(root, 0));
            while (currentStack.size() != 0){
                while (currentStack.size() != 0){
                    var item = currentStack.pop();
                
                    if (item.node == null){
                        continue;
                    }
                    if (result.size() == item.level){
                        result.add(new LinkedList<Integer>());
                    }
                    result.get(item.level).add(item.node.val);

                    if (item.level % 2 == 0){ // 0, 2, ...
                        nextStack.push(new Item(item.node.left, item.level + 1));
                        nextStack.push(new Item(item.node.right, item.level + 1));
                    }else{ // 1, 3, ...
                        nextStack.push(new Item(item.node.right, item.level + 1));
                        nextStack.push(new Item(item.node.left, item.level + 1));
                    }
                }
                var tmp = currentStack;
                currentStack = nextStack;
                nextStack = tmp;
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