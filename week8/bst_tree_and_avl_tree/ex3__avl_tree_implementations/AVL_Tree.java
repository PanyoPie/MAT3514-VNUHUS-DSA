package vn.io.tunaa.dsa.week8.bst_tree_and_avl_tree.ex3__avl_tree_implementations;

public class AVL_Tree {
    // A utility function to get the height 
    // of the tree
    public int height(Node N) {
        if (N == null) {
            return 0;
        }

        return N.height;
    }

    // A utility function to right rotate 
    // subtree rooted with y
    public Node rightRotate(Node y) {
        if (y == null) {
            return y;
        }

        Node x = y.left;
        y.left = x.right;
        x.right = y;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // A utility function to left rotate 
    // subtree rooted with x
    public Node leftRotate(Node x) {
        if (x == null) {
            return x;
        }

        Node y = x.right;
        x.right = y.left;
        y.left = x;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Get Balance factor of node N
    public int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

        return height(N.left) - height(N.right);
    }

    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1) {
            if (key > node.left.key) {
                node.left = leftRotate(node.left);
            }
            return rightRotate(node);
        }

        if (balance < -1) {
            if (key < node.right.key) {
                node.right = rightRotate(node.right);
            }
            return leftRotate(node);
        }

        return node;
    }

    private Node minNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // Recursive function to delete a node with 
    // given key from subtree with given root. 
    // It returns root of the modified subtree.
    public Node deleteNode(Node node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteNode(node.left, key);
        } else if (key > node.key) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                Node tmp = minNode(node);
                node.key = tmp.key;
                node.right = deleteNode(node.right, tmp.key);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.left) >= 0) {
                return rightRotate(node);
            }
            return rightRotate(node);
        }

        if (balance < -1) {
            if (getBalance(node.left) <= 0) {
                return leftRotate(node);
            }
            return leftRotate(node);
        }

        return node;
    }

    // A utility function to print preorder 
    // traversal of the tree.
    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        AVL_Tree a = new AVL_Tree();

        Node tree = null;

        tree = a.insert(tree, 1);
        tree = a.insert(tree, 2);
        tree = a.insert(tree, 3);
        tree = a.insert(tree, 4);
        tree = a.insert(tree, 5);
        tree = a.insert(tree, 6);
        a.preOrder(tree);
    }
}