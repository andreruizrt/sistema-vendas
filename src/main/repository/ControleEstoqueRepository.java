package main.repository;

import main.domain.Pessoa;
import main.domain.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControleEstoqueRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public int consultaEstoque(int idProduto) {
        String sql = "SELECT ID, QTDESTOQUE FROM PRODUTO_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("ID") == idProduto) {
                    return pstmt.getInt("QTDESTOQUE");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void saidaEstoque(int idProduto, int qtd) throws SQLException {
        PreparedStatement pstmt = null;
        Connection conn = dbRepository.connect();

        String sql = "UPDATE PRODUTO_TR01 SET QTDESTOQUE = ? WHERE ID = ?";
        int estoque = this.consultaEstoque(idProduto);

        if(qtd > estoque) {
            System.out.println("Saiu mais?");
            return;
        } else {
            estoque -= qtd;
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, estoque);
                pstmt.setInt(2, idProduto);

                pstmt.executeUpdate();


            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                conn.close();
            }
        }
    }

    public void entradaEstoque(int idProduto, int qtd) throws SQLException {
        PreparedStatement pstmt = null;
        Connection conn = dbRepository.connect();

        String sql = "UPDATE PRODUTO_TR01 SET QTDESTOQUE = ? WHERE ID = ?";

        qtd += consultaEstoque(idProduto);

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, qtd);
            pstmt.setInt(2, idProduto);

            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }
}
