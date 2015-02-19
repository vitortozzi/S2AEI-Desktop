
package Controller;

import Model.Negocio.EnProfessor;
import Model.Tabelas.Professor;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProfessorController {
    
    private Professor p;
    private EnProfessor enProf;

    public boolean addProfessor(String nome, String email, String senha, String departamento, String disc_principal) {
        
        boolean check = false;
        
        if (email.equals("") || nome.equals("") || senha.equals("") || 
                departamento.equals("") || disc_principal.equals("")) return check;
        
        enProf = new EnProfessor();
        p = new Professor();
        
        p.setNome(nome);
        p.setEmail(email);
        p.setSenha(senha);
        p.setPapel("Professor");
        p.setStatus("Ativo");
        p.setDepartamento(departamento);
        p.setDisciplinaPrincipal(disc_principal);
        
        String profJaCadastrado = "";
        profJaCadastrado = enProf.checkEmailExists(email);
        if (profJaCadastrado.equals(email)) {
            // professor ja existe, alterar para Ativo
            check = enProf.editProfessor(p);
        } else {
            // professor nao existe ainda, adicionar normalmente
            check = enProf.addProfessor(p);
        }
        
        return check;
    }

    public Professor getProfessorByEmail(String emailProfSelecionado) {

        p = new Professor();
        enProf = new EnProfessor();
        
        p = enProf.getProfessor(emailProfSelecionado);
        
        return p;
    }
    
    public boolean updateProfessor(String nome, String email, String senha, String departamento, String disc_principal, String status) {
        
        boolean check = false;

        p = new Professor();
        enProf = new EnProfessor();
        
        p.setNome(nome);
        p.setEmail(email);
        p.setSenha(senha);
        p.setDepartamento(departamento);
        p.setDisciplinaPrincipal(disc_principal);
        p.setStatus(status);
        
        check = enProf.editProfessor(p);
        
        return check;
        
    }
 
    public String delProfessor(String profEmail) {
        
        String message = "";
        boolean check = false;
        
        p = new Professor();
       enProf = new EnProfessor();
        
        p = enProf.getProfessor(profEmail);
        if (p.getStatus().equals("Inativo")) {
            message += "Não é possível excluir um Professor com Status 'Inativo'";
        } else {
            check = enProf.deleteProfessor(profEmail);
            if (check) message += "Professor excluído com sucesso!";
            else message += "Não foi possível excluir o Professor devido a um erro no Banco de Dados";
        }
        
        return message;
    }
    
    public JTable updateTable(JTable tabelaProfessores) {
        
        enProf = new EnProfessor();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaProfessores.getModel();
        
        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }
        
        ArrayList<Professor> professores = new ArrayList<>();
        professores = enProf.getProfessores();

        // adicionando a tabela
        for (int i = 0; i < professores.size(); i++) {
            tableModel.addRow(new Object[]{null, null, null, null, null, null});
            tabelaProfessores.setValueAt(professores.get(i).getNome(), i, 0);
            tabelaProfessores.setValueAt(professores.get(i).getEmail(), i, 1);
            tabelaProfessores.setValueAt(professores.get(i).getStatus(), i, 2);
            tabelaProfessores.setValueAt(professores.get(i).getDepartamento(), i, 3);
            tabelaProfessores.setValueAt(professores.get(i).getDisciplinaPrincipal(), i, 4);
        }
        
        return tabelaProfessores;
    }
    
}
