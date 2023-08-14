package Homework_2;
/*
Необходимо реализовать метод разворота связного списка
(двухсвязного или односвязного на выбор).
 */
class sList {
    Node head;

    class Node {
        int value;
        Node next;
    }

    void reverse() {
        sList.Node prev = null;
        sList.Node cur = head;
        sList.Node temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        head = prev;
    }
}

