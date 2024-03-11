package br.com.caelum.ed.vetores.testes;

public class Programa {
    public static void main(String[] args) {

        Aluno a1 = new Aluno("Aluno1");
        Aluno a2 = new Aluno("Aluno2");
        Aluno a3 = new Aluno("Aluno3");
        Aluno a4 = new Aluno("Aluno4");

        System.out.println(a1.getNome());
        System.out.println(a2.getNome());


        Vetor lista = new Vetor();
        lista.adiciona(0,a1);
        lista.adiciona(1,a2);
        lista.adiciona(2,a3);
        lista.adiciona(20, a4);
        System.out.println(lista);
        System.out.println(lista.getTotalDeAlunos());
    }
}