package model;

public abstract class Usuario {
    protected String cpf;
    protected String nome;
    protected String email;

    public Usuario(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }

    // Método abstrato para descrição do usuário
    public abstract String getDescricao();
}
