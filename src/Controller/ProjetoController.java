
package Controller;

import Model.Database.ProjetoDAO;
import Model.Tabelas.Projeto;
import Utils.XMLParser;
import View.ProfProjetosView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jdom2.JDOMException;

public class ProjetoController {
    
    ProjetoDAO daoProj;
    Projeto proj;
    XMLParser xmlParser;
    
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

    /* flag: 0 => getTitulos | flag: 1 => getQuestoes */
    public ArrayList<String> getPerguntas(int flag) {
        
        ArrayList<String> perguntas = new ArrayList<>();
        xmlParser = new XMLParser();
        
        try {
            try {
                if (flag == 0) perguntas = xmlParser.getTitulos();
                else perguntas = xmlParser.getQuestoes();
            } catch (IOException ex) {
                Logger.getLogger(ProfProjetosView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JDOMException ex) {
            Logger.getLogger(ProfProjetosView.class.getName()).log(Level.SEVERE, null, ex);
        }

        return perguntas;
    }

    public ArrayList<String> getComentarios(int idProjeto) {
        
        ArrayList<String> comentarios;
        
        daoProj = new ProjetoDAO();
        comentarios = daoProj.getComentarios(idProjeto);
        
        return comentarios;
    }
    
    public int addComentario(int idProjeto, int idPergunta, String comentario) {
        int ret = 0;
        boolean check;

        if (idPergunta <= 0) {
            ret = 0;
            return ret;
        }

        if (comentario.equals("")) {
            ret = 1;
            return ret;
        }

        daoProj = new ProjetoDAO();
        check = daoProj.addComentario(idProjeto, idPergunta, comentario);
        if (!check) ret = 2;
        else ret = 3;
        
        return ret;
    }
    
    public Projeto getProjetoPorId(int idProjeto) {

        daoProj = new ProjetoDAO();
        proj = daoProj.getProjetoPorID(idProjeto);
        
        ArrayList<String> respostas;
        respostas = daoProj.getRespostas(idProjeto);
        proj.setRespostas(respostas);

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
    
    public JTable updateTableProjetosOrientador(JTable tabelaProjetos, String nomeProf) {
        
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
        projetos = daoProj.getProjetosOrientador(nomeProf);
        
        // adicionando a tabela
        /*
            o professor pode adicionar comentarios em projeto que estao em:
                - em preenchimento
                - em avaliacao
                - aprovado

        */
        for (int i = 0; i < projetos.size(); i++) {
            if (projetos.get(i).getStatus().equals("Em preenchimento") ||
                    projetos.get(i).getStatus().equals("Em avaliação") ||
                    projetos.get(i).getStatus().equals("Aprovado")) {
                tableModel.addRow(new Object[]{null, null, null, null, null});
                tabelaProjetos.setValueAt(projetos.get(i).getId(), i, 0);
                tabelaProjetos.setValueAt(projetos.get(i).getTitulo(), i, 1);
                tabelaProjetos.setValueAt(projetos.get(i).getLider(), i, 2);
                tabelaProjetos.setValueAt(projetos.get(i).getOrientador(), i, 3);
                tabelaProjetos.setValueAt(projetos.get(i).getStatus(), i, 4);
            }
        }
        
        // Esconde a coluna com os IDs.
        tabelaProjetos.removeColumn(tabelaProjetos.getColumnModel().getColumn(0));
        
        return tabelaProjetos;
    }
    
    public boolean alreadyInTable(JTable tabela, String valor){
        
        //DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();
        
        for(int i = 0; i < tabela.getRowCount(); i++){
            if(tabela.getValueAt(i, 0).equals(valor)){
                return true;
            }
        }   
        return false;
    }

}
