import java.util.Arrays;

public class Vetor {
    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona(Aluno aluno) {
        for (int i=0; i< alunos.length; i++){
            if(this.alunos[i] == null){
                this.alunos[i] = aluno;

                this.alunos[this.totalDeAlunos] = aluno;
                this.totalDeAlunos++;
                break;
            }
        }
    }
    public void adiciona(int posicao, Aluno aluno) {
        for (int i = this.totalDeAlunos - 1; i >= posicao; i-=1) {
            this.alunos[i + 1] = this.alunos[i];
        }
        this.alunos[posicao] = aluno;
        this.totalDeAlunos++;
    }
    public void remove(int posicao) {
        for (int i = posicao; i < this.totalDeAlunos - 1; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }
        this.totalDeAlunos--;
    }
    public Aluno pega(int posicao) {
        return this.alunos[posicao];
    }

    public boolean contem(Aluno aluno) {
        for (int i = 0; i < this.alunos.length; i++) {
            if (aluno.equals(this.alunos[i])) {
                return true;
            }
        }
        return false;
    }
    public int tamanho() {
        return this.totalDeAlunos;
    }

    @Override
    public String toString() {
        if (this.totalDeAlunos == 0) {
            return "[]";
        }
        return "Vetor " +
                "Alunos = " + Arrays.toString(alunos);
    }
}