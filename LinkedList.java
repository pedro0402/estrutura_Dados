package atividade_lista_ligada;

public class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }
    void printList() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    int countNodes() {
        int count = 0;
        Node current = this.head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    void append(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            return;
        }
        Node lastNode = this.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }
    void printTotalNodes() {
        System.out.println("Total de elementos na lista: " + countNodes());
    }


    Node removeFirstNNodes(int n) {
        if (this.head == null)
            return null;

        Node current = this.head;
        for (int i = 0; i < n - 1; i++) {
            if (current.next != null) {
                current = current.next;
            } else {
                this.head = null;
                return null;
            }
        }

        this.head = current.next;
        return this.head;
    }
}

