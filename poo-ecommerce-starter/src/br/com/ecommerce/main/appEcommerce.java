package br.com.ecommerce.main;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.ecommerce.model.Produto;

public class appEcommerce {
    public static void main(String[] args) {
        System.out.println("===Bem vindo ao Ecommerce===");
        List<Produto> carrinho = new ArrayList<>();
        List<Produto> favoritos = new ArrayList<>();

        carrinho.add(new Produto("Filtro de Óleo Yamaha R3", 85.00));
        carrinho.add(new Produto("Camisa do Corinthians", 299.90));
        carrinho.add(new Produto("Bola de Basquete", 150.00));
        carrinho.add(new Produto("Bolha Esportiva R3", 350.00));

        System.out.println("Carrinho cheio!");
    
        
        Set<Produto> favoritos2 = new HashSet<>();
        Produto bola = new Produto("Bola de Basquete", 150.00);
        Produto tenis = new Produto("Jordan 1",500.00);

        favoritos.add(tenis);
        favoritos.add(tenis); 
        favoritos2.add(bola);
        favoritos2.add(bola); 

        Set<Produto> favoritos3 = new HashSet<>();
        Produto p1 = new Produto("cap",500.00);
        Produto p2 = new Produto("cap",500.00);
        Produto p3 = new Produto("cap",500.00);

        favoritos3.add(p1);
        favoritos3.add(p2);
        favoritos3.add(p3);
        System.out.println("Tamanho dos favoritos 1: " + favoritos.size());
        System.out.println("Tamanho dos favoritos 2: " + favoritos2.size()); // Imprime 1
        System.out.println("Tamanho (bug do hashset): " + favoritos3.size());
        }
}
