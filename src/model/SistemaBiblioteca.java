package model;

import utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SistemaBiblioteca {
    private final Map<String, Usuario> usuarios = new HashMap<>();
    private final Map<String, String> senhas = new HashMap<>();

    public void cadastrarUsuario(Usuario usuario, String senha) {
        usuarios.put(usuario.getCpf(), usuario);
        senhas.put(usuario.getCpf(), senha);
    }

    public Usuario login(String cpf, String senha) {
        if (senhas.containsKey(cpf) && senhas.get(cpf).equals(senha)) {
            return usuarios.get(cpf);
        }
        return null; // Login falhou
    }

    public static ArrayList<Livro> consultarAcervo() {
        ArrayList<String[]> linhas = Util.leitor("src\\livros.csv");
        ArrayList<Livro> livros = new ArrayList<Livro>();
        for (String[] linha : linhas) {
            Livro livro = new Livro(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5], linha[6], linha[7], linha[8]);
            livros.add(livro);
        }
        return livros;
    }

    public static void adicionarLivro(Livro livro) {
        String linha = livro.getTitulo() + "," + livro.getAutores() + "," + livro.getEditora() + "," + livro.getAnoPublicacao() + "," + livro.getNumeroPaginas() + "," + livro.getIsbn() + "," + livro.getGenero() + "," + livro.getSinopse() + "," + livro.getIdioma();
        Util.escritor("src\\livros.csv", linha);
    }

    public static void adicionarProfessor(Professor professor) {
        String linha = professor.getCpf() + "," + professor.getNome() + "," + professor.getEmail() + "," + professor.getTitulacao() + "," + professor.getSenha();
        Util.escritor("src\\professores.csv", linha);
    }

    public static ArrayList<Professor> consultarProfessor() {
        ArrayList<String[]> linhas = Util.leitor("src\\professores.csv");
        ArrayList<Professor> professores = new ArrayList<Professor>();
        for (String[] linha : linhas) {
            Professor professor = new Professor(linha[0], linha[1], linha[2], linha[3], linha[4]);
            professores.add(professor);
        }
        return professores;
    }

    public static void adicionarAluno(Aluno aluno) {
        String linha = aluno.getCpf() + "," + aluno.getNome() + "," + aluno.getEmail() + "," + aluno.getInstituicaoDeEnsino() + "," + aluno.getCurso() + "," + aluno.getNotaENEM();
        Util.escritor("src\\alunos.csv", linha);
    }

    public static ArrayList<Aluno> consultarAluno() {
        ArrayList<String[]> linhas = Util.leitor("src\\alunos.csv");
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();
        for (String[] linha : linhas) {
            Aluno aluno = new Aluno(linha[0], linha[1], linha[2], linha[3], linha[4], linha[5]);
            alunos.add(aluno);
        }
        return alunos;
    }

    public static void adicionarCargo(Cargo cargo) {
        String linha = cargo.getCodigo() + "," + cargo.getNome() + "," + cargo.getDescricao() + "," + cargo.getCargaHoraria();
        Util.escritor("src\\cargos.csv", linha);
    }

    public static ArrayList<Cargo> consultarCargo() {
        ArrayList<String[]> linhas = Util.leitor("src\\cargos.csv");
        ArrayList<Cargo> cargos = new ArrayList<>();
        for (String[] linha : linhas) {
            Cargo cargo = new Cargo(linha[0], linha[1], linha[2], linha[3]);
            cargos.add(cargo);
        }
        return cargos;
    }

    public static void adicionarFuncionario(Funcionario funcionario) {
        String linha = funcionario.getCpf() + "," + funcionario.getNome() + "," + funcionario.getEmail() + "," + funcionario.getCargo().getNome() + "," + funcionario.getSalario();
        Util.escritor("src\\funcionarios.csv", linha);
    }

    public static ArrayList<Funcionario> consultarFuncionario() {
        ArrayList<String[]> linhas = Util.leitor("src\\funcionarios.csv");
        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        for (String[] linha : linhas) {
            Cargo cargo = Util.buscarCargo(linha[3]);
            Funcionario funcionario = new Funcionario(linha[0], linha[1], linha[2], cargo, linha[4]);
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }
}
