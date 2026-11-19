package br.com.starlog.main;

import br.com.starlog.dao.ProdutoDAO;
import br.com.starlog.dao.ProdutoDAOSqlite;
import br.com.starlog.model.Produto;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final String ARQUIVO_DB = "starlog_almoxarifado.db";
    private static final String JDBC_URL = "jdbc:sqlite:" + ARQUIVO_DB;

    public static void main(String[] args) {
        resetarBancoParaExecucaoLimpa();

        ProdutoDAO dao = new ProdutoDAOSqlite(JDBC_URL);

        // 1. [Create]
        System.out.println("=== 1. [CREATE] CADASTRANDO PRODUTOS ===");
        Produto teclado = new Produto("Teclado Mecânico RGB", 349.90, 10);
        Produto mousepad = new Produto("Mousepad Speed XL", 119.50, 25);

        dao.salvar(teclado);
        dao.salvar(mousepad);

        System.out.printf("Salvo -> %s (ID gerado: %d)%n", teclado.getNome(), teclado.getId());
        System.out.printf("Salvo -> %s (ID gerado: %d)%n%n", mousepad.getNome(), mousepad.getId());

        // 2. [Read]
        System.out.println("=== 2. [READ] LISTAGEM INICIAL (ORDENADA POR NOME ASC) ===");
        imprimirTabela(dao.listarTodos());
        System.out.println();

        // 3. [Update]
        System.out.println("=== 3. [UPDATE] ATUALIZANDO TECLADO MECÂNICO RGB ===");
        teclado.setEstoque(15);
        teclado.setPreco(289.90);

        boolean atualizou = dao.atualizar(teclado);
        System.out.println("Retorno de atualizar(teclado): " + atualizou);

        Optional<Produto> tecladoAtualizado = dao.buscarPorId(teclado.getId());
        tecladoAtualizado.ifPresent(p -> System.out.println("Registro atualizado no banco: " + p));
        System.out.println();

        // 4. [Delete]
        System.out.println("=== 4. [DELETE] REMOVENDO MOUSEPAD E TESTANDO ID INEXISTENTE ===");
        boolean removeuMousepad = dao.excluir(mousepad.getId());
        System.out.printf("Exclusão do Mousepad (ID %d): %s%n", mousepad.getId(), removeuMousepad);

        Long idInexistente = 888L;
        boolean removeuInexistente = dao.excluir(idInexistente);
        if (!removeuInexistente) {
            System.out.printf("Aviso amigável: Nenhum produto encontrado com o ID %d para exclusão (retorno: false).%n", idInexistente);
        }
        System.out.println();

        // 5. [Final State]
        System.out.println("=== 5. [FINAL STATE] ESTADO FINAL DO ALMOXARIFADO ===");
        List<Produto> restantes = dao.listarTodos();
        imprimirTabela(restantes);
        System.out.println("Total de produtos restantes no banco: " + restantes.size());
    }

    private static void imprimirTabela(List<Produto> produtos) {
        System.out.printf("%-6s | %-28s | %-12s | %-8s%n", "ID", "NOME", "PREÇO", "ESTOQUE");
        System.out.println("-------+------------------------------+--------------+---------");
        for (Produto p : produtos) {
            System.out.printf("%-6d | %-28s | R$ %8.2f | %-8d%n", p.getId(), p.getNome(), p.getPreco(), p.getEstoque());
        }
    }

    private static void resetarBancoParaExecucaoLimpa() {
        try {
            Files.deleteIfExists(Path.of(ARQUIVO_DB));
        } catch (IOException e) {
            System.err.println("Aviso: não foi possível apagar o arquivo anterior do banco: " + e.getMessage());
        }
    }
}