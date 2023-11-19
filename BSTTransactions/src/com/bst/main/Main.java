package com.bst.main;
import com.bst.services.Node;

public class Main {	
	Node node;    
    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.right.left = new Node(55);
        System.out.println("Original BST:");
        tree.printInOrder(tree.node);        
        tree.node = tree.convertToSkewedTree(tree.node);
        System.out.println("\n\nSkewed Tree (No left nodes):");
        tree.printInOrder(tree.node);
    }
    private void printInOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
    private Node convertToSkewedTree(Node root) {
        if (root == null) {
            return null;
        }
        root.left = convertToSkewedTree(root.left);
        while (root.left != null) {
            root = rightRotate(root);
        }
        root.right = convertToSkewedTree(root.right);

        return root;
    }
    private Node rightRotate(Node root) {
        Node newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }
}
