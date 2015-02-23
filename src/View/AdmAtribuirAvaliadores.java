package View;

import Controller.AvaliadorController;
import Controller.ProjetoController;
import Model.Tabelas.Avaliador;
import Model.Tabelas.Projeto;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdmAtribuirAvaliadores extends javax.swing.JFrame {

    ProjetoController projControler;
    AvaliadorController avaliadorController;
    Projeto p;

    /**
     * Creates new form ProjetosAdministrador
     */
    public AdmAtribuirAvaliadores() {
        initComponents();
        projControler = new ProjetoController();
        avaliadorController = new AvaliadorController();

        tabelaProjetosAdmin = projControler.updateTable(tabelaProjetosAdmin, "Em avaliação");

        // Esconde a coluna com os IDs.
        tabelaProjetosAdmin.getColumnModel().getColumn(0).setWidth(0);
        tabelaProjetosAdmin.getColumnModel().getColumn(0).setMaxWidth(0);
        tabelaProjetosAdmin.getColumnModel().getColumn(0).setMinWidth(0);

        // Para utilização mais tarde
        //System.out.println("Id: " + tabelaProjetosAdmin.getModel().getValueAt(0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projetosAdminContentPanel = new javax.swing.JPanel();
        projetosAdminIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProjetosAdmin = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        attrAvaliadores = new javax.swing.JPanel();
        avaliadoresProjeto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAvaliadoresProjeto = new javax.swing.JTable();
        labelNomeProjeto = new javax.swing.JLabel();
        btnAddAvaliador = new javax.swing.JButton();
        btnRemoveAvaliador = new javax.swing.JButton();
        btnVoltarProjetos = new javax.swing.JButton();
        comboAvaliadores = new javax.swing.JComboBox();
        projetosAdminMenuPanel = new javax.swing.JPanel();
        bttnAttrAvaliadores = new javax.swing.JButton();
        bttnVoltarProjetosAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        projetosAdminContentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        projetosAdminContentPanel.setLayout(new java.awt.CardLayout());

        tabelaProjetosAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Título", "Líder", "Orientador", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProjetosAdmin);
        if (tabelaProjetosAdmin.getColumnModel().getColumnCount() > 0) {
            tabelaProjetosAdmin.getColumnModel().getColumn(1).setResizable(false);
            tabelaProjetosAdmin.getColumnModel().getColumn(2).setResizable(false);
            tabelaProjetosAdmin.getColumnModel().getColumn(3).setResizable(false);
            tabelaProjetosAdmin.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Projetos Em avaliação");

        javax.swing.GroupLayout projetosAdminIndexLayout = new javax.swing.GroupLayout(projetosAdminIndex);
        projetosAdminIndex.setLayout(projetosAdminIndexLayout);
        projetosAdminIndexLayout.setHorizontalGroup(
            projetosAdminIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosAdminIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(projetosAdminIndexLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        projetosAdminIndexLayout.setVerticalGroup(
            projetosAdminIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projetosAdminIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        projetosAdminContentPanel.add(projetosAdminIndex, "projetosAdminIndex");

        javax.swing.GroupLayout attrAvaliadoresLayout = new javax.swing.GroupLayout(attrAvaliadores);
        attrAvaliadores.setLayout(attrAvaliadoresLayout);
        attrAvaliadoresLayout.setHorizontalGroup(
            attrAvaliadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        attrAvaliadoresLayout.setVerticalGroup(
            attrAvaliadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        projetosAdminContentPanel.add(attrAvaliadores, "attrAvaliadores");

        tabelaAvaliadoresProjeto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Avaliadores Atribuídos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaAvaliadoresProjeto);

        labelNomeProjeto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelNomeProjeto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAddAvaliador.setText("Adicionar");
        btnAddAvaliador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAvaliadorActionPerformed(evt);
            }
        });

        btnRemoveAvaliador.setText("Remover");
        btnRemoveAvaliador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAvaliadorActionPerformed(evt);
            }
        });

        btnVoltarProjetos.setText("Retornar");
        btnVoltarProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarProjetosActionPerformed(evt);
            }
        });

        comboAvaliadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAvaliadoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout avaliadoresProjetoLayout = new javax.swing.GroupLayout(avaliadoresProjeto);
        avaliadoresProjeto.setLayout(avaliadoresProjetoLayout);
        avaliadoresProjetoLayout.setHorizontalGroup(
            avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(avaliadoresProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(avaliadoresProjetoLayout.createSequentialGroup()
                        .addComponent(labelNomeProjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, avaliadoresProjetoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRemoveAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(226, 226, 226)
                        .addComponent(btnVoltarProjetos)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, avaliadoresProjetoLayout.createSequentialGroup()
                        .addGap(93, 197, Short.MAX_VALUE)
                        .addGroup(avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(avaliadoresProjetoLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnAddAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboAvaliadores, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(219, 219, 219))))
        );
        avaliadoresProjetoLayout.setVerticalGroup(
            avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, avaliadoresProjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelNomeProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAvaliadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(avaliadoresProjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarProjetos, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnRemoveAvaliador, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        projetosAdminContentPanel.add(avaliadoresProjeto, "avaliadoresProjeto");

        projetosAdminMenuPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bttnAttrAvaliadores.setText("Atribuir Avaliadores");
        bttnAttrAvaliadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAttrAvaliadoresActionPerformed(evt);
            }
        });

        bttnVoltarProjetosAdmin.setText("Voltar");
        bttnVoltarProjetosAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnVoltarProjetosAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projetosAdminMenuPanelLayout = new javax.swing.GroupLayout(projetosAdminMenuPanel);
        projetosAdminMenuPanel.setLayout(projetosAdminMenuPanelLayout);
        projetosAdminMenuPanelLayout.setHorizontalGroup(
            projetosAdminMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosAdminMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnAttrAvaliadores, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(370, 370, 370)
                .addComponent(bttnVoltarProjetosAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        projetosAdminMenuPanelLayout.setVerticalGroup(
            projetosAdminMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosAdminMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projetosAdminMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bttnAttrAvaliadores, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(bttnVoltarProjetosAdmin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(projetosAdminMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projetosAdminContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projetosAdminContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projetosAdminMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAttrAvaliadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAttrAvaliadoresActionPerformed

        int rowIndex = tabelaProjetosAdmin.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(rootPane, "Você deve selecionar um projeto.");
        } else {
            ArrayList<Avaliador> avaliadores = new ArrayList<>();
            avaliadores = avaliadorController.getAvaliadoresAtivos();
            Avaliador a;
            labelNomeProjeto.setText(tabelaProjetosAdmin.getValueAt(tabelaProjetosAdmin.getSelectedRow(), 1).toString());
            comboAvaliadores.removeAllItems();
            for (Avaliador ava : avaliadores) {
                comboAvaliadores.addItem(ava.getNome());
            }
            tabelaAvaliadoresProjeto = new AvaliadorController().updateTabelaAvaliadoresProjetos(tabelaAvaliadoresProjeto, labelNomeProjeto.getText());
            p = new Projeto();
            p.setId(Integer.parseInt(tabelaProjetosAdmin.getModel().getValueAt(rowIndex, 0).toString()));
            p.setTitulo(labelNomeProjeto.getText());
            CardLayout content = (CardLayout) (projetosAdminContentPanel.getLayout());
            content.show(projetosAdminContentPanel, "avaliadoresProjeto");
        }
    }//GEN-LAST:event_bttnAttrAvaliadoresActionPerformed

    private void bttnVoltarProjetosAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnVoltarProjetosAdminActionPerformed
        dispose();
        new HomeAdministrador().setVisible(true);
    }//GEN-LAST:event_bttnVoltarProjetosAdminActionPerformed

    private void btnAddAvaliadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAvaliadorActionPerformed
        String nomeAvaliador = comboAvaliadores.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) tabelaAvaliadoresProjeto.getModel();
        if (!projControler.alreadyInTable(tabelaAvaliadoresProjeto, nomeAvaliador)) {            
            if (avaliadorController.setAvaliadorProjeto(p, nomeAvaliador)) {
                tabelaAvaliadoresProjeto = new AvaliadorController().
                        updateTabelaAvaliadoresProjetos(tabelaAvaliadoresProjeto, labelNomeProjeto.getText());
                JOptionPane.showMessageDialog(rootPane, "Avaliador atribuido com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Houve um erro ao atribuir o avaliador.\nEntre "
                        + "em contato com o administrador");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "O avaliador que você está tentando inserir já está na lista.");
        }
        //tabelaAvaliadoresProjeto.setValueAt("Olá", model.getRowCount()+1,1);

        tabelaAvaliadoresProjeto = new AvaliadorController().
                updateTabelaAvaliadoresProjetos(tabelaAvaliadoresProjeto, labelNomeProjeto.getText());

    }//GEN-LAST:event_btnAddAvaliadorActionPerformed

    private void btnVoltarProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarProjetosActionPerformed

        CardLayout content = (CardLayout) (projetosAdminContentPanel.getLayout());
        content.show(projetosAdminContentPanel, "projetosAdminIndex");
    }//GEN-LAST:event_btnVoltarProjetosActionPerformed

    private void comboAvaliadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAvaliadoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAvaliadoresActionPerformed

    private void btnRemoveAvaliadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAvaliadorActionPerformed

        int indexRow = tabelaAvaliadoresProjeto.getSelectedRow();
        
        if (indexRow >= 0) {
//            DefaultTableModel model = (DefaultTableModel) tabelaAvaliadoresProjeto.getModel();
//            model.removeRow(tabelaAvaliadoresProjeto.getSelectedRow());
              
            if(avaliadorController.removeAvaliadorProjeto(p, comboAvaliadores.getSelectedItem().toString())){
                tabelaAvaliadoresProjeto = new AvaliadorController().
                updateTabelaAvaliadoresProjetos(tabelaAvaliadoresProjeto, labelNomeProjeto.getText()); 
                JOptionPane.showMessageDialog(rootPane, "Avaliador desvinculado do projeto com sucesso.");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Houve um erro ao desvincular o avaliador do projeto.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Você precisa selecionar algum avaliador para remove-lo");
        }

    }//GEN-LAST:event_btnRemoveAvaliadorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdmAtribuirAvaliadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdmAtribuirAvaliadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdmAtribuirAvaliadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdmAtribuirAvaliadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdmAtribuirAvaliadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attrAvaliadores;
    private javax.swing.JPanel avaliadoresProjeto;
    private javax.swing.JButton btnAddAvaliador;
    private javax.swing.JButton btnRemoveAvaliador;
    private javax.swing.JButton btnVoltarProjetos;
    private javax.swing.JButton bttnAttrAvaliadores;
    private javax.swing.JButton bttnVoltarProjetosAdmin;
    private javax.swing.JComboBox comboAvaliadores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNomeProjeto;
    private javax.swing.JPanel projetosAdminContentPanel;
    private javax.swing.JPanel projetosAdminIndex;
    private javax.swing.JPanel projetosAdminMenuPanel;
    private javax.swing.JTable tabelaAvaliadoresProjeto;
    private javax.swing.JTable tabelaProjetosAdmin;
    // End of variables declaration//GEN-END:variables
}
