package model;

public class Cargo {
    private final String codigo;
    private final String nome;
    private final String descricao;
    private final String cargaHoraria;

    public Cargo(String codigo, String nome, String descricao, String cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public String getCargaHoraria() { return cargaHoraria; }
}