
package Model.Database;

import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                + " VALUES (?, ?, ?, curdate(), curdate(), ?, ?)";

        try {
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, u.getEmail());
            pstm.setString(2, u.getNome());
            pstm.setString(3, u.getSenha());
            pstm.setString(4, u.getPapel());
            pstm.setString(5, u.getStatus());

            pstm.execute();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
