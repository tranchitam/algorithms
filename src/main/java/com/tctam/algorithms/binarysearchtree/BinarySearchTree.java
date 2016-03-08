package com.tctam.algorithms.binarysearchtree;

import com.tctam.algorithms.symboltable.SymbolTable;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class BinarySearchTree<Key extends Comparable, Value> implements SymbolTable<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
    }

    public BinarySearchTree() {

    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            node = new Node();
            node.key = key;
            node.value = value;
        } else {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                node.left = put(node.left, key, value);
            } else if (compare > 0) {
                node.right = put(node.right, key, value);
            } else {
                node.value = value;
            }
        }
        return node;
    }

    public Value get(Key key) {
        Node x = root;
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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
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
            System.out.print(node.key + " ");
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
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<String, String> bst = new BinarySearchTree<String, String>();
        bst.put("S", "S");
        bst.put("E", "E");
        bst.put("X", "X");
        bst.put("A", "A");
        bst.put("C", "C");
        bst.put("R", "R");
        bst.put("H", "H");
        bst.put("M", "M");

        bst.preOrder();
        System.out.println("\n---------------");
        bst.inOrder();
        System.out.println("\n---------------");
        bst.postOrder();
    }
}
