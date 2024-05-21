package datastructures.linkedLists;

public class LInkedList {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void addToHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addToEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void addAtIndex(int data, int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index == 0) {
            addToHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next == null) {
            return;
        }
        current.next = current.next.next;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LInkedList list = new LInkedList();

        // Adding elements to the linked list
        list.addToEnd(10);
        list.addToEnd(20);
        list.addToEnd(30);
        list.addToHead(5);
        list.addAtIndex(15, 2);

        // Displaying the linked list
        System.out.print("Linked List: ");
        list.display();

        // Searching for an element
        int searchElement = 20;
        if (list.search(searchElement)) {
            System.out.println(searchElement + " found in the list");
        } else {
            System.out.println(searchElement + " not found in the list");
        }

        // Deleting an element
        int deleteElement = 15;
        list.delete(deleteElement);
        System.out.print("Linked List after deleting " + deleteElement + ": ");
        list.display();
    }

}
