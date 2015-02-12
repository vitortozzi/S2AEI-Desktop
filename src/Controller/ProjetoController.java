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
    
    public JTable updateTable(JTable tabelaProjetos) {
        
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
        for (int i = 0; i < projetos.size(); i++) {
            tableModel.addRow(new Object[]{null, null, null, null, null});
            tabelaProjetos.setValueAt(projetos.get(i).getId(), i, 0);
            tabelaProjetos.setValueAt(projetos.get(i).getTitulo(), i, 1);
            tabelaProjetos.setValueAt(projetos.get(i).getLider(), i, 2);
            tabelaProjetos.setValueAt(projetos.get(i).getOrientador(), i, 3);
            tabelaProjetos.setValueAt(projetos.get(i).getStatus(), i, 4);
        }
        
        return tabelaProjetos;
    }
    
}
