
package View;

import Controller.ProjetoController;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

public class ProfProjetosView extends javax.swing.JFrame {

    ProjetoController projControler;
    
    /**
     * Creates new form ProjetosAdministrador
     */
    public ProfProjetosView() {
        initComponents();
        projControler = new ProjetoController();
        // AQUI EH DIFERENTE, PEGAR APENAS OS PROJETOS QUE O PROFESSOR EH LIDER
        //tabelaProjetosProf = projControler.updateTable(tabelaProjetosProf);
        
        // Esconde a coluna com os IDs.
        tabelaProjetosProf.removeColumn(tabelaProjetosProf.getColumnModel().getColumn(0));
        
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

        projetosProfContentPanel = new javax.swing.JPanel();
        projetosProfIndex = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProjetosProf = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        attrAvaliadores = new javax.swing.JPanel();
        projetosProfMenuPanel = new javax.swing.JPanel();
        bttnAddComentarios = new javax.swing.JButton();
        bttnVisualizarRespostas = new javax.swing.JButton();
        bttnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        projetosProfContentPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        projetosProfContentPanel.setLayout(new java.awt.CardLayout());

        tabelaProjetosProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        jScrollPane1.setViewportView(tabelaProjetosProf);
        if (tabelaProjetosProf.getColumnModel().getColumnCount() > 0) {
            tabelaProjetosProf.getColumnModel().getColumn(0).setResizable(false);
            tabelaProjetosProf.getColumnModel().getColumn(1).setResizable(false);
            tabelaProjetosProf.getColumnModel().getColumn(2).setResizable(false);
            tabelaProjetosProf.getColumnModel().getColumn(3).setResizable(false);
            tabelaProjetosProf.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Projetos");

        javax.swing.GroupLayout projetosProfIndexLayout = new javax.swing.GroupLayout(projetosProfIndex);
        projetosProfIndex.setLayout(projetosProfIndexLayout);
        projetosProfIndexLayout.setHorizontalGroup(
            projetosProfIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosProfIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projetosProfIndexLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(238, 238, 238))
        );
        projetosProfIndexLayout.setVerticalGroup(
            projetosProfIndexLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projetosProfIndexLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        projetosProfContentPanel.add(projetosProfIndex, "professorIndex");

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

        projetosProfContentPanel.add(attrAvaliadores, "card3");

        projetosProfMenuPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bttnAddComentarios.setText("Adicionar Comentários");
        bttnAddComentarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnAddComentariosActionPerformed(evt);
            }
        });

        bttnVisualizarRespostas.setText("Visualizar Respostas");
        bttnVisualizarRespostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnVisualizarRespostasActionPerformed(evt);
            }
        });

        bttnVoltar.setText("Voltar");
        bttnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projetosProfMenuPanelLayout = new javax.swing.GroupLayout(projetosProfMenuPanel);
        projetosProfMenuPanel.setLayout(projetosProfMenuPanelLayout);
        projetosProfMenuPanelLayout.setHorizontalGroup(
            projetosProfMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosProfMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bttnAddComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bttnVisualizarRespostas, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173)
                .addComponent(bttnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        projetosProfMenuPanelLayout.setVerticalGroup(
            projetosProfMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projetosProfMenuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projetosProfMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bttnAddComentarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(bttnVisualizarRespostas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttnVoltar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(projetosProfMenuPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projetosProfContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projetosProfContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projetosProfMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bttnAddComentariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnAddComentariosActionPerformed
//        CardLayout content = (CardLayout) (projetosAdminContentPanel.getLayout());
//        content.show(projetosAdminContentPanel, "professorAdd");
    }//GEN-LAST:event_bttnAddComentariosActionPerformed

    private void bttnVisualizarRespostasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnVisualizarRespostasActionPerformed

//        int rowIndex = tabelaProjetosAdmin.getSelectedRow();
//
//        if (rowIndex == -1) {
//            JOptionPane.showMessageDialog(null,"Escolha um Professor da tabela para editar.", "Aviso", JOptionPane.WARNING_MESSAGE);
//        } else {
//
//            CardLayout content = (CardLayout) (projetosAdminContentPanel.getLayout());
//            content.show(projetosAdminContentPanel, "professorEdit");
//
//            String emailProfSelecionado = (String) tabelaProjetosAdmin.getModel().getValueAt(rowIndex, 1);
//            Professor p;
//            profController = new ProfessorController();
//
//            p = profController.getProfessorByEmail(emailProfSelecionado);
//
//            profNomeEdit.setText(p.getNome());
//            profEmailEdit.setText(p.getEmail());
//            profSenhaEdit.setText(p.getSenha());
//            profStatusEdit.setSelectedItem(p.getStatus());
//            profDepartEdit.setText(p.getDepartamento());
//            profDiscEdit.setText(p.getDisciplinaPrincipal());
        //}
    }//GEN-LAST:event_bttnVisualizarRespostasActionPerformed

    private void bttnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnVoltarActionPerformed
        dispose();
        new HomeProfessor().setVisible(true);
    }//GEN-LAST:event_bttnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(ProfProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfProjetosView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfProjetosView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel attrAvaliadores;
    private javax.swing.JButton bttnAddComentarios;
    private javax.swing.JButton bttnVisualizarRespostas;
    private javax.swing.JButton bttnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel projetosProfContentPanel;
    private javax.swing.JPanel projetosProfIndex;
    private javax.swing.JPanel projetosProfMenuPanel;
    private javax.swing.JTable tabelaProjetosProf;
    // End of variables declaration//GEN-END:variables
}
