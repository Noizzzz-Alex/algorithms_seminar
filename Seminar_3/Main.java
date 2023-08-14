package Seminar_3;

class sList {
    Node head;

    /**
     * Класс Node  это ячейка связанного списка;
     * Node next  это ссылка на следующий элемент в списке
     */
    class Node {
        int value;
        Node next;
    }

    void reverse() {
        Node prev = null;
        Node cur = head;
        Node temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
    }

    void pushFront(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    void pushBack(int value) {
        Node node = new Node();
        Node current = head;
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    boolean contains(int value) {
        Node node = new Node();
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    void print() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.value + ",");
            curNode = curNode.next;
        }
    }

    void popFront() {
        if (head != null) {
            head = head.next;
        }
    }

    void popBack() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }

        }


    }
}

public class Main {
    public static void main(String[] args) {
        sList list = new sList();
        for (int i = 0; i < 5; i++) {
            list.pushFront(i);
        }
        list.print();
        list.popFront();
        list.popFront();
        System.out.println();
        list.print();
        System.out.println();
        System.out.println(list.contains(5));
        list.pushBack(80);
        list.print();
        System.out.println();
        list.popBack();
        list.print();
        list.reverse();
        System.out.println();
        list.print();

    }
}


class dList {
    Node head;

    /**
     * Класс Node  это ячейка связанного списка;
     * Node next  это ссылка на следующий элемент в списке
     */
    class Node {
        int value;
        Node next;
    }

    void pushFront(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }

    void pushBack(int value) {
        Node node = new Node();
        Node current = head;
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    boolean contains(int value) {
        Node node = new Node();
        while (node != null) {
            if (node.value == value) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    void print() {
        Node curNode = head;
        while (curNode != null) {
            System.out.print(curNode.value + ",");
            curNode = curNode.next;
        }
    }

    void popFront() {
        if (head != null) {
            head = head.next;
        }
    }

    void popBack() {
        if (head != null) {
            if (head.next == null) {
                head = null;
            } else {
                Node current = head;
                while (current.next.next != null) {
                    current = current.next;
                }
                current.next = null;
            }

        }


    }


}