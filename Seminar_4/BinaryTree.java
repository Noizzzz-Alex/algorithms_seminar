package Seminar_4;

public class BinaryTree {
    Node root;


    class Node {
        int value;
        Node leftChild;
        Node rightChild;
    }

    boolean push(int value) {
        if (root == null) {
            root = new Node();
            root.value = value;
            return true;
        }
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return false;
            }
            if (node.value < value) {
                if (node.rightChild == null) {
                    node.rightChild = new Node();
                    node.rightChild.value = value;
                    return true;
                } else {
                    node = node.rightChild;
                }
            } else {
                if (node.leftChild == null) {
                    node.leftChild = new Node();
                    node.leftChild.value = value;
                    return true;
                } else {
                    node = node.leftChild;
                }
            }
        }
        return false;
    }


    boolean find(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            if (node.value < value) {
                node = node.rightChild;
            } else {
                node = node.leftChild;
            }
        }
        return false;
    }
}

