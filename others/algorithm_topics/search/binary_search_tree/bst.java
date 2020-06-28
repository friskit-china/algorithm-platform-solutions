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

        public Value minimal(){
            return minimal(root).value;
        }

        private Node<Key, Value> minimal(Node<Key, Value> root){
            if (root.left == null){
                return root;
            }
            return minimal(root.left);
        }

        public Value maximum(){
            return maximum(root).value;
        }

        private Node<Key, Value> maximum(Node<Key, Value> root){
            if (root.right == null){
                return root;
            }
            return maximum(root.right);
        }

        public void removeMinimum(){
            this.root = removeMinimum(root);
        }

        private Node<Key, Value> removeMinimum(Node<Key, Value> root){
            if (root.left == null){
                count -= 1;
                return root.right;
            }
            root.left = removeMinimum(root.left);
            return root;
        }

        public void removeMaximum(){
            this.root = removeMaximum(root);
        }

        private Node<Key, Value> removeMaximum(Node<Key, Value> root){
            if (root.right == null){
                count -= 1;
                return root.left;
            }
            root.right = removeMaximum(root.right);
            return root;
        }

        public void remove(Key key){
            root = remove(root, key);
        }

        private Node<Key, Value> remove(Node<Key, Value> node, Key targetKey){
            if (node == null){
                return null;
            }

            if (targetKey.compareTo(node.key) < 0){
                node.left = remove(node.left, targetKey);
                return node;
            }else if(targetKey.compareTo(node.key) > 0){
                node.right = remove(node.right, targetKey);
                return node;
            }else{
                if (node.left == null){
                    count --;
                    return node.right;
                }
                
                if(node.right == null){
                    count --;
                    return node.left;
                }

                Node<Key, Value> s = minimal(node.right);
                s.right = removeMinimum(node.right);
                s.left = node.left;
                return s;
            }
        }

        public void remove2(Key key){
            root = remove2(root, key);
        }

        private Node<Key, Value> remove2(Node <Key, Value> node, Key targetKey){
            if (node == null){
                return null;
            }
            if (targetKey.compareTo(node.key) < 0){
                node.left = remove2(node.left, targetKey);
                return node;
            }else if(targetKey.compareTo(node.key) > 0){
                node.right = remove2(node.right, targetKey);
                return node;
            }else{
                if (node.left == null){
                    count --;
                    return node.right;
                }

                if (node.right == null){
                    count --;
                    return node.left;
                }
                Node<Key, Value> s = maximum(node.left);
                s.left = removeMaximum(node.left);
                s.right = node.right;
                return s;
            }
        }
    }


    public static void main(final String[] argv){
        final BST<Integer, String> bst = new BST<>();
        bst.insert(41, "a 41");
        bst.insert(22, "c 22");
        bst.insert(58, "e 58");
        bst.insert(15, "b 15");
        bst.insert(33, "d 33");
        bst.insert(50, "e 50");
        bst.insert(60, "f 60");
        bst.insert(13, "g 13");
        bst.insert(37, "h 37");
        bst.insert(42, "i 42");
        bst.insert(53, "j 53");
        bst.insert(59, "k 59");
        bst.insert(63, "l 63");
        // System.out.println(bst.minimal().value);
        // System.out.println(bst.maximum().value);
        bst.remove2(58);

        System.out.println("");
    }
}