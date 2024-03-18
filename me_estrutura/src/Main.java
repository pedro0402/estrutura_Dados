import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Vetor lista = new Vetor();
        Aluno aluno;

        System.out.println("Digite o nome do aluno:");
        for (int i = 1;  i <= 15; i++){
            //String nomeAluno = sc.nextLine();
            aluno = new Aluno("TESTE " + i);
            lista.adiciona(aluno);
        }

        lista.remove(13);
        lista.remove(2);

        System.out.println(lista);

        lista.adicionaPosicao(2, new Aluno("TESTE EXTRA 2"));

        System.out.println(lista);

        lista.adicionaPosicao(13, new Aluno("TSTE EXTRA 3"));

        System.out.println(lista);

    }
}