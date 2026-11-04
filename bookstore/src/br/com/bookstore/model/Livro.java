package br.com.bookstore.model;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    // Construtor Completo (utilizado na hidratação vinda do banco de dados)
    public Livro(Long id, String titulo, String autor, double preco) {
        validarInvariantes(titulo, autor, preco);
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    // Construtor de Negócio (para novos cadastros onde o ID ainda não existe)
    public Livro(String titulo, String autor, double preco) {
        this(null, titulo, autor, preco);
    }

    // Validação de invariantes de domínio
    private void validarInvariantes(String titulo, String autor, double preco) {
        if (titulo == null || titulo.trim().length() < 2) {
            throw new IllegalArgumentException("O título não pode ser nulo ou ter menos de 2 caracteres.");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("O autor não pode ser nulo ou vazio.");
        }
        if (preco <= 0.0) {
            throw new IllegalArgumentException("O preço de venda deve ser estritamente positivo.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return String.format("Livro [ID: %d | Título: '%s' | Autor: '%s' | Preço: R$ %.2f]",
                id, titulo, autor, preco);
    }
}