package model;

public class Funcionario extends Usuario {
    private final Cargo cargo;
    private final String salario;

    public Funcionario(String cpf, String nome, String email, Cargo cargo, String salario) {
        super(cpf, nome, email);
        this.cargo = cargo;
        this.salario = salario;
    }

    public Cargo getCargo() { return cargo; }
    public String getSalario() { return salario; }

    @Override
    public String getDescricao() {
        return "Funcionário: " + nome + " - model.Cargo: " + cargo.getNome();
    }
}