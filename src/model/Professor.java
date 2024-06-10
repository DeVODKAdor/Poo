package model;

public class Professor extends Usuario {
    private final String titulacao;
    private final String senha;

    public Professor(String cpf, String nome, String email, String titulacao, String senha) {
        super(cpf, nome, email);
        this.titulacao = titulacao;
        this.senha = senha;
    }

    public String getTitulacao() { return titulacao; }
    public String getSenha() { return senha; }

    @Override
    public String getDescricao() {
        return "model.Professor: " + nome + " - Titulação: " + titulacao;
    }
}
