package main.repository;

import main.domain.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public void cadastraPessoa(Pessoa pessoa, String tipoCVF) {
        String sql = "INSERT INTO NOME = ?, CPFCNPJ = ?, EMAIL = ?," +
                "TELEFONE = ?, RUA = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?," +
                " CIDADE = ?, UF = ?, TIPO = ? FROM PESSOA_TR01";

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
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getString("TIPO").equalsIgnoreCase(tipoCFV)) {
                    Pessoa pessoa = new Pessoa();
                    pessoa.setId(rs.getInt("ID"));
                    pessoa.setNome(rs.getString("NOME"));
                    pessoa.setCpfCnpj(rs.getString("CPFCNPJ"));
                    pessoa.setEmail(rs.getString("EMAIL"));
                    pessoa.setTelefone(rs.getString("TELEFONE"));
                    pessoa.setRua(rs.getString("RUA"));
                    pessoa.setNumero(rs.getInt("NUMERO"));
                    pessoa.setComplemento(rs.getString("COMPLEMENTO"));
                    pessoa.setBairro(rs.getString("BAIRRO"));
                    pessoa.setCidade(rs.getString("CIDADE"));
                    pessoa.setUf(rs.getString("UF"));

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
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getInt("ID") == id
                        && rs.getString("TIPO").equalsIgnoreCase(tipoCVF)) {
                    pessoa.setId(rs.getInt("ID"));
                    pessoa.setNome(rs.getString("NOME"));
                    pessoa.setCpfCnpj(rs.getString("CPFCNPJ"));
                    pessoa.setEmail(rs.getString("EMAIL"));
                    pessoa.setTelefone(rs.getString("TELEFONE"));
                    pessoa.setRua(rs.getString("RUA"));
                    pessoa.setNumero(rs.getInt("NUMERO"));
                    pessoa.setComplemento(rs.getString("COMPLEMENTO"));
                    pessoa.setBairro(rs.getString("BAIRRO"));
                    pessoa.setCidade(rs.getString("CIDADE"));
                    pessoa.setUf(rs.getString("UF"));

                    return pessoa;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}


