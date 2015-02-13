/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database.ProjetoDAO;
import Model.Tabelas.Projeto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vítor
 */
public class ProjetoController {
    
    ProjetoDAO daoProj;
    Projeto proj;
    
    public String alterarStatusProjeto(String emailLider, String novoStatus) {
        daoProj = new ProjetoDAO();
        
        String message = "";
        boolean check;
        
        check = daoProj.alteraStatusProjetoAprovado(emailLider, novoStatus);
        
        if (check) {
            message += "Status do projeto alterado com sucesso!";
        } else {
            message += "Houve um erro na alteração do Status do Projeto.";
        }
        
        return message;
    }
    
    public Projeto getProjetoPorId(int idProjeto) {

        daoProj = new ProjetoDAO();
        proj = daoProj.getProjetoPorID(idProjeto);

        return proj;
    }

    public JTable updateTable(JTable tabelaProjetos, String flagStatusProjeto) {
        
        daoProj = new ProjetoDAO();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaProjetos.getModel();
        
        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }
        
        ArrayList<Projeto> projetos = new ArrayList<>();
        projetos = daoProj.getProjetos();

        // adicionando a tabela
        int indexTab = 0;
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getStatus().equals(flagStatusProjeto)) {
                tableModel.addRow(new Object[]{null, null, null, null, null});
                tabelaProjetos.setValueAt(projetos.get(i).getId(), indexTab, 0);
                tabelaProjetos.setValueAt(projetos.get(i).getTitulo(), indexTab, 1);
                tabelaProjetos.setValueAt(projetos.get(i).getLider(), indexTab, 2);
                tabelaProjetos.setValueAt(projetos.get(i).getOrientador(), indexTab, 3);
                tabelaProjetos.setValueAt(projetos.get(i).getStatus(), indexTab, 4);
                indexTab++;
            }
        }
        
        return tabelaProjetos;
    }
    
}
