
package Controller;

import Model.Administrador;
import Model.Database.AdministradorDAO;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdministradorController {
    
    private Administrador adm;
    private AdministradorDAO admdao;

    public boolean addAdministrador(String nome, String email, String senha) {
        
        boolean check = false;
        
        if (email.equals("") || nome.equals("") || senha.equals("")) return check;
        
        admdao = new AdministradorDAO();
        adm = new Administrador();
        
        adm.setNome(nome);
        adm.setEmail(email);
        adm.setSenha(senha);
        adm.setPapel("Administrador");
        adm.setStatus("Ativo");
        
        String admJaCadastrado = "";
        admJaCadastrado = admdao.checkEmailExists(email);
        if (admJaCadastrado.equals(email)) {
            // adm ja existe, alterar para Ativo
            check = admdao.editAdministrador(adm);
        } else {
            // adm nao existe ainda, adicionar normalmente
            check = admdao.addAdministrador(adm);
        }
        
        return check;
    }

    public Administrador getAdmByEmail(String emailAdmSelecionado) {
        
        admdao = new AdministradorDAO();
        adm = new Administrador();
        
        adm = admdao.getAdministrador(emailAdmSelecionado);
        
        return adm;
    }
    
    public boolean updateAdministrador(String nome, String email, String senha, String status) {
        
        boolean check = false;
        
        admdao = new AdministradorDAO();
        adm = new Administrador();
        
        adm.setNome(nome);
        adm.setEmail(email);
        adm.setSenha(senha);
        adm.setStatus(status);
        
        check = admdao.editAdministrador(adm);
        
        return check;
        
    }
 
    public String delAdministrador(String admEmail) {
        
        String message = "";
        boolean check = false;
        
        adm = new Administrador();
        admdao = new AdministradorDAO();
        
        adm = admdao.getAdministrador(admEmail);
        if (adm.getStatus().equals("Inativo")) {
            message += "Não é possível excluir um Administrador com Status 'Inativo'";
        } else {
            check = admdao.deleteAdministrador(admEmail);
            if (check) message += "Administrador excluído com sucesso!";
            else message += "Não foi possível excluir o Administrador devido a um erro no Banco de Dados";
        }
        
        return message;
    }
    
    public JTable updateTable(JTable tabelaAdministradores) {
        
        admdao = new AdministradorDAO();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaAdministradores.getModel();
        
        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }
        
        ArrayList<Administrador> administradores = new ArrayList<>();
        administradores = admdao.getAdministradores();

        // adicionando a tabela
        for (int i = 0; i < administradores.size(); i++) {
            tableModel.addRow(new Object[]{null, null, null, null, null, null});
            tabelaAdministradores.setValueAt(administradores.get(i).getNome(), i, 0);
            tabelaAdministradores.setValueAt(administradores.get(i).getEmail(), i, 1);
            tabelaAdministradores.setValueAt(administradores.get(i).getStatus(), i, 2);
        }
        
        return tabelaAdministradores;
    }
    
}
