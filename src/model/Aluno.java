package model;

public class Aluno extends Usuario {
    private final String instituicaoDeEnsino;
    private final String curso;
    private final String notaENEM;

    public Aluno(String cpf, String nome, String email, String instituicaoDeEnsino, String curso, String notaENEM) {
        super(cpf, nome, email);
        this.instituicaoDeEnsino = instituicaoDeEnsino;
        this.curso = curso;
        this.notaENEM = notaENEM;
    }

    public String getInstituicaoDeEnsino() { return instituicaoDeEnsino; }
    public String getCurso() { return curso; }
    public String getNotaENEM() { return notaENEM; }

    @Override
    public String getDescricao() {
        return "model.Aluno: " + nome + " - Curso: " + curso;
    }
}