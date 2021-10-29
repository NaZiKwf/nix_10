package ua.com.alevel;


public class Tree<E extends Comparable<E>> {
    private Node<E> root;

    public void add(E[] elements) {
        for (E elem : elements) {
            add(elem);
        }
    }

    public boolean add(E element) {
        Node<E> way;
        way = insert(element, root);
        if (way == null) {
            return false;
        }
        root = way;
        return true;
    }

    public int maxDepth() {
        return maxDepth(this.root);
    }

    private int maxDepth(Node root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        if (left > right)
            return left + 1;
        else
            return right + 1;
    }

    private Node insert(E element, Node<E> destination) {
        if (destination == null) {
            destination = new Node(element);
            return destination;
        }
        if (element.compareTo(destination.value) > 0) {
            destination.right = (insert(element, destination.right));
            return destination;
        }
        if (element.compareTo(destination.value) < 0) {
            destination.left = (insert(element, destination.left));
            return destination;
        }
        return null;
    }

    public void print() {
        print(root, 0);
    }


    private static void print(Node root, int empty) {
        if (root == null) {
            return;
        }
        int temp = 2;
        empty += temp;
        print(root.right, empty);
        for (int i = temp; i < empty; i++) {
            System.out.print(" ");
        }
        System.out.print(root.value + "\n");
        print(root.left, empty);
    }

    public boolean remove(E element) {
        Node<E> parent = null;
        Node<E> current = root;
        while (current != null) {
            if (element.compareTo(current.value) < 0) {
                parent = current;
                current = current.left;
            } else if (element.compareTo(current.value) > 0) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }
        if (current == null) {
            return false;
        }
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
            } else {
                if (element.compareTo(parent.value) < 0) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            }
        } else {
            Node<E> parentOfRightMost = current;
            Node<E> mostRight = current.left;
            while (mostRight.right != null) {
                parentOfRightMost = mostRight;
                mostRight = mostRight.right;
            }
            current.value = mostRight.value;

            if (parentOfRightMost.right == mostRight) {
                parentOfRightMost.right = mostRight.left;
            } else {
                parentOfRightMost.left = mostRight.left;
            }
        }
        return true;
    }

    private static class Node<E> {
        private E value;
        private Node left;
        private Node right;

        Node(E value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
