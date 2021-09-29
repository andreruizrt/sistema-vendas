package main.repository;

import main.domain.Produto;
import main.domain.Venda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendaRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public int registaVenda(Venda venda) {
        String insertSql = "INSERT INTO VENDA_TR01(IDCLIENTE, IDVENDEDOR, DTVENDA) " +
                "VALUES (?, ?, ?)";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setInt(1, venda.getIdCliente());
            pstmt.setInt(2, venda.getIdVendedor());
            pstmt.setString(3, venda.getDtVenda().toString());

            int i = pstmt.executeUpdate();

            System.out.println("Venda cadastrada!");
            return i;
        } catch (SQLException ex) {
            System.out.println("Erro inserindo venda no banco: " + ex.getMessage());
        }
        return -1;
    }

    public void inserirVendaItens(int idVenda, List<Produto> produtoVendidos) {
        Connection conn = dbRepository.connect();

        String insertSql = "INSERT INTO ITEM_VENDA_TR01(IDVENDA, IDPRODUTO, QTDPRODUTO) " +
                "VALUES (?, ?, ?)";

        for (Produto produto : produtoVendidos) {
            try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
                pstmt.setInt(1, idVenda);
                pstmt.setInt(2, produto.getId());
                pstmt.setInt(3, produto.getQtdEstoque());

                pstmt.executeUpdate();
//                System.out.println("Lista de produtos vendido salva com sucesso!");

            } catch (SQLException e) {
                System.out.println("Erro ao inserir lista de produtos: " + e.getMessage());
                return;
            }
        }
    }

    public Venda findVendaById(int id) {
        String sql = "SELECT * FROM VENDA_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("ID") == id) {
                    Venda venda = new Venda();
                    venda.setId(pstmt.getInt("ID"));
                    venda.setIdVendedor(pstmt.getInt("IDVENDEDOR"));
//                    venda.setDtVenda(pstmt.getString("DTVENDA"));
                    venda.setProdutos(this.retornaProdutoVenda(venda.getId()));

                    return venda;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    private List<Produto> retornaProdutoVenda(int id) {
        String sql = "SELECT IDVENDA, IDPRODUTO FROM ITEM_VENDA_TR01";
        ProdutoRepository produtoService = new ProdutoRepository();
        List<Produto> produtoList = new ArrayList<>();

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("IDVENDA") == id) {
                    int idProduto = pstmt.getInt("IDPRODUTO");
                    produtoList.add(produtoService.findProdutoById(idProduto));
                }
            }

            return (produtoList);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void deleteVendaById(int id) {
        String sql = "DELETE FROM VENDA_TR01 WHERE ID = ?";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
