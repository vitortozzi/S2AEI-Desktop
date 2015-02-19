package Controller;

import Model.Negocio.EnAvaliador;
import Model.Negocio.EnProjeto;
import Model.Tabelas.Avaliador;
import Model.Tabelas.Projeto;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AvaliadorController {

    private Avaliador av;
    private EnAvaliador enAva;
    private EnProjeto enProjeto;

    public boolean addAvaliador(String nome, String email, String senha, String area, String formacao) {

        boolean check = false;

        if (email.equals("") || nome.equals("") || senha.equals("")
                || area.equals("") || formacao.equals("")) {
            return check;
        }

        av = new Avaliador();
        enAva = new EnAvaliador();

        av.setNome(nome);
        av.setEmail(email);
        av.setSenha(senha);
        av.setPapel("Avaliador");
        av.setStatus("Ativo");
        av.setArea(area);
        av.setFormacao(formacao);

        String avaJaCadastrado = "";
        avaJaCadastrado = enAva.checkEmailExists(email);
        if (avaJaCadastrado.equals(email)) {
            // avaliador ja existe, alterar para Ativo
            check = enAva.editAvaliador(av);
        } else {
            // avaliador nao existe ainda, adicionar normalmente
            check = enAva.addAvaliador(av);
        }

        return check;
    }

    public Avaliador getAvaliadorByEmail(String emailAvaliadorSelecionado) {

        enAva = new EnAvaliador();
        av = new Avaliador();

        av = enAva.getAvaliador(emailAvaliadorSelecionado);

        return av;
    }

    public boolean updateAvaliador(String nome, String email, String senha, String area, String formacao, String status) {

        boolean check = false;

        enAva = new EnAvaliador();
        av = new Avaliador();

        av.setNome(nome);
        av.setEmail(email);
        av.setSenha(senha);
        av.setArea(area);
        av.setFormacao(formacao);
        av.setStatus(status);

        check = enAva.editAvaliador(av);

        return check;

    }

    public String delAvaliador(String avaliadorEmail) {

        String message = "";
        boolean check = false;

        av = new Avaliador();
        enAva = new EnAvaliador();

        av = enAva.getAvaliador(avaliadorEmail);
        if (av.getStatus().equals("Inativo")) {
            message += "Não é possível excluir um Avaliador com Status 'Inativo'";
        } else {
            check = enAva.deleteAvaliador(avaliadorEmail);
            if (check) {
                message += "Avaliador excluído com sucesso!";
            } else {
                message += "Não foi possível excluir o Avaliador devido a um erro no Banco de Dados";
            }
        }

        return message;
    }

    public JTable updateTable(JTable tabelaAvaliadores) {

        enAva = new EnAvaliador();
        DefaultTableModel tableModel = (DefaultTableModel) tabelaAvaliadores.getModel();

        //Remove dados antigos da tabela -> Reseta tabela
        if (tableModel.getRowCount() > 0) {
            int linhas = tableModel.getRowCount();
            for (int i = 0; i < linhas; i++) {
                tableModel.removeRow(0);
            }
        }

        ArrayList<Avaliador> avaliadores = new ArrayList<>();
        avaliadores = enAva.getAvaliadores();

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
        enAva = new EnAvaliador();
        return enAva.getAvaliadoresAtivos();
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
        enAva = new EnAvaliador();
        avaliadores = enAva.getAvaliadoresProjeto(nomeProjeto);
        
        // adicionando na tabela
        for (int i = 0; i < avaliadores.size(); i++) {
            tableModel.addRow(new Object[]{avaliadores.get(i).getNome()});
        }

        return tabela;

    }
    
    public boolean setAvaliadorProjeto(Projeto p, String nomeAvaliador){
    
        av = new Avaliador();
        enProjeto = new EnProjeto();
        
        av.setNome(nomeAvaliador);
        return enProjeto.setAvaliadorProjeto(av, p);
    }
    
    public boolean removeAvaliadorProjeto(Projeto p, String nomeAvaliador){
        
        enProjeto = new EnProjeto();
        return enProjeto.deleteAvaliadorProjeto(p, nomeAvaliador);
        
    }
}