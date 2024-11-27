/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Turmas_Instrutor extends javax.swing.JFrame {

    Conexao con_instrutor;
    Conexao con_turma;
    private int instrutorId;

    Turmas_Instrutor(int instrutor_id) {
    initComponents();
    this.instrutorId = instrutor_id;
    
    con_instrutor = new Conexao(); // Inicializa o objeto de conexão
    con_instrutor.conecta(); // Conecta ao banco
    con_instrutor.executaSQL("SELECT * FROM instrutor WHERE id_Instrutor = " + instrutor_id);

    try {
        // Move o cursor para o primeiro registro retornado
        if (con_instrutor.resultset.next()) { 
            // Atualiza o campo com o nome do médico
            Text_nome.setText(con_instrutor.resultset.getString("nome_Instrutor"));
        } else {
            // Exibe mensagem caso nenhum resultado seja encontrado
            JOptionPane.showMessageDialog(null, "Instrutor não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        // Trata possíveis erros na manipulação do ResultSet
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Instrutor:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(Turmas_Instrutor.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        con_turma = new Conexao();// inicialização do objeto como instância
        con_turma.conecta();  //chama o método conecta
        con_turma.executaSQL("SELECT * FROM turma WHERE `id_ Instrutor` = " + instrutor_id + " ORDER BY id_Turma");
        
        preencherTabela();
        posicionarRegistro(); 
        tblTurmas.setAutoCreateRowSorter(true);// ativa a classificação ordenada da tabela   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Text_titulo = new javax.swing.JLabel();
        Text_usuario = new javax.swing.JLabel();
        Text_usuario1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Text_titulo1 = new javax.swing.JLabel();
        Text_usuario2 = new javax.swing.JLabel();
        Text_nome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTurmas = new javax.swing.JTable();

        Text_titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_titulo.setText("Cadastro de Médico");

        Text_usuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_usuario.setText("Nome do Cliente:");

        Text_usuario1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_usuario1.setText("Nome do Cliente:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));

        Text_titulo1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_titulo1.setText("Turmas");

        Text_usuario2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_usuario2.setText("SEJA BEM VINDO(A)");

        Text_nome.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_nome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_nome.setText("teste");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Suas turmas vão estar presentes na tabela abaixo");

        tblTurmas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Horario"
            }
        ));
        tblTurmas.setToolTipText("");
        tblTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTurmas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Text_titulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Text_usuario2)
                .addGap(174, 174, 174))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(Text_titulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Text_usuario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Text_nome)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTurmasMouseClicked

    }//GEN-LAST:event_tblTurmasMouseClicked

    public void posicionarRegistro() {
        try{
            con_turma.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

      public void preencherTabela(){
        tblTurmas.getColumnModel().getColumn(0).setPreferredWidth(2);
        tblTurmas.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblTurmas.getColumnModel().getColumn(2).setPreferredWidth(100);
        
        DefaultTableModel modelo = (DefaultTableModel) tblTurmas.getModel();
        modelo.setNumRows(0);
        
        try{
            con_turma.resultset.beforeFirst();
            while(con_turma.resultset.next()){
                modelo.addRow(new Object[]{
                    con_turma.resultset.getString("id_Turma"),con_turma.resultset.getString("nome_Turma"),con_turma.resultset.getString("horario")
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
            java.util.logging.Logger.getLogger(Turmas_Instrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turmas_Instrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turmas_Instrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turmas_Instrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turmas_Instrutor(1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Text_nome;
    private javax.swing.JLabel Text_titulo;
    private javax.swing.JLabel Text_titulo1;
    private javax.swing.JLabel Text_usuario;
    private javax.swing.JLabel Text_usuario1;
    private javax.swing.JLabel Text_usuario2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTurmas;
    // End of variables declaration//GEN-END:variables
}
