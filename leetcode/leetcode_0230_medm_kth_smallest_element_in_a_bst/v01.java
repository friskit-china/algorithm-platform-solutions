package leetcode.leetcode_0230_medm_kth_smallest_element_in_a_bst;

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

        class Item{
            String OP;
            TreeNode node;
            public Item(String OP, TreeNode node){
                this.OP = OP;
                this.node = node;
            }
        }

        public int kthSmallest(TreeNode root, int k) {
            Stack<Item> stack = new Stack<>();
            stack.push(new Item("visit", root));
            while(stack.size() != 0){
                Item item = stack.pop();
                if (item.node == null){
                    continue;
                }
                
                if(item.OP.equals("visit")){
                    stack.push(new Item("visit", item.node.right));
                    stack.push(new Item("print", item.node));
                    stack.push(new Item("visit", item.node.left));
                }else if(item.OP.equals("print")){
                    if (--k == 0){
                        return item.node.val;
                    }
                }
            }
            return -1;
        }
    }



    public static void main(String[] argv){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().kthSmallest(root, 4));
    }
    
}