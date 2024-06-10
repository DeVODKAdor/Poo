package model;

public class Livro {
    private String titulo;
    private String autores;
    private String editora;
    private String anoPublicacao;
    private String numeroPaginas;
    private String isbn;
    private String genero;
    private String sinopse;
    private String idioma;

    public Livro(String titulo, String autores, String editora, String anoPublicacao, String numeroPaginas, String isbn, String genero, String sinopse, String idioma) {
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.genero = genero;
        this.sinopse = sinopse;
        this.idioma = idioma;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getTitulo() { return titulo; }
    public String getAutores() { return autores; }
    public String getEditora() { return editora; }
    public String getAnoPublicacao() { return anoPublicacao; }
    public String getNumeroPaginas() { return numeroPaginas; }
    public String getIsbn() { return isbn; }
    public String getGenero() { return genero; }
    public String getSinopse() { return sinopse; }
    public String getIdioma() { return idioma; }
}
