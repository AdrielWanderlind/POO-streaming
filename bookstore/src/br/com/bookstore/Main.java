package br.com.bookstore;

import br.com.bookstore.dao.LivroDAO;
import br.com.bookstore.dao.LivroDAOSqlite;
import br.com.bookstore.model.Livro;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Instanciação aplicando Inversão de Dependência (DIP)
        LivroDAO dao = new LivroDAOSqlite();

        System.out.println("=== 1. INSERINDO LIVROS NO BANCO SEGURO ===");
        Livro l1 = new Livro("Clean Code", "Robert C. Martin", 120.00);
        Livro l2 = new Livro("Design Patterns", "Erich Gamma et al.", 150.50);
        Livro l3 = new Livro("Refactoring", "Martin Fowler", 135.90);

        dao.salvar(l1);
        dao.salvar(l2);
        dao.salvar(l3);

        System.out.println("Cadastrado: " + l1);
        System.out.println("Cadastrado: " + l2);
        System.out.println("Cadastrado: " + l3);

        System.out.println("\n=== 2. CONSULTANDO REGISTRO EXISTENTE (ID: 2) ===");
        dao.buscarPorId(2L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Livro não encontrado.")
        );

        System.out.println("\n=== 3. CONSULTANDO REGISTRO INEXISTENTE (ID: 999) ===");
        dao.buscarPorId(999L).ifPresentOrElse(
            livro -> System.out.println("Encontrado: " + livro),
            () -> System.out.println("Aviso: Livro com ID 999 não foi localizado no banco.")
        );

        System.out.println("\n=== 4. LISTAGEM COMPLETA DO CATÁLOGO ===");
        List<Livro> todos = dao.listarTodos();
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-5s | %-20s | %-22s | %-10s%n", "ID", "TÍTULO", "AUTOR", "PREÇO");
        System.out.println("------------------------------------------------------------------");
        for (Livro livro : todos) {
            System.out.printf("%-5d | %-20s | %-22s | R$ %-8.2f%n",
                    livro.getId(), livro.getTitulo(), livro.getAutor(), livro.getPreco());
        }
        System.out.println("------------------------------------------------------------------");
    }
}   