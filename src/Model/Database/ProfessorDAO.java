
package Model.Database;

import Model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProfessorDAO {

    Professor p;

    private Connection connection;
    private ResultSet rs;
    private PreparedStatement pstm;

    public ProfessorDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    public String checkEmailExists(String email) {
        
        String emailResult = "";
        String sql = "SELECT u.email FROM usuario u WHERE u.email = (?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            pstm.execute();
            rs = pstm.getResultSet();
            
            while (rs.next()) {
                emailResult = rs.getString(1);
            }
            
            pstm.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return emailResult;
        
    }
    
    public Professor getProfessor(String email) {

        p = new Professor();

        String sql = "SELECT u.email, u.nome, u.senha, u.papel, u .status, p.departamento, p.disciplina_principal FROM usuario u, professor p WHERE"
                + " u.email = (?) and u.email = p.email";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                p.setEmail(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setPapel(rs.getString(4));
                p.setStatus(rs.getString(5));
                p.setDepartamento(rs.getString(6));
                p.setDisciplinaPrincipal(rs.getString(7));
            }

            }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return p;
    }

    public ArrayList<Professor> getProfessores() {

        ArrayList<Professor> professores = new ArrayList<>();

        String sql = "SELECT u.email, u.nome, u.senha, u.papel, u .status, p.departamento, p.disciplina_principal "
                + "FROM usuario u, professor p WHERE u.papel = 'Professor' and u.email = p.email";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                p = new Professor();
                p.setEmail(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setPapel(rs.getString(4));
                p.setStatus(rs.getString(5));
                p.setDepartamento(rs.getString(6));
                p.setDisciplinaPrincipal(rs.getString(7));
                professores.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return professores;
    }

    public ArrayList<Professor> getProfessoresAtivos() {

        ArrayList<Professor> professores = new ArrayList<>();

        String sql = "SELECT u.email, u.nome, u.senha, u.papel, u .status, p.departamento, p.disciplina_principal FROM usuario u, professor p WHERE u.email = p.email AND u.status = 'Ativo'";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.execute();
            rs = pstm.getResultSet();

            while (rs.next()) {
                p = new Professor();
                p.setEmail(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setSenha(rs.getString(3));
                p.setPapel(rs.getString(4));
                p.setStatus(rs.getString(5));
                p.setDepartamento(rs.getString(6));
                p.setDisciplinaPrincipal(rs.getString(7));
                professores.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return professores;
    }

    public boolean addProfessor(Professor p) {

        new UsuarioDAO().addUsuario(p);

        String sql = "INSERT INTO professor (email, departamento, disciplina_principal)"
                + " VALUES (?, ?, ?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, p.getEmail());
            pstm.setString(2, p.getDepartamento());
            pstm.setString(3, p.getDisciplinaPrincipal());

            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
//            throw new RuntimeException(e);
            return false;
        }

        return true;
    }

    public boolean editProfessor(Professor p) {

        boolean check1 = false, check2 = false;
        
        // update na tabela usuario
        String sql = "UPDATE usuario SET nome = (?), senha = (?), ultima_modificacao = curdate(), status = (?) WHERE usuario.email = (?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getSenha());
            pstm.setString(3, p.getStatus());
            pstm.setString(4, p.getEmail());
            
            pstm.execute();
            pstm.close();

            check1 = true;
        } catch (SQLException e) {
            check1 = false;
//            throw new RuntimeException(e);
        }
        
        // update na tabela professor
        sql = "UPDATE professor SET departamento = (?), disciplina_principal = (?) WHERE professor.email = (?)";
        
        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, p.getDepartamento());
            pstm.setString(2, p.getDisciplinaPrincipal());
            pstm.setString(3, p.getEmail());
            
            pstm.execute();
            pstm.close();

            check2 = true;
        } catch (SQLException e) {
            check2 = false;
//            throw new RuntimeException(e);
        }
        
        
        if (!check1 || !check2) return false;
        else return true;
    }

    public boolean deleteProfessor(String email) {
        
        // verificar como fica a questao de o Professor estar em um Projeto

        String sql = "UPDATE usuario SET status = 'Inativo' WHERE usuario.email = (?)";

        try {
            pstm = connection.prepareStatement(sql);
            pstm.setString(1, email);

            pstm.execute();
            pstm.close();

        } catch (SQLException e) {
            return false;
//            throw new RuntimeException(e);
        }

        return true;

    }
}
