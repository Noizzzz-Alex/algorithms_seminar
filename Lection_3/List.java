package Lection_3;

public class List {
    Node head;
    //Node tail;

    //двусвязный список
//    // O(n)
//    public Node find(int value) {
//        Node currentNode = head;
//        while (currentNode != null) {
//            if (currentNode.value == value) {
//                return currentNode;
//            }
//            currentNode = currentNode.next;
//        }
//        return null;
//    }
//
//    public void add(int value) {
//        Node node = new Node();
//        node.value = value;
//        if (head == null) {
//            head = node;
//            tail = node;
//        } else {
//            tail.next = node;
//            node.previous = tail;
//            tail = node;
//        }
//    }
//    public void add(int value, Node node){
//        Node next = node.next;
//        Node newNode = new Node();
//        newNode.value = value;
//        node.next = newNode;
//        newNode.previous = node;
//        if (next == null){
//            tail = newNode;
//        }else {
//            next.previous = newNode;
//            newNode.next = next;
//        }
//    }
//
//    /** метод разворота двусвязанного списка
//     *
//     */
//
//    public void revert(){
//        Node currentNode = head;
//        while (currentNode != null){
//            Node next = currentNode.next;
//            Node previous = currentNode.previous;
//            currentNode.next = previous;
//            currentNode.previous = next;
//            if(previous == null){
//                tail = currentNode;
//            }
//            if(next == null){
//                head = currentNode;
//            }
//            currentNode = next;
//
//        }
//    }
//
//
    public class Node {
        int value;
        Node next;
        //Node previous;

    }


    //односвязный список

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }

    public void revert(){
        if(head != null && head.next != null){
            Node temp = head;
            revert(head.next,head);
            temp.next = null;
        }
    }

}

