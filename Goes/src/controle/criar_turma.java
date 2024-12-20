/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controle;

import conexao.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Desktop
 */
public class criar_turma extends javax.swing.JFrame {

    Conexao con_instrutor;
    Conexao con_turma;
    
    public criar_turma() {
        initComponents();
        
        con_instrutor = new Conexao();// inicialização do objeto como instância
        con_instrutor.conecta();  //chama o método conecta
        con_instrutor.executaSQL("select * from instrutor order by id_Instrutor");
        
        preencherTabela();
        posicionarRegistro(); 
        tblInstrutor.setAutoCreateRowSorter(true);// ativa a classificação ordenada da tabela
        
        con_turma = new Conexao();// inicialização do objeto como instância
        con_turma.conecta();  
        con_turma.executaSQL("select * from turma order by id_Turma");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Campo_NomeInstrutor = new javax.swing.JTextField();
        Campo_IdInstrutor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Campo_Horario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInstrutor = new javax.swing.JTable();
        BotaoDecadastro = new javax.swing.JButton();
        NomeTurma = new javax.swing.JLabel();
        Campo_NomeTurma = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(226, 226, 250));

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(691, 432));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Criar Turma");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Nome do instrutor:");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("ID:");

        Campo_NomeInstrutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_NomeInstrutorActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Horário:");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Insira os horários ou especifique se é, Manhã, Tarde ou Noite.");

        jScrollPane1.setToolTipText("");

        tblInstrutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email"
            }
        ));
        tblInstrutor.setToolTipText("");
        tblInstrutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInstrutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInstrutor);

        BotaoDecadastro.setText("Enviar");
        BotaoDecadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDecadastroActionPerformed(evt);
            }
        });

        NomeTurma.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        NomeTurma.setText("Nome da turma:");

        Campo_NomeTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_NomeTurmaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_Horario))
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Campo_NomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_IdInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NomeTurma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_NomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(BotaoDecadastro)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Campo_NomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(Campo_IdInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeTurma)
                    .addComponent(Campo_NomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Campo_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoDecadastro)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Campo_NomeInstrutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_NomeInstrutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_NomeInstrutorActionPerformed

    private void tblInstrutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInstrutorMouseClicked
        int linha_selecionada = tblInstrutor.getSelectedRow();
        Campo_IdInstrutor.setText(tblInstrutor.getValueAt(linha_selecionada, 0).toString());
        Campo_NomeInstrutor.setText(tblInstrutor.getValueAt(linha_selecionada, 1).toString());
    }//GEN-LAST:event_tblInstrutorMouseClicked

    private void BotaoDecadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDecadastroActionPerformed
        int id_instrutor = Integer.parseInt(Campo_IdInstrutor.getText());
        String NomeTurma = Campo_NomeTurma.getText();
        String Horario = Campo_Horario.getText();
        
         try{
                String insert_sql="INSERT INTO `turma`(`id_ Instrutor`, `nome_Turma`, `horario`) VALUES ('" + id_instrutor + "','" + NomeTurma + "','" + Horario + "')";
                System.out.println(insert_sql);
                con_turma.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(errosql);
            }
    }//GEN-LAST:event_BotaoDecadastroActionPerformed

    private void Campo_NomeTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_NomeTurmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_NomeTurmaActionPerformed

    public void posicionarRegistro() {
        try{
            con_instrutor.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

      public void preencherTabela(){
        tblInstrutor.getColumnModel().getColumn(0).setPreferredWidth(2);
        tblInstrutor.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblInstrutor.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        DefaultTableModel modelo = (DefaultTableModel) tblInstrutor.getModel();
        modelo.setNumRows(0);
        
        try{
            con_instrutor.resultset.beforeFirst();
            while(con_instrutor.resultset.next()){
                modelo.addRow(new Object[]{
                    con_instrutor.resultset.getString("id_Instrutor"),con_instrutor.resultset.getString("nome_Instrutor"),con_instrutor.resultset.getString("email_Instrutor")
                });
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
        /*try {
        // Container to hold all panels
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BoxLayout(panelContainer, BoxLayout.Y_AXIS)); // Vertical arrangement
        
        con_instrutor.resultset.beforeFirst();
        while (con_instrutor.resultset.next()) {
        // Get data from the current row
        String id = con_instrutor.resultset.getString("id_Instrutor");
        String name = con_instrutor.resultset.getString("nome_Instrutor");
        String email = con_instrutor.resultset.getString("email_Instrutor");
        
        // Create a new JPanel for this row
        JPanel itemPanel = new JPanel();
        itemPanel.setBorder(BorderFactory.createTitledBorder("Instructor " + id));
        itemPanel.setLayout(new GridLayout(3, 1)); // Arrange items in a grid (3 rows, 1 column)
        
        // Add labels with information to the panel
        itemPanel.add(new JLabel("ID: " + id));
        itemPanel.add(new JLabel("Name: " + name));
        itemPanel.add(new JLabel("Email: " + email));
        
        // Add this item panel to the container
        panelContainer.add(itemPanel);
        }
        
        // Add the container to your main frame or another parent component
        JFrame frame = new JFrame("Instructor Panels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(panelContainer)); // Add scrolling for many items
        frame.setSize(400, 600); // Set frame size
        frame.setVisible(true);
        
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(
        null,
        "\n Erro ao listar dados da tabela!! :\n " + erro,
        "Mensagem do Programa",
        JOptionPane.INFORMATION_MESSAGE
        );
        }*/

    }
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
            java.util.logging.Logger.getLogger(criar_turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criar_turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criar_turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criar_turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new criar_turma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoDecadastro;
    private javax.swing.JTextField Campo_Horario;
    private javax.swing.JTextField Campo_IdInstrutor;
    private javax.swing.JTextField Campo_NomeInstrutor;
    private javax.swing.JTextField Campo_NomeTurma;
    private javax.swing.JLabel NomeTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInstrutor;
    // End of variables declaration//GEN-END:variables
}
