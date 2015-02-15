package Controller;

import Model.Database.AvaliadorDAO;
import Model.Database.ProjetoDAO;
import Model.Tabelas.Avaliador;
import Model.Tabelas.Projeto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AvaliadorController {

    private Avaliador av;
    private AvaliadorDAO avd;
    private ProjetoDAO daoProjeto;

    public boolean addAvaliador(String nome, String email, String senha, String area, String formacao) {

        boolean check = false;

        if (email.equals("") || nome.equals("") || senha.equals("")
                || area.equals("") || formacao.equals("")) {
            return check;
        }

        avd = new AvaliadorDAO();
        av = new Avaliador();

        av.setNome(nome);
        av.setEmail(email);
        av.setSenha(senha);
        av.setPapel("Avaliador");
        av.setStatus("Ativo");
        av.setArea(area);
        av.setFormacao(formacao);

        String avaJaCadastrado = "";
        avaJaCadastrado = avd.checkEmailExists(email);
        if (avaJaCadastrado.equals(email)) {
            // avaliador ja existe, alterar para Ativo
            check = avd.editAvaliador(av);
        } else {
            // avaliador nao existe ainda, adicionar normalmente
            check = avd.addAvaliador(av);
        }

        return check;
    }

    public Avaliador getAvaliadorByEmail(String emailAvaliadorSelecionado) {

        avd = new AvaliadorDAO();
        av = new Avaliador();

        av = avd.getAvaliador(emailAvaliadorSelecionado);

        return av;
    }

    public boolean updateAvaliador(String nome, String email, String senha, String area, String formacao, String status) {

        boolean check = false;

        avd = new AvaliadorDAO();
        av = new Avaliador();

        av.setNome(nome);
        av.setEmail(email);
        av.setSenha(senha);
        av.setArea(area);
        av.setFormacao(formacao);
        av.setStatus(status);

        check = avd.editAvaliador(av);

        return check;

    }

    public String delAvaliador(String avaliadorEmail) {

        String message = "";
        boolean check = false;

        av = new Avaliador();
        avd = new AvaliadorDAO();

        av = avd.getAvaliador(avaliadorEmail);
        if (av.getStatus().equals("Inativo")) {
            message += "Não é possível excluir um Avaliador com Status 'Inativo'";
        } else {
            check = avd.deleteAvaliador(avaliadorEmail);
            if (check) {
                message += "Avaliador excluído com sucesso!";
            } else {
                message += "Não foi possível excluir o Avaliador devido a um erro no Banco de Dados";
            }
        }

        return message;
    }

    public JTable updateTable(JTable tabelaAvaliadores) {

        avd = new AvaliadorDAO();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaAvaliadores.getModel();

        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }

        ArrayList<Avaliador> avaliadores = new ArrayList<>();
        avaliadores = avd.getAvaliadores();

        // adicionando na tabela
        for (int i = 0; i < avaliadores.size(); i++) {
            tableModel.addRow(new Object[]{null, null, null, null, null, null});
            tabelaAvaliadores.setValueAt(avaliadores.get(i).getNome(), i, 0);
            tabelaAvaliadores.setValueAt(avaliadores.get(i).getEmail(), i, 1);
            tabelaAvaliadores.setValueAt(avaliadores.get(i).getStatus(), i, 2);
            tabelaAvaliadores.setValueAt(avaliadores.get(i).getArea(), i, 3);
            tabelaAvaliadores.setValueAt(avaliadores.get(i).getFormacao(), i, 4);
        }

        return tabelaAvaliadores;
    }

    public ArrayList<Avaliador> getAvaliadoresAtivos() {
        avd = new AvaliadorDAO();
        return avd.getAvaliadoresAtivos();
    }

    public JTable updateTabelaAvaliadoresProjetos(JTable tabela, String nomeProjeto) {

        DefaultTableModel tableModel = (DefaultTableModel) tabela.getModel();

        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }

        ArrayList<Avaliador> avaliadores = new ArrayList<>();
        avd = new AvaliadorDAO();
        avaliadores = avd.getAvaliadoresProjeto(nomeProjeto);
        
        // adicionando na tabela
        for (int i = 0; i < avaliadores.size(); i++) {
            tableModel.addRow(new Object[]{avaliadores.get(i).getNome()});
        }

        return tabela;

    }
    
    public boolean setAvaliadorProjeto(Projeto p, String nomeAvaliador){
    
        Avaliador avaliador = new Avaliador();

        avaliador.setNome(nomeAvaliador);
        
        daoProjeto = new ProjetoDAO();
        return daoProjeto.setAvaliadorProjeto(avaliador, p);
    }
    
    public boolean removeAvaliadorProjeto(Projeto p, String nomeAvaliador){
        
        daoProjeto = new ProjetoDAO();
        return daoProjeto.deleteAvaliadorProjeto(p,nomeAvaliador);
        
    }
}


