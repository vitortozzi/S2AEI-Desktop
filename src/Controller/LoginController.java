
package Controller;

import Model.Database.AdministradorDAO;
import Model.Database.UsuarioDAO;
import Model.Tabelas.Administrador;
import Model.Tabelas.Usuario;

public class LoginController {
    
     public int checkUser(String userEmail, String userPass) {
        
        UsuarioDAO usrDAO = new UsuarioDAO();
        
        if (userEmail.equals("") || userPass.equals(""))
            return 0;
        
        String usrPapel = usrDAO.checkLogin(userEmail, userPass);
        
        
        /*
            0 = erro, campos email e/ou senha em branco
            1 = erro, usuario nao encontrado
            2 = sucesso, administrador
            3 = sucesso, avaliador
            4 = sucesso, professor
        */
        Usuario u = new Usuario();
        Sessao session = Sessao.getInstance();
        u.setEmail(userEmail);
        
        
        int intUsrPapel;
        switch(usrPapel) {
            case "":
                intUsrPapel = 1; // erro, usuario nao encontrado
            break;
                
            case "Administrador":
                intUsrPapel = 2; // sucesso, administrador
                u.setPapel("Administrador");
                session.setUsuario(u);
            break;
                
            case "Avaliador":
                u.setPapel("Avaliador");
                session.setUsuario(u);
                intUsrPapel = 3; // sucesso, avaliador
            break;
                
            case "Professor":
                u.setPapel("Professor");
                session.setUsuario(u);
                intUsrPapel = 4; // sucesso, professor
            break;
            
            default:
                intUsrPapel = 1; // erro desconhecido, default eh 1
            break;
        }
        
        return intUsrPapel;
    }
    
}
