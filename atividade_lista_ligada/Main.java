package atividade_lista_ligada;

import br.com.caelum.ed.listasligadas.ListaLigada;

public class Main {
    public static void main(String[] args) {
        // Criando uma nova instância da ListaLigada
        br.com.caelum.ed.listasligadas.ListaLigada lista = new br.com.caelum.ed.listasligadas.ListaLigada();

        // Adicionando alguns elementos à lista
        lista.adiciona("Elemento 1");
        lista.adiciona("Elemento 2");
        lista.adiciona("Elemento 3");
        lista.adiciona("Elemento 4");
        lista.adiciona("Elemento 5");

        // Imprimindo a lista antes de remover os primeiros nós
        System.out.println("Lista original: " + lista);

        // Removendo os 3 primeiros nós da lista
        ListaLigada novaLista = lista.removeNPrimeiros(3);

        // Imprimindo a nova lista após a remoção dos primeiros nós
        System.out.println("Nova lista após remover os primeiros nós: " + novaLista);

        // Imprimindo a lista original após a remoção
        System.out.println("Lista original após remover os primeiros nós: " + lista);
    }
}

