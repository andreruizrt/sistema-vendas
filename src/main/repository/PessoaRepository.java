package main.repository;

import main.domain.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public void cadastraPessoa(Pessoa pessoa, String tipoCVF) {

        String sql = "INSERT INTO PESSOA_TR01(NOME, CPFCNPJ,  EMAIL, " +
                "TELEFONE, RUA, NUMERO, COMPLEMENTO, BAIRRO, " +
                "CIDADE, UF, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpfCnpj());
            pstmt.setString(3, pessoa.getEmail());
            pstmt.setString(4, pessoa.getTelefone());
            pstmt.setString(5, pessoa.getRua());
            pstmt.setInt(6, pessoa.getNumero());
            pstmt.setString(7, pessoa.getComplemento());
            pstmt.setString(8, pessoa.getBairro());
            pstmt.setString(9, pessoa.getCidade());
            pstmt.setString(10, pessoa.getUf());
            pstmt.setString(11, tipoCVF);

            pstmt.executeUpdate();

            System.out.println("\n[*] Pessoa cadastrado com sucesso!");
            dbRepository.disconnect(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Pessoa> carregaPessoaPorTipo(String tipoCFV) {
        List<Pessoa> pessoasList = new ArrayList<>();
        String sql = "SELECT ID, NOME, CPFCNPJ, EMAIL, TELEFONE, RUA, NUMERO, " +
                "COMPLEMENTO, BAIRRO, CIDADE, UF, TIPO FROM PESSOA_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getString("TIPO").equalsIgnoreCase(tipoCFV)) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(pstmt.getInt("ID"));
                    pessoa.setNome(pstmt.getString("NOME"));
                    pessoa.setCpfCnpj(pstmt.getString("CPFCNPJ"));
                    pessoa.setEmail(pstmt.getString("EMAIL"));
                    pessoa.setTelefone(pstmt.getString("TELEFONE"));
                    pessoa.setRua(pstmt.getString("RUA"));
                    pessoa.setNumero(pstmt.getInt("NUMERO"));
                    pessoa.setComplemento(pstmt.getString("COMPLEMENTO"));
                    pessoa.setBairro(pstmt.getString("BAIRRO"));
                    pessoa.setCidade(pstmt.getString("CIDADE"));
                    pessoa.setUf(pstmt.getString("UF"));

                    pessoasList.add(pessoa);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return (pessoasList);
    }

    public Pessoa findPessoaById(Integer id, String tipoCVF) {
        Pessoa pessoa = new Pessoa();
        String sql = "SELECT ID, NOME, CPFCNPJ, EMAIL, TELEFONE, RUA, NUMERO," +
                " COMPLEMENTO, BAIRRO, CIDADE, UF, TIPO FROM PESSOA_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("ID") == id
                        && pstmt.getString("TIPO").equalsIgnoreCase(tipoCVF)) {
                    pessoa.setId(pstmt.getInt("ID"));
                    pessoa.setNome(pstmt.getString("NOME"));
                    pessoa.setCpfCnpj(pstmt.getString("CPFCNPJ"));
                    pessoa.setEmail(pstmt.getString("EMAIL"));
                    pessoa.setTelefone(pstmt.getString("TELEFONE"));
                    pessoa.setRua(pstmt.getString("RUA"));
                    pessoa.setNumero(pstmt.getInt("NUMERO"));
                    pessoa.setComplemento(pstmt.getString("COMPLEMENTO"));
                    pessoa.setBairro(pstmt.getString("BAIRRO"));
                    pessoa.setCidade(pstmt.getString("CIDADE"));
                    pessoa.setUf(pstmt.getString("UF"));

                    return pessoa;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void updatePessoaById(Pessoa pessoa, String tipoCFV) throws SQLException {

        PreparedStatement pstmt = null;
        DatabaseRepository dbRepository = new DatabaseRepository();
        Connection conn = dbRepository.connect();

        String sql = "UPDATE PESSOA_TR01 SET NOME = ?, CPFCNPJ = ?, EMAIL = ?," +
                "TELEFONE = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?" +
                "CIDADE = ?, UF = ? WHERE ID = ? AND TIPO = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pessoa.getNome());
            pstmt.setString(2, pessoa.getCpfCnpj());
            pstmt.setString(4, pessoa.getEmail());
            pstmt.setString(5, pessoa.getTelefone());
            pstmt.setString(6, pessoa.getRua());
            pstmt.setInt(7, pessoa.getNumero());
            pstmt.setString(8, pessoa.getComplemento());
            pstmt.setString(9, pessoa.getBairro());
            pstmt.setString(10, pessoa.getCidade());
            pstmt.setString(11, pessoa.getUf());
            pstmt.setInt(12, pessoa.getId());
            pstmt.setString(13, tipoCFV);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void deletePessoaById(Integer id, String tipoCFV) {
        String sql = "DELETE FROM PESSOA_TR01 WHERE ID = ? AND TIPO = ?";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, tipoCFV);

            pstmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


