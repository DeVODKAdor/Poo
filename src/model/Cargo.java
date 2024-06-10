package model;

public class Cargo {
    private final int codigo;
    private final String nome;
    private final String descricao;
    private final int cargaHoraria;

    public Cargo(int codigo, String nome, String descricao, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public int getCargaHoraria() { return cargaHoraria; }
}