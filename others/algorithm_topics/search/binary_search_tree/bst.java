package others.algorithm_topics.search.binary_search_tree;

public class bst {
    private static class Node<Key, Value>{
        public Key key;
        public Value value;
        public Node<Key, Value> left;
        public Node<Key, Value> right;
        public Node(final Key key, final Value value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static class BST<Key extends Comparable<Key>, Value>{
        public Node<Key, Value> root;
        private int count;
        public int size(){
            return count;
        }
        public boolean isEmpty(){
            return count == 0;
        }
        public BST(){
            this.root = null;
            this.count = 0;
        }

        public void insert(final Key key, final Value value){
            this.root = insert(root, key, value);
        }

        private Node<Key, Value> insert(final Node<Key, Value> root, final Key key, final Value value){
            if (root == null){
                this.count += 1;
                return new Node<Key,Value>(key, value);
            }
            if (root.key == key){
                root.value = value;
                return root;
            }else if(key.compareTo(root.key) < 0){
                root.left = insert(root.left, key, value);
            }else{
                root.right = insert(root.right, key, value);
            }
            return root;
        }

        public boolean contains(Key key){
            return contains(root, key);
        }

        private boolean contains(Node<Key, Value> root, Key key){
            if (root == null){
                return false;
            }

            if (key == root.key){
                return true;
            }else if(key.compareTo(root.key) < 0){
                return contains(root.left, key);
            }else{
                return contains(root.right, key);
            }
        }

        public Value search(Key key){
            return search(root, key);
        } 
        private Value search(Node<Key, Value> root, Key key){
            if (root == null){
                return null;
            }
            if (key == root.key){
                return root.value;
            }else if(key.compareTo(root.key) < 0){
                return search(root.left, key);
            }else{
                return search(root.right, key);
            }
        }
    }


    public static void main(final String[] argv){
        final BST<Integer, String> bst = new BST<>();
        bst.insert(1, "a");
        bst.insert(3, "c");
        bst.insert(5, "e");
        bst.insert(2, "b");
        bst.insert(4, "d");
        bst.insert(1, "z");
    }
}