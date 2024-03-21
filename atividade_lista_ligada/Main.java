package atividade_lista_ligada;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);

        System.out.println("Lista original:");
        ll.printList();
        ll.printTotalNodes();

        int n = 7;
        ll.removeFirstNNodes(n);

        System.out.println("Lista após remover os primeiros " + n + " nós:");
        ll.printList();
        ll.printTotalNodes();
    }
}
