package Lection_4;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    Node root;

    class Node {
        int value;
        List<Node> children;
    }

    //рекурсивный обход дерева в глубину
    private Node findDeep(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = findDeep(child, value);
                return result;
            }
        }
        return null;
    }

    public boolean exist(int value) {
        if (root != null) {
            Node node = findDeep(root, value);
            if (node != null) {
                return true;
            }
        }

        return false;
    }
    // цикличный(итеративный) обход дерева в ширину

    // обход в ширину более трудозатратен
    // чем обход в глубину

    private Node findWidth(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        List<Node> nextLine = null;
        while (line.size() > 0) {
            nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }

        return null;
    }
}
