
package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class cadastro_medico extends javax.swing.JFrame {
    
    Conexao con_medico;

    public cadastro_medico() {
        initComponents();
        con_medico = new Conexao();// inicialização do objeto como instância
        con_medico.conecta();  //chama o método conecta
        con_medico.executaSQL("select * from medico order by id_Medico");
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Text_usuario = new javax.swing.JLabel();
        Campo_usuario = new javax.swing.JTextField();
        Text_senha = new javax.swing.JLabel();
        BotaoDecadastro = new javax.swing.JButton();
        Text_titulo = new javax.swing.JLabel();
        Text_cpf = new javax.swing.JLabel();
        Campo_email = new javax.swing.JTextField();
        Text_Email = new javax.swing.JLabel();
        Text_rg = new javax.swing.JLabel();
        text_uf = new javax.swing.JLabel();
        Text_endereco = new javax.swing.JLabel();
        Text_formacao = new javax.swing.JLabel();
        Text_telefone = new javax.swing.JLabel();
        Text_nascimento = new javax.swing.JLabel();
        Campo_endereco = new javax.swing.JTextField();
        Campo_senha = new javax.swing.JPasswordField();
        Campo_cpf = new javax.swing.JFormattedTextField();
        Campo_nascimento = new javax.swing.JFormattedTextField();
        Campo_formacao = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        Text_corfirmar = new javax.swing.JLabel();
        Campo_ConfirmarSenha = new javax.swing.JPasswordField();
        Campo_telefone = new javax.swing.JFormattedTextField();
        Campo_rg = new javax.swing.JFormattedTextField();
        Campo_uf = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(691, 432));

        Text_usuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_usuario.setText("Usuário:");

        Campo_usuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        Text_senha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_senha.setText("Senha:");

        BotaoDecadastro.setBackground(new java.awt.Color(204, 204, 255));
        BotaoDecadastro.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BotaoDecadastro.setText("Entrar");
        BotaoDecadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoDecadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDecadastroActionPerformed(evt);
            }
        });

        Text_titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_titulo.setText("Cadastro de Médico");

        Text_cpf.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_cpf.setText("CPF:");

        Campo_email.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Campo_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_emailActionPerformed(evt);
            }
        });

        Text_Email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_Email.setText("Email:");

        Text_rg.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_rg.setText("RG:");

        text_uf.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        text_uf.setText("UF:");

        Text_endereco.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_endereco.setText("Endereço:");

        Text_formacao.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_formacao.setText("Formação:");

        Text_telefone.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_telefone.setText("Telefone:");

        Text_nascimento.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_nascimento.setText("Nascimento:");

        Campo_endereco.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        Campo_senha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        try {
            Campo_cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Campo_cpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_cpfActionPerformed(evt);
            }
        });

        try {
            Campo_nascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####/##/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Campo_nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_nascimentoActionPerformed(evt);
            }
        });

        Campo_formacao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        Campo_formacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_formacaoActionPerformed(evt);
            }
        });

        Text_corfirmar.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_corfirmar.setText("Corfirmar senha:");

        Campo_ConfirmarSenha.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Campo_ConfirmarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_ConfirmarSenhaActionPerformed(evt);
            }
        });

        try {
            Campo_telefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+55  ## #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Campo_rg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            Campo_uf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Campo_uf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_ufActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(545, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(Text_Email)
                        .addGap(18, 18, 18)
                        .addComponent(Campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Text_usuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Text_cpf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Campo_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_uf)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(Text_corfirmar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Campo_ConfirmarSenha))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Text_senha)
                                    .addGap(18, 18, 18)
                                    .addComponent(Campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Text_endereco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Campo_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Text_nascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_nascimento))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Text_telefone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_telefone))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Text_formacao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Campo_formacao, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Text_rg)
                        .addGap(18, 18, 18)
                        .addComponent(Campo_rg)))
                .addGap(47, 47, 47))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(BotaoDecadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(Text_titulo)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_usuario)
                            .addComponent(Campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_telefone)
                            .addComponent(Campo_telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_Email))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_senha))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_ConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_corfirmar))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_cpf)
                            .addComponent(Campo_cpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_uf)
                            .addComponent(Campo_uf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Text_rg)
                            .addComponent(Campo_rg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_nascimento))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Campo_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Text_endereco))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_formacao)
                            .addComponent(Campo_formacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(BotaoDecadastro)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoDecadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDecadastroActionPerformed
        String Nome = Campo_usuario.getText();
        String data_nasc = Campo_nascimento.getText();
        String Tel = Campo_telefone.getText();
        String Email = Campo_email.getText();
        String RG = Campo_rg.getText();
        String CPF = Campo_cpf.getText();
        String UF = Campo_uf.getText();
        String Endereco = Campo_endereco.getText();
        String Senha = Campo_senha.getText();
        String Formacao = Campo_formacao.getText();
        if(Senha.equals(Campo_ConfirmarSenha.getText())){   
            try{
                String insert_sql="INSERT INTO medico (senha_Medico, CPF_Medico, RG_Medico, nome_Medico, UF_Medico, endereco_Medico, telefone_Medico, email_Medico, nasc_Medico, formacao_Medico) VALUES ('" + Senha + "','" + CPF + "','" + RG + "','" + Nome + "','" + UF + "','" + Endereco + "','" + Tel + "','" + Email + "','" + data_nasc + "','" + Formacao + "')";
                con_medico.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                new login_medico().setVisible(true);
                setVisible(false);
            }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(errosql);
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Senha não confirmada", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            Campo_ConfirmarSenha.requestFocus();
        }

    }//GEN-LAST:event_BotaoDecadastroActionPerformed

    private void Campo_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_emailActionPerformed

    private void Campo_cpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_cpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_cpfActionPerformed

    private void Campo_nascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_nascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_nascimentoActionPerformed

    private void Campo_formacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_formacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_formacaoActionPerformed

    private void Campo_ufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_ufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_ufActionPerformed

    private void Campo_ConfirmarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_ConfirmarSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_ConfirmarSenhaActionPerformed

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
            java.util.logging.Logger.getLogger(cadastro_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastro_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastro_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastro_medico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastro_medico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoDecadastro;
    private javax.swing.JPasswordField Campo_ConfirmarSenha;
    private javax.swing.JFormattedTextField Campo_cpf;
    private javax.swing.JTextField Campo_email;
    private javax.swing.JTextField Campo_endereco;
    private javax.swing.JFormattedTextField Campo_formacao;
    private javax.swing.JFormattedTextField Campo_nascimento;
    private javax.swing.JFormattedTextField Campo_rg;
    private javax.swing.JPasswordField Campo_senha;
    private javax.swing.JFormattedTextField Campo_telefone;
    private javax.swing.JFormattedTextField Campo_uf;
    private javax.swing.JTextField Campo_usuario;
    private javax.swing.JLabel Text_Email;
    private javax.swing.JLabel Text_corfirmar;
    private javax.swing.JLabel Text_cpf;
    private javax.swing.JLabel Text_endereco;
    private javax.swing.JLabel Text_formacao;
    private javax.swing.JLabel Text_nascimento;
    private javax.swing.JLabel Text_rg;
    private javax.swing.JLabel Text_senha;
    private javax.swing.JLabel Text_telefone;
    private javax.swing.JLabel Text_titulo;
    private javax.swing.JLabel Text_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel text_uf;
    // End of variables declaration//GEN-END:variables
}
