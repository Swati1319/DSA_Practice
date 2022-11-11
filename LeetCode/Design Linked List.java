/*Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.*/


class MyLinkedList {
    class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        Node p = head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        n.next = head;
        head = n;
        size++;

        if (head.next == null) {
            tail = head;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        if (tail != null) {
            tail.next = n;
        }
        if (tail == null || size == 0) {
            head = n;
        } 
        tail = n;
        size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        if (index == 0) {
            addAtHead(val);

        } else if (index == size) {
            addAtTail(val);

        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            /*
            Node n = new Node(val);
            n.next = p.next;
            p.next = n;
            */
            Node n = new Node(val);
            Node save = p;
            p = p.next;
            save.next = n;
            n.next = p;
            size++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size == 0 || index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else {
            Node p = head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = p.next.next;
            size--;
            if (p.next == null) {
                tail = p;
            }
        }
    }
}
