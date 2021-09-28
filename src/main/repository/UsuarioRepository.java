package main.repository;

import main.domain.Usuario;

import java.sql.*;

public class UsuarioRepository {
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
}