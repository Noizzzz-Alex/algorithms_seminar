package Result_HomeWork;
/*
Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево.
И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У краной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись,
после добавления элемента в дерево необходимо произвести балансировку,
благодаря которой все критерии выше станут валидными.
Для балансировки существует 3 операции – левый малый поворот, правый малый поворот и смена цвета.

 */
public class RedBlackTree {
    private Node root;

    public enum Color {
        RED, BLACK
    }

    private class Node {
        int value;
        Color color;
        Node leftChild;
        Node rightChild;
    }

    private boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    private Node leftTurn(Node node) {
        Node newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;
        newRoot.color = node.color;
        node.color = Color.RED;
        return newRoot;
    }

    private Node rightTurn(Node node) {
        Node newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;
        newRoot.color = node.color;
        node.color = Color.RED;
        return newRoot;
    }

    private void colorReplacement(Node node) {
        node.color = Color.RED;
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            Node newNode = new Node();
            newNode.value = value;
            newNode.color = Color.RED;
            return newNode;
        }

        if (value < node.value) {
            node.leftChild = insert(node.leftChild, value);
        } else if (value > node.value) {
            node.rightChild = insert(node.rightChild, value);
        } else {
            return node; // Элемент уже существует
        }

        if (isRed(node.rightChild) && !isRed(node.leftChild)) {
            node = leftTurn(node);
        }
        if (isRed(node.leftChild) && isRed(node.leftChild.leftChild)) {
            node = rightTurn(node);
        }
        if (isRed(node.leftChild) && isRed(node.rightChild)) {
            colorReplacement(node);
        }

        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
        root.color = Color.BLACK;
    }
}
