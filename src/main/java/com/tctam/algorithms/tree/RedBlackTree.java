package com.tctam.algorithms.tree;

import com.tctam.algorithms.symboltable.SymbolTable;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class RedBlackTree<Key extends Comparable, Value> implements SymbolTable<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value value;
        Node left, right;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }

        @Override
        public String toString() {
            return String.format("[Key: %s, Value: %s, Color: %s]", key, value, color ? "RED" : "BLACK");
        }
    }

    private boolean isRed(Node h) {
        if (h == null) {
            return false;
        }
        return h.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node flipColor(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
        return h;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node h, Key key, Value value) {
        if (h == null) {
            return new Node(key, value, RED);
        }

        int compare = key.compareTo(h.key);
        if (compare < 0) {
            h.left = put(h.left, key, value);
        } else if (compare > 0) {
            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            h = flipColor(h);
        }
        return h;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int compare = key.compareTo(x.key);
            if (compare < 0) {
                x = x.left;
            } else if (compare > 0) {
                x = x.right;
            } else {
                return x.value;
            }
        }
        return null;
    }

    public void delete(Key key) {

    }

    public void deleteMin() {

    }

    public void deleteMax() {

    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.toString());
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.toString());
            inOrder(node.right);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.toString());
        }
    }

    public static void main(String[] args) {
        RedBlackTree<String, String> bst = new RedBlackTree<String, String>();
        bst.put("S", "S");
        bst.put("E", "E");
        bst.put("A", "A");
        bst.put("R", "R");
        bst.put("C", "C");
        bst.put("H", "H");
        bst.put("X", "X");
        bst.put("M", "M");
        bst.put("P", "P");
        bst.put("L", "L");

        bst.preOrder();
    }

}
