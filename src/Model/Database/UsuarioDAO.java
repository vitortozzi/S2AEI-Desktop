/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Database;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vítor
 */
public class UsuarioDAO {

    private Usuario u;
    
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement pstm;

    public UsuarioDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    public void addUsuario(Usuario u) {

        String sql = "INSERT INTO usuario (email, nome, senha, data_cadastro, ultima_modificacao, papel, status)"
                + " VALUES (?, ?, ?, curdate(), curdate(), ?, 'Ativo')";

        try {
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getPapel());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Usuario getUsuario(String email) {

        u = new Usuario();

        String sql = "SELECT u.email, u.nome, u.senha, u.papel, u.status FROM usuario u WHERE"
                + " u.email = (?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                u.setEmail(rs.getString(1));
                u.setNome(rs.getString(2));
                u.setSenha(rs.getString(3));
                u.setPapel(rs.getString(4));
                u.setStatus(rs.getString(5));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return u;
    }
    
    public void activateUser(String email) {
        
        String sql = "UPDATE usuario SET status = 'Ativo' WHERE email = (?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    
}
