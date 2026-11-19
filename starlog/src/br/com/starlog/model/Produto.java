package br.com.starlog.model;

import java.util.Objects;

public class Produto {

    private Long id;
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        validarNome(nome);
        validarPreco(preco);
        validarEstoque(estoque);

        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    public Produto(Long id, String nome, double preco, int estoque) {
        validarNome(nome);
        validarPreco(preco);
        validarEstoque(estoque);

        this.id = id;
        this.nome = nome.trim();
        this.preco = preco;
        this.estoque = estoque;
    }

    private void validarNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException(
                "O nome do produto deve ser não nulo e ter pelo menos 3 caracteres."
            );
        }
    }

    private void validarPreco(double preco) {
        if (preco <= 0.0) {
            throw new IllegalArgumentException(
                "O preço do produto deve ser maior que 0.0. Valor informado: " + preco
            );
        }
    }

    private void validarEstoque(int estoque) {
        if (estoque < 0) {
            throw new IllegalArgumentException(
                "O estoque do produto não pode ser negativo. Valor informado: " + estoque
            );
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        validarPreco(preco);
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        validarEstoque(estoque);
        this.estoque = estoque;
    }

    @Override
    public String toString() {
        return String.format(
            "Produto{id=%d, nome='%s', preco=R$ %.2f, estoque=%d}",
            id, nome, preco, estoque
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}