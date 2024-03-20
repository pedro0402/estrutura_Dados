package atividade_lista_ligada;

public class ListaLigada {
    private Celula primeira;
    private Celula ultima;
    private int totalDeElementos;

    public void adiciona(Object elemento) {
        if (this.totalDeElementos == 0) {
            this.adicionaNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            this.ultima.setProxima(nova);
            nova.setAnterior(this.ultima);
            this.ultima = nova;
            this.totalDeElementos++;
        }
    }

    public void adiciona(int posicao, Object elemento) {
        if (posicao == 0) { // No começo.
            this.adicionaNoComeco(elemento);
        } else if (posicao == this.totalDeElementos) { // No fim.
            this.adiciona(elemento);
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula proxima = anterior.getProxima();
            Celula nova = new Celula(anterior.getProxima(), elemento);
            nova.setAnterior(anterior);
            anterior.setProxima(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    public Object pega(int posicao) {
        return this.pegaCelula(posicao).getElemento();
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (posicao == 0) {
            this.removeDoComeco();
        } else if (posicao == this.totalDeElementos - 1) {
            this.removeDoFim();
        } else {
            Celula anterior = this.pegaCelula(posicao - 1);
            Celula atual = anterior.getProxima();
            Celula proxima = atual.getProxima();
            anterior.setProxima(proxima);
            proxima.setAnterior(anterior);
            this.totalDeElementos--;
        }
    }

    public int tamanho() {
        return this.totalDeElementos;
    }

    public boolean contem(Object elemento) {
        Celula atual = this.primeira;
        while (atual != null) {
            if (atual.getElemento().equals(elemento)) {
                return true;
            }
            atual = atual.getProxima();
        }
        return false;
    }

    public void adicionaNoComeco(Object elemento) {
        if (this.totalDeElementos == 0) {
            Celula nova = new Celula(elemento);
            this.primeira = nova;
            this.ultima = nova;
        } else {
            Celula nova = new Celula(this.primeira, elemento);
            this.primeira.setAnterior(nova);
            this.primeira = nova;
        }
        this.totalDeElementos++;
    }

    public void removeDoComeco() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeira = this.primeira.getProxima();
        this.totalDeElementos--;
        if (this.totalDeElementos == 0) {
            this.ultima = null;
        }
    }

    public void removeDoFim() {
        if (!this.posicaoOcupada(this.totalDeElementos - 1)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        if (this.totalDeElementos == 1) {
            this.removeDoComeco();
        } else {
            Celula penultima = this.ultima.getAnterior();
            penultima.setProxima(null);
            this.ultima = penultima;
            this.totalDeElementos--;
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao < this.totalDeElementos;
    }

    private Celula pegaCelula(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeira;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProxima();
        }
        return atual;
    }

    public ListaLigada removeNPrimeiros(int n) {
        if (n <= 0) {
            return new ListaLigada(); // Retorna uma lista vazia se n for não positivo
        } else if (n >= this.totalDeElementos) {
            return new ListaLigada(); // Retorna uma lista vazia se n for maior ou igual ao comprimento da lista
        }

        ListaLigada novaLista = new ListaLigada();
        Celula atual = this.primeira;

        // Percorre os primeiros n nós e os remove da lista original
        for (int i = 0; i < n; i++) {
            Celula proxima = atual.getProxima();
            atual.setProxima(null); // Desconecta o nó atual da lista original
            novaLista.adiciona(atual.getElemento()); // Adiciona o nó à nova lista
            atual = proxima;
            this.totalDeElementos--;
        }

        // Atualiza o primeiro nó da lista original para o próximo nó após os primeiros n nós
        this.primeira = atual;
        if (atual == null) {
            this.ultima = null; // Se não houver mais nós na lista original, atualiza a última referência
        }

        return novaLista;
    }

    public String toString() {
        if (this.totalDeElementos == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Celula atual = primeira;
        for (int i = 0; i < this.totalDeElementos - 1; i++) {
            builder.append(atual.getElemento());
            builder.append(", ");
            atual = atual.getProxima();
        }
        builder.append(atual.getElemento());
        builder.append("]");
        return builder.toString();
    }

    private class Celula {
        private Object elemento;
        private Celula proxima;
        private Celula anterior;

        public Celula(Object elemento) {
            this.elemento = elemento;
            this.proxima = null;
            this.anterior = null;
        }

        public Celula(Celula proxima, Object elemento) {
            this.elemento = elemento;
            this.proxima = proxima;
            this.anterior = null;
        }

        public Object getElemento() {
            return elemento;
        }

        public Celula getProxima() {
            return proxima;
        }

        public void setProxima(Celula proxima) {
            this.proxima = proxima;
        }

        public Celula getAnterior() {
            return anterior;
        }

        public void setAnterior(Celula anterior) {
            this.anterior = anterior;
        }
    }
}

