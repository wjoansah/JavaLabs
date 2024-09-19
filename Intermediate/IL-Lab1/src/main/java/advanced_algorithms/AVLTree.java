package advanced_algorithms;

public class AVLTree<T extends Comparable<T>> {

    private static class Node<T> {
        private int balanceFactor;
        private T value;
        int height;

        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node<T> root;
    private int size = 0;

    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(Node<T> node, T value) {
        if (node == null) return false;
        int cmp = value.compareTo(node.getValue());
        if (cmp < 0) return contains(node.getLeft(), value);
        if (cmp > 0) return contains(node.getLeft(), value);
        return true;
    }

    public boolean remove(T value) {
        if (value == null) return false;

        if (contains(root, value)) {
            root = remove(root, value);
            size--;
            return true;
        }
        return false;
    }

    private Node<T> remove(Node<T> node, T value) {
        if (node == null) return null;

        int cmp = value.compareTo(node.getValue());

        if (cmp < 0) {
            node.setLeft(remove(node.left, value));
        } else if (cmp > 0) {
            node.setRight(remove(node.right, value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            } else {
                if (node.left.height > node.right.height) {
                    var successor = findMax(node.left);
                    node.value = successor;

                    node.left = remove(node.left, successor);
                } else {
                    var successor = findMin(node.right);
                    node.value = successor;

                    node.right = remove(node.right, successor);
                }
            }
        }

        updateBalanceFactor(node);

        return balance(node);
    }

    private Node<T> handleRemoval(Node<T> node) {
        if (node.getLeft() == null) {
            return node.getRight();
        } else if (node.getRight() == null) {
            return node.getLeft();
        } else {
            return replaceWithSuccessor(node);
        }
    }

    private Node<T> replaceWithSuccessor(Node<T> node) {
        if (node.left.height > node.right.height) {
            var successor = findMax(node.left);
            node.value = successor;

            node.left = remove(node.left, successor);
        } else {
            var successor = findMin(node.right);
            node.value = successor;

            node.right = remove(node.right, successor);
        }
        return node;
    }

    public boolean insert(T value) {
        if (value == null) return false;
        if (!contains(root, value)) {
            root = insert(root, value);
            size++;
            return true;
        }
        return false;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) return new Node<>(value);

        int cmp = value.compareTo(node.getValue());

        if (cmp < 0) {
            node.left = insert(node.getLeft(), value);
        } else {
            node.right = insert(node.getRight(), value);
        }

        updateBalanceFactor(node);
        return balance(node);
    }

    private void updateBalanceFactor(Node<T> node) {
        int leftNodeHeight = node.getLeft() == null ? -1 : node.getLeft().height;
        int rightNodeHeight = node.getRight() == null ? -1 : node.getRight().height;

        node.height = Math.max(leftNodeHeight, rightNodeHeight) + 1;
        node.balanceFactor = rightNodeHeight - leftNodeHeight;
    }

    private Node<T> balance(Node<T> node) {
        if (node.balanceFactor == -2) { // left heavy subtree
            // left-left case
            if (node.getLeft().balanceFactor <= 0) {
                return leftLeftCase(node);
            } else {
                // left-right case
                return leftRightCase(node);
            }
        } else if (node.balanceFactor == 2) { // right heavy subtree
            // right-right case
            if (node.getRight().balanceFactor >= 0) {
                return rightRightCase(node);
            } else {
                // right-left case
                return rightLeftCase(node);
            }
        }
        return node;
    }

    private Node<T> leftLeftCase(Node<T> node) {
        return rightRotation(node);
    }

    private Node<T> leftRightCase(Node<T> node) {
        node.setLeft(leftRotation(node.getLeft()));
        return leftLeftCase(node);
    }

    private Node<T> rightRightCase(Node<T> node) {
        return leftRotation(node);
    }

    private Node<T> rightLeftCase(Node<T> node) {
        node.setRight(rightRotation(node.getRight()));
        return rightRightCase(node);
    }

    private Node<T> leftRotation(Node<T> node) {
        var newParent = node.getRight();
        node.setRight(newParent.getLeft());
        newParent.setLeft(node);

        updateBalanceFactor(node);
        updateBalanceFactor(newParent);

        return newParent;
    }

    private Node<T> rightRotation(Node<T> node) {
        var newParent = node.getLeft();
        node.setLeft(newParent.getRight());
        newParent.setRight(node);

        updateBalanceFactor(node);
        updateBalanceFactor(newParent);

        return newParent;
    }

    private T findMin(Node<T> node) {
        while (node.left != null) node = node.left;
        return node.value;
    }

    private T findMax(Node<T> node) {
        while (node.right != null) node = node.right;
        return node.value;
    }

    public void printInOrder() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.getValue());
            inOrder(node.right);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        var tree = new AVLTree<Integer>();

        // Inserting nodes
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Inorder traversal of the constructed AVL tree is:");
        tree.printInOrder();

        // Searching for a node
        System.out.println("Searching for 20 in the AVL tree: " + tree.contains(20));

        // Deleting a node
        tree.remove(20);
        System.out.println("Inorder traversal after deleting 20:");
        tree.printInOrder();

        // Searching for the deleted node
        System.out.println("Searching for 20 in the AVL tree after deletion: " + tree.contains(20));
    }
}
