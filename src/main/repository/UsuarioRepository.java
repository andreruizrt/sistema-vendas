package main.repository;

import main.domain.Usuario;

import java.sql.*;

public class UsuarioRepository {
    DatabaseRepository dbRepository = new DatabaseRepository();

    public void cadastraUsuario(Usuario usuario) {
        String sql = "INSERT INTO USUARIO_TR01(USUARIO, SENHA, IDVENDEDOR) VALUES (?, ?, ?)";
        DatabaseRepository dbRepository = new DatabaseRepository();

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getIdVendedor());
            pstmt.executeUpdate();

            System.out.println("\n[*] Usuário cadastrado com sucesso!");
            dbRepository.disconnect(conn);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Usuario verificaCredenciais(Usuario usuario) {
        Usuario usuarioLogado = new Usuario();
        String sql = "SELECT * FROM USUARIO_TR01";

        DatabaseRepository dbRepository = new DatabaseRepository();
        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getString("USUARIO").equals(usuario.getUsuario())) {
                    if (rs.getString("SENHA").equals(usuario.getSenha())) {
                        usuarioLogado.setUsuario(rs.getString("USUARIO"));
                        usuarioLogado.setIdVendedor(rs.getInt("IDVENDEDOR"));
                        return usuarioLogado;
                    } else {
                        return null;
                    }
                } else {
                   return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Usuario findUsuarioById(int id) {
        String sql = "SELECT ID, USUARIO, SENHA, IDVENDEDOR FROM USUARIO_TR01";

        try (Connection conn = dbRepository.connect();
             Statement stmt = conn.createStatement();
             ResultSet pstmt = stmt.executeQuery(sql)) {

            while (pstmt.next()) {
                if (pstmt.getInt("ID") == id) {
                    Usuario usuario = new Usuario();
                    usuario.setId(pstmt.getInt("ID"));
                    usuario.setUsuario(pstmt.getString("USUARIO"));
                    usuario.setSenha("******");
                    usuario.setIdVendedor(pstmt.getInt("IDVENDEDOR"));

                    usuario.toString();
                    return usuario;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public void updateUsuarioById(Usuario usuario) throws SQLException {

        PreparedStatement pstmt = null;
        DatabaseRepository dbRepository = new DatabaseRepository();
        Connection conn = dbRepository.connect();

        String sql = "UPDATE USUARIO_TR01 SET USUARIO = ?, SENHA = ?, IDVENDEDOR = ?" +
                " WHERE ID = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(4, usuario.getIdVendedor());
            pstmt.setInt(5, usuario.getId());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

    public void deleteUsuarioById(int id) {
        String sql = "DELETE FROM USUARIO_TR01 WHERE ID = ?";

        try (Connection conn = dbRepository.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);

            pstmt.execute();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}