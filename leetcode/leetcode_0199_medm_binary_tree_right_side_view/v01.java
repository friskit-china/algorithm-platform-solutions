package leetcode.leetcode_0199_medm_binary_tree_right_side_view;

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

        private Deque<Item> queue = new ArrayDeque<Item>();

        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new LinkedList<Integer>();
            queue.addLast(new Item(root, 0));

            while(queue.size() != 0){
                var item = queue.pollFirst();
                if (item.node == null){
                    continue;
                }

                if (item.level == result.size()){
                    result.add(item.node.val);    
                }else{
                    result.set(item.level, item.node.val);
                }

                queue.addLast(new Item(item.node.left, item.level + 1));
                queue.addLast(new Item(item.node.right, item.level + 1));
            }

            return result;
            
        }
    }

    public static void main(String[] argv){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        var result = new Solution().rightSideView(root);
        for (var i : result){
            System.out.println(i);
        }
    }


}