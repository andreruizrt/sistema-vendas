package main.repository;

import main.domain.Compra;
import main.domain.Produto;

import java.sql.*;
import java.util.List;

public class CompraRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public int registaCompra(Compra compra) {
        String insertSql = "INSERT INTO COMPRA_TR01(IDFORNECEDOR, DTCOMPRA) " +
                "VALUES (?, ?)";


        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setInt(1, compra.getIdFornecedor());
            pstmt.setString(2, compra.getDtCompra().toString());

            pstmt.executeUpdate();

            String getIdSql = "SELECT IDCOMPRA FROM COMPRA_TR01";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(getIdSql)) {

                return rs.getInt("IDCOMPRA");

            } catch (SQLException e) {
                System.out.println("Erro buscando id da compra: " + e.getMessage());
            }
        } catch (SQLException ex) {
            System.out.println("Erro inserindo compra no banco: " + ex.getMessage());
        }

        return -1;
    }

    public void inserirCompraItens(int idCompra, List<Produto> produtoComprados) throws SQLException {
        Connection conn = dbRepository.connect();

        String insertSql = "INSERT INTO ITEM_COMPRA_TR01(IDCOMPRA, IDPRODUTO, QTDPRODUTO) " +
                "VALUES (?, ?, ?)";

        for (Produto produto : produtoComprados) {
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, idCompra);
                pstmt.setInt(2, produto.getId());
                pstmt.setInt(3, produto.getQtdEstoque());

                pstmt.executeUpdate();
                System.out.println("Lista de produtos comprados salva com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao inserir lista de produtos: " + e.getMessage());
                return;
            }
        }
    }
}
