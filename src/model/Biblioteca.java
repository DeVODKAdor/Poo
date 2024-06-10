package model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }
}
