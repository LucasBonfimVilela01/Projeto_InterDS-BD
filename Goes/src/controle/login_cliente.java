package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class login_cliente extends javax.swing.JFrame {

    Conexao con_cliente;
    
    public login_cliente()
            
            {
        initComponents();
        con_cliente = new Conexao();// inicialização do objeto como instância
        con_cliente.conecta();  //chama o método conecta
        con_cliente.executaSQL("select * from cliente order by id_Cliente");
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
        Text_titulo = new javax.swing.JLabel();
        Text_senha = new javax.swing.JLabel();
        Campo_senha = new javax.swing.JPasswordField();
        Text_email = new javax.swing.JLabel();
        Campo_email = new javax.swing.JTextField();
        BotaoDentrada = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(691, 432));

        Text_titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_titulo.setText("Entrar como Cliente");

        Text_senha.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_senha.setText("Senha:");

        Campo_senha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        Text_email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_email.setText("Email:");

        Campo_email.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        BotaoDentrada.setBackground(new java.awt.Color(204, 204, 255));
        BotaoDentrada.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BotaoDentrada.setText("Entrar");
        BotaoDentrada.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoDentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDentradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Text_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Text_senha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(Text_email)
                            .addGap(18, 18, 18)
                            .addComponent(Campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoDentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(Text_titulo)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Campo_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_email))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Campo_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Text_senha))
                .addGap(57, 57, 57)
                .addComponent(BotaoDentrada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BotaoDentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDentradaActionPerformed
        String Email = Campo_email.getText();
        String Senha = Campo_senha.getText();
        int cliente_id = 0;
        con_cliente.executaSQL("SELECT id_Cliente FROM cliente WHERE senha_Cliente = '"+ Senha +"' AND email_Cliente = '"+ Email +"'");
        try {
            if (con_cliente.resultset.next()) { // Move o cursor para o primeiro registro
                cliente_id = con_cliente.resultset.getInt("id_Cliente");
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
                return; // Interrompe o fluxo se o médico não foi encontrado
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n Não foi possível buscar o cliente:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            ex.printStackTrace(); // Ajuda na depuração
        }
        new Assinatura(cliente_id).setVisible(true);
        setVisible(false);
        
    }//GEN-LAST:event_BotaoDentradaActionPerformed

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
            java.util.logging.Logger.getLogger(login_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login_cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login_cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoDentrada;
    private javax.swing.JTextField Campo_email;
    private javax.swing.JPasswordField Campo_senha;
    private javax.swing.JLabel Text_email;
    private javax.swing.JLabel Text_senha;
    private javax.swing.JLabel Text_titulo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
