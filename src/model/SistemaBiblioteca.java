package model;

import utils.Util;

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

    public void consultarAcervo(Professor professor) {
        // Implementar consulta ao acervo
    }

    public static void adicionarLivro(Livro livro) {
        String linha = livro.getTitulo() + "," + livro.getAutores() + "," + livro.getEditora() + "," + livro.getAnoPublicacao() + "," + livro.getNumeroPaginas() + "," + livro.getIsbn() + "," + livro.getGenero() + "," + livro.getSinopse() + "," + livro.getIdioma();
        Util.escritor("src\\livros.csv", linha);
    }

    public void executarFuncionalidades(Funcionario funcionario) {
        // Implementar funcionalidades completas para funcionários
    }
}
