class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void addNode(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    void insertAfter(Node node, int value) {
        Node newNode = new Node(value);
        newNode.next = node.next;
        node.next = newNode;
    }

    void insertEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void insertSorted(int value) {
        if (head == null || head.value >= value) {
            addNode(value);
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value >= value) {
                break;
            }
            current = current.next;
        }
        insertAfter(current, value);
    }

    void deleteNode(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.value == value) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Value not found in the list");
    }

    void reverseList() {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        head = prev;
    }

    void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Example list creation with three nodes
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);

        // Print the list
        list.addNode(0);
        list.insertEnd(5);
        list.printList();
    }
}
