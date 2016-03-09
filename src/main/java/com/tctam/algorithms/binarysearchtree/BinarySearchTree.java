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

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			x = new Node();
			x.key = key;
			x.value = value;
		} else {
			int compare = key.compareTo(x.key);
			if (compare < 0) {
				x.left = put(x.left, key, value);
			} else if (compare > 0) {
				x.right = put(x.right, key, value);
			} else {
				x.value = value;
			}
		}
		return x;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int compare = key.compareTo(x.key);
		if (compare < 0) {
			return get(x.left, key);
		} else if (compare > 0) {
			return get(x.right, key);
		} else {
			return x.value;
		}
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left == null) {
				return x.right;
			}

			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}

		return x;
	}

	private Node min(Node x) {
		if (x.left == null) {
			return x;
		} else {
			return min(x.left);
		}
	}

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		return x;
	}

	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}
		x.right = deleteMax(x.right);
		return x;
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

		bst.delete("E");
		System.out.println("\n---------------");
		bst.preOrder();
	}

}
