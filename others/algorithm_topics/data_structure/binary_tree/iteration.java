package others.algorithm_topics.data_structure.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class iteration {
    public static class Node<Value>{
        public Value value;
        public Node<Value> left;
        public Node<Value> right;
        public Node(Value value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static <T> void preorder_iteration(Node<T> root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        preorder_iteration(root.left);
        preorder_iteration(root.right);
    }

    public static <T> void inorder_iteration(Node<T> root){
        if (root == null){
            return;
        }
        inorder_iteration(root.left);
        System.out.println(root.value);
        inorder_iteration(root.right);
    }

    public static <T> void postorder_iteration(Node<T> root){
        if (root == null){
            return;
        }
        postorder_iteration(root.left);
        postorder_iteration(root.right);
        System.out.println(root.value);
    }

    public static <T> void levelorder_iteration(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        while (queue.isEmpty() == false){
            Node<T> node = queue.remove();
            System.out.println(node.value);
            if (node.left != null){
                queue.add(node.left);
            }

            if (node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] argv){
        Node<Integer> root = new Node<Integer>(28);
        root.left = new Node<Integer>(16);
        root.right = new Node<Integer>(30);
        root.left.left = new Node<Integer>(13);
        root.left.right = new Node<Integer>(22);
        root.right.left = new Node<Integer>(29);
        root.right.right = new Node<Integer>(42);

        preorder_iteration(root);
        System.out.println("");
        inorder_iteration(root);
        System.out.println("");
        postorder_iteration(root);
        System.out.println("");
        levelorder_iteration(root);
        
    }
    
}