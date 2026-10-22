
package br.com.autotech.dao;

import br.com.autotech.factory.ConexaoFactory;
import br.com.autotech.model.Peca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PecaDao {

    // MISSAO 1: Criar tabela
    public void criarTabelaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS pecas (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                codigo TEXT UNIQUE NOT NULL,
                nome TEXT NOT NULL,
                preco REAL NOT NULL,
                estoque INTEGER NOT NULL
            );
        """;

        try (Connection conn = ConexaoFactory.obterConexao();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);
            System.out.println("Tabela pecas criada/verificada!");

        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    // MISSAO 2: Salvar peca e recuperar ID
    public Peca salvar(Peca peca) {
        String sql = "INSERT INTO pecas (codigo, nome, preco, estoque) VALUES (?, ?, ?, ?);";

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, peca.getCodigo());
            stmt.setString(2, peca.getNome());
            stmt.setDouble(3, peca.getPreco());
            stmt.setInt(4, peca.getEstoque());

            int linhas = stmt.executeUpdate();

            if (linhas > 0) {
                try (ResultSet chaves = stmt.getGeneratedKeys()) {
                    if (chaves.next()) {
                        peca.setId(chaves.getLong(1));
                    }
                }

                System.out.println("Peca salva com sucesso! ID: " + peca.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar peca: " + e.getMessage());
        }

        return peca;
    }

    // MISSAO 3: Listar todas as pecas
    public List<Peca> listarTodas() {
        List<Peca> lista = new ArrayList<>();

        String sql = "SELECT id, codigo, nome, preco, estoque FROM pecas ORDER BY nome;";

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Peca p = new Peca(
                    rs.getLong("id"),
                    rs.getString("codigo"),
                    rs.getString("nome"),
                    rs.getDouble("preco"),
                    rs.getInt("estoque")
                );

                lista.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar pecas: " + e.getMessage());
        }

        return lista;
    }

    // MISSAO 4: Buscar peca pelo codigo
    public Peca buscarPorCodigo(String codigo) {
        String sql = "SELECT id, codigo, nome, preco, estoque FROM pecas WHERE codigo = ?;";

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, codigo);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Peca(
                        rs.getLong("id"),
                        rs.getString("codigo"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("estoque")
                    );
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar peca: " + e.getMessage());
        }

        return null;
    }

    // MISSAO 5: Dar baixa no estoque
    public boolean darBaixaEstoque(Long id, int quantidadeRetirada) {
        if (id == null || quantidadeRetirada <= 0) {
            return false;
        }

        String sql = "UPDATE pecas SET estoque = estoque - ? WHERE id = ? AND estoque >= ?;";

        try (Connection conn = ConexaoFactory.obterConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, quantidadeRetirada);
            stmt.setLong(2, id);
            stmt.setInt(3, quantidadeRetirada);

            int linhas = stmt.executeUpdate();

            return linhas > 0;

        } catch (SQLException e) {
            System.err.println("Erro ao dar baixa no estoque: " + e.getMessage());
            return false;
        }
    }
}
