public class Aluno {
    private String nome;

    public Aluno(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object o) {
        Aluno aluno = (Aluno) o;
        return this.getNome().equals(aluno.nome);
    }
}