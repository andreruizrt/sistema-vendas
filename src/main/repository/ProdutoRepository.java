package main.repository;

import main.domain.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public void cadatraProduto(Produto produto) {

        String sql = "INSERT INTO PRODUTO_TR01(DESCRICAO, CODIGOBARRAS, FABRICANTE," +
                " QTDESTOQUE, PRECO) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getDescricao());
            pstmt.setString(2, produto.getCodigoBarras());
            pstmt.setString(3, produto.getFabricante());
            pstmt.setInt(4, produto.getQtdEstoque());
            pstmt.setDouble(5, produto.getPreco());

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
}
