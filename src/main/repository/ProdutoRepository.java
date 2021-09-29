package main.repository;

import main.domain.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public void cadatraProduto(Produto produto) {

        String sql = "INSERT INTO PRODUTO_TR01(DESCRICAO, CODIGOBARRAS, FABRICANTE," +
                " QTDESTOQUE, PRECO) VALUES (?, ?, ?, 0, ?)";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getDescricao());
            pstmt.setString(2, produto.getCodigoBarras());
            pstmt.setString(3, produto.getFabricante());
            pstmt.setDouble(4, produto.getPreco());

            pstmt.executeUpdate();

            System.out.println("\n[*] Produto cadastrado com sucesso!");
            dbRepository.disconnect(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Produto> carregaProdutos() throws SQLException {
        String sql = "SELECT * FROM PRODUTO_TR01";
        List<Produto> produtoList = new ArrayList<>();

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("ID"));
                produto.setDescricao(rs.getString("DESCRICAO"));
                produto.setCodigoBarras(rs.getString("CODIGOBARRAS"));
                produto.setFabricante(rs.getString("FABRICANTE"));
                produto.setQtdEstoque(rs.getInt("QTDESTOQUE"));
                produto.setPreco(rs.getDouble("PRECO"));

                produtoList.add(produto);
            }
        }
        return (produtoList);
    }

    public Produto findProdutoById(int id) {
        String sql = "SELECT * FROM PRODUTO_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("ID") == id) {
                    Produto produto = new Produto();
                    produto.setId(pstmt.getInt("ID"));
                    produto.setDescricao(pstmt.getString("DESCRICAO"));
                    produto.setCodigoBarras(pstmt.getString("CODIGOBARRAS"));
                    produto.setFabricante(pstmt.getString("FABRICANTE"));
                    produto.setQtdEstoque(pstmt.getInt("QTDESTOQUE"));
                    produto.setPreco(pstmt.getDouble("PRECO"));

                    return produto;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }

    public void updateProdutoById(Produto produto, int id) throws SQLException {

        PreparedStatement pstmt = null;
        DatabaseRepository dbRepository = new DatabaseRepository();
        Connection conn = dbRepository.connect();

        String sql = "UPDATE PRODUTO_TR01 SET DESCRICAO = ?, CODIGOBARRAS = ?, FABRICANTE = ?," +
                " QTDESTOQUE = ?, PRECO = ? WHERE ID = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, produto.getDescricao());
            pstmt.setString(2, produto.getCodigoBarras());
            pstmt.setString(3, produto.getFabricante());
            pstmt.setInt(4, produto.getQtdEstoque());
            pstmt.setDouble(5, produto.getPreco());
            pstmt.setInt(6, produto.getId());

            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void deleteProdutoById(int id) {
        String sql = "DELETE FROM PRODUTO_TR01 WHERE ID = ?";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
