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

public class Assinatura extends javax.swing.JFrame {
    Conexao con_cliente;
    Conexao con_assinatura;
    Conexao con_plano;
    private int clienteId;
    
   public Assinatura(int cliente_id) {
    initComponents();
    this.clienteId = cliente_id;

    con_plano = new Conexao(); // Inicializa o objeto de conexão
    con_plano.conecta(); // Conecta ao banco
    con_plano.executaSQL("SELECT * FROM plano ORDER BY id_Plano");
    
    // Inicialização e execução do código
    con_cliente = new Conexao(); // Inicializa o objeto de conexão
    con_cliente.conecta(); // Conecta ao banco
    con_cliente.executaSQL("SELECT nome_Cliente, CPF_Cliente, RG_Cliente, UF_Cliente, endereco_Cliente, telefone_Cliente, email_Cliente, nasc_Cliente FROM cliente WHERE id_Cliente = " + cliente_id);
    
    try {
        if (con_cliente.resultset.next()) { 
            Text_nome.setText(con_cliente.resultset.getString("nome_Cliente"));
            Text_cpf.setText(con_cliente.resultset.getString("CPF_Cliente"));
            Text_rg.setText(con_cliente.resultset.getString("RG_Cliente"));
            Text_uf.setText(con_cliente.resultset.getString("UF_Cliente"));
            Text_end.setText(con_cliente.resultset.getString("endereco_Cliente"));
            Text_tel.setText(con_cliente.resultset.getString("telefone_Cliente"));
            Text_email.setText(con_cliente.resultset.getString("email_Cliente"));
            Text_nasc.setText(con_cliente.resultset.getString("nasc_Cliente"));
            
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Médico:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(Assinatura.class.getName()).log(Level.SEVERE, null, ex);
    }

    con_cliente = new Conexao();
    con_cliente.conecta();
    con_cliente.executaSQL("SELECT * FROM cliente ORDER BY id_Cliente");
    
    con_assinatura = new Conexao();// inicialização do objeto como instância
    con_assinatura.conecta();  //chama o método conecta
    con_assinatura.executaSQL("SELECT * FROM assinatura WHERE id_Cliente = " + clienteId + " ORDER BY fimCurso");
        
    preencherTabela();
    posicionarRegistro(); 
    tblAssinaturas.setAutoCreateRowSorter(true);// ativa a classificação ordenada da tabela
    
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Text_nome = new javax.swing.JLabel();
        Text_email = new javax.swing.JLabel();
        Text_tel = new javax.swing.JLabel();
        Text_cpf = new javax.swing.JLabel();
        Text_rg = new javax.swing.JLabel();
        Text_end = new javax.swing.JLabel();
        Text_uf = new javax.swing.JLabel();
        Text_nasc = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tittle_nome = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAssinaturas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Campo_NomePlano = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Campo_IdPlano = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(691, 432));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setPreferredSize(new java.awt.Dimension(180, 250));

        Text_nome.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_nome.setText("Rafael");

        Text_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_email.setText("Rafael@gmail.com");

        Text_tel.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_tel.setText("(11) 90844-9826");

        Text_cpf.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_cpf.setText("986.324.028.41");

        Text_rg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_rg.setText("14 128 876 - 4");

        Text_end.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_end.setText("rua Legal, 917");

        Text_uf.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_uf.setText("SP");

        Text_nasc.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        Text_nasc.setText("10/19/1997");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Usuário");

        tittle_nome.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        tittle_nome.setText("Nome:");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setText("Email:");

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel19.setText("Telefone:");

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel20.setText("CPF:");

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel25.setText("RG:");

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel26.setText("Endereço:");

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel27.setText("UF:");

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel28.setText("Nascimento:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_tel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_cpf))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_end))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Text_rg))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_nasc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tittle_nome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_nome))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Text_email))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Text_uf)))
                .addGap(0, 31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tittle_nome)
                    .addComponent(Text_nome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(Text_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Text_tel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_cpf)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(Text_rg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Text_end)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(Text_nasc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(Text_uf))
                .addGap(25, 25, 25))
        );

        jButton1.setBackground(new java.awt.Color(174, 174, 238));
        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setText("+");
        jButton1.setToolTipText("Mais planos");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Assinaturas");

        tblAssinaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Inicio", "Fim"
            }
        ));
        tblAssinaturas.setToolTipText("");
        tblAssinaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAssinaturasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAssinaturas);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Nome do plano:");

        Campo_NomePlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_NomePlanoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("ID do plano:");

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_IdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Campo_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(139, 139, 139)))))
                .addGap(51, 51, 51))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Campo_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Campo_IdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Planos(clienteId).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblAssinaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAssinaturasMouseClicked
       int linha_selecionada = tblAssinaturas.getSelectedRow();
        Campo_IdPlano.setText(tblAssinaturas.getValueAt(linha_selecionada, 0).toString());
        
        con_plano.executaSQL("SELECT nome_Plano FROM plano WHERE id_Plano = " + tblAssinaturas.getValueAt(linha_selecionada, 0));

    try {
        // Move o cursor para o primeiro registro retornado
        if (con_plano.resultset.next()) { 
            // Atualiza o campo com o nome do médico
            Campo_NomePlano.setText(con_plano.resultset.getString("nome_Plano"));
        } else {
            // Exibe mensagem caso nenhum resultado seja encontrado
            JOptionPane.showMessageDialog(null, "Plano não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        // Trata possíveis erros na manipulação do ResultSet
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Médico:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(criar_laudo.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_tblAssinaturasMouseClicked

    private void Campo_NomePlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_NomePlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_NomePlanoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        con_assinatura.executaSQL("SELECT * FROM assinatura WHERE id_Cliente = " + clienteId + " ORDER BY fimCurso");
        preencherTabela();
        posicionarRegistro();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void posicionarRegistro() {
        try{
            con_assinatura.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

      public void preencherTabela(){
        tblAssinaturas.getColumnModel().getColumn(0).setPreferredWidth(2);
        tblAssinaturas.getColumnModel().getColumn(1).setPreferredWidth(50);
        tblAssinaturas.getColumnModel().getColumn(2).setPreferredWidth(50);
        
        DefaultTableModel modelo = (DefaultTableModel) tblAssinaturas.getModel();
        modelo.setNumRows(0);
        
        try{
            con_assinatura.resultset.beforeFirst();
           
            while(con_assinatura.resultset.next()){
                modelo.addRow(new Object[]{
                    con_assinatura.resultset.getString("id_Plano"),
                    con_assinatura.resultset.getString("inicioCurso"),
                    con_assinatura.resultset.getString("fimCurso")
                });
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
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
            java.util.logging.Logger.getLogger(Assinatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Assinatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Assinatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Assinatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Assinatura(3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Campo_IdPlano;
    private javax.swing.JTextField Campo_NomePlano;
    private javax.swing.JLabel Text_cpf;
    private javax.swing.JLabel Text_email;
    private javax.swing.JLabel Text_end;
    private javax.swing.JLabel Text_nasc;
    private javax.swing.JLabel Text_nome;
    private javax.swing.JLabel Text_rg;
    private javax.swing.JLabel Text_tel;
    private javax.swing.JLabel Text_uf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAssinaturas;
    private javax.swing.JLabel tittle_nome;
    // End of variables declaration//GEN-END:variables

}
