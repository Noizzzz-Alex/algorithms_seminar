package Seminar_4;

class uHashMap {
    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public uHashMap() {
        this(INIT_SIZE);
    }

    public uHashMap(int size) {
        baskets = new Basket[size];
    }

    int getIndex(int key) {
        //key.hashCode();
        return key % baskets.length;
    }

    Integer find(int key) {
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null) {
            return basket.find(key);
        }
        return null;
    }

    boolean push(int key, int value) {
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null) {
            basket = new Basket();
            baskets[index] = basket;
        }
        return basket.push(entity);

    }


    class Entity {
        int key;
        int value;
    }

    class Basket {
        Node head;

        class Node {
            Entity entity;
            Node next;
        }

        Integer find(int key) {
            Node node = head;
            while (node != null) {
                if (node.entity.key == key) {
                    return node.entity.value;
                }
                node = node.next;
            }
            return null;
        }

        boolean push(Entity entity) {
            Node node = new Node();
            node.entity = entity;

            if (head == null) {
                head = node;
            } else {
                Node cur = head;
                while (cur.next != null) {
                    if (cur.entity.key == entity.key) {
                        return false;
                    }
                    cur = cur.next;
                }
                cur.next = node;
            }
            return true;
        }
        
    }
}