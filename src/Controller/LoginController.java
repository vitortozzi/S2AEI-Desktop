
package Controller;

import Model.Negocio.EnUsuario;
import Model.Entidades.Usuario;

public class LoginController {

    private Sessao session;
    private Usuario user;
    private EnUsuario enUsuario;

     public int checkUser(String userEmail, String userPass) {

        enUsuario = new EnUsuario();
        
        if (userEmail.equals("") || userPass.equals(""))
            return 0;

        String usrPapel = enUsuario.checkLogin(userEmail, userPass);

        /*
            0 = erro, campos email e/ou senha em branco
            1 = erro, usuario nao encontrado
            2 = sucesso, administrador
            3 = sucesso, avaliador
            4 = sucesso, professor
        */

        user = new Usuario();
        session = Sessao.getInstance();
        user.setEmail(userEmail);

        int intUsrPapel;
        switch(usrPapel) {
            case "":
                intUsrPapel = 1; // erro, usuario nao encontrado
            break;
                
            case "Administrador":
                intUsrPapel = 2; // sucesso, administrador
                user.setPapel("Administrador");
                session.setUsuario(user);
            break;
                
            case "Avaliador":
                user.setPapel("Avaliador");
                session.setUsuario(user);
                intUsrPapel = 3; // sucesso, avaliador
            break;
                
            case "Professor":
                user.setPapel("Professor");
                session.setUsuario(user);
                intUsrPapel = 4; // sucesso, professor
            break;
            
            default:
                intUsrPapel = 1; // erro desconhecido, default eh 1
            break;
        }

        return intUsrPapel;
    }
    
}
