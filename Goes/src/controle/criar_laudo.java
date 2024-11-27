
package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class criar_laudo extends javax.swing.JFrame {
    
    Conexao con_medico;
    Conexao con_cliente;
    Conexao con_laudo;
    private int medicoId;

   public criar_laudo(int medico_id) {
       
    initComponents();
    this.medicoId = medico_id;
    
    con_medico = new Conexao(); // Inicializa o objeto de conexão
    con_medico.conecta(); // Conecta ao banco
    con_medico.executaSQL("SELECT nome_Medico FROM medico WHERE id_Medico = " + medico_id);

    try {
        // Move o cursor para o primeiro registro retornado
        if (con_medico.resultset.next()) { 
            // Atualiza o campo com o nome do médico
            Campo_medico.setText(con_medico.resultset.getString("nome_Medico"));
        } else {
            // Exibe mensagem caso nenhum resultado seja encontrado
            JOptionPane.showMessageDialog(null, "Médico não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        // Trata possíveis erros na manipulação do ResultSet
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Médico:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(criar_laudo.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        con_cliente = new Conexao();// inicialização do objeto como instância
        con_cliente.conecta();  //chama o método conecta
        con_cliente.executaSQL("select * from cliente order by id_Cliente");
        
        preencherTabela();
        posicionarRegistro(); 
        tblClientes.setAutoCreateRowSorter(true);// ativa a classificação ordenada da tabela
        
        con_laudo = new Conexao();// inicialização do objeto como instância
        con_laudo.conecta();  
        con_laudo.executaSQL("select * from laudo order by id_Laudo");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Text_usuario = new javax.swing.JLabel();
        Campo_usuario = new javax.swing.JTextField();
        BotaoDecadastro = new javax.swing.JButton();
        Text_titulo = new javax.swing.JLabel();
        Campo_medico = new javax.swing.JTextField();
        Text_Email = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pilatesCheckbox = new javax.swing.JCheckBox();
        Text_Email1 = new javax.swing.JLabel();
        zumbaCheckbox = new javax.swing.JCheckBox();
        jumpCheckbox = new javax.swing.JCheckBox();
        yogaCheckbox = new javax.swing.JCheckBox();
        spinningCheckbox = new javax.swing.JCheckBox();
        Text_Email3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        Texto_idCliente = new javax.swing.JLabel();
        Campo_IdClientes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(226, 226, 250));
        jPanel1.setPreferredSize(new java.awt.Dimension(691, 432));

        Text_usuario.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_usuario.setText("Nome do Cliente:");

        Campo_usuario.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N

        BotaoDecadastro.setBackground(new java.awt.Color(204, 204, 255));
        BotaoDecadastro.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        BotaoDecadastro.setText("Enviar");
        BotaoDecadastro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        BotaoDecadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDecadastroActionPerformed(evt);
            }
        });

        Text_titulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Text_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Text_titulo.setText("Criar Laudo");

        Campo_medico.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        Campo_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_medicoActionPerformed(evt);
            }
        });

        Text_Email.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_Email.setText("Nome do Médico:");

        pilatesCheckbox.setText("Pilates");
        pilatesCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilatesCheckboxActionPerformed(evt);
            }
        });

        Text_Email1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_Email1.setText("Dados do Cliente:");

        zumbaCheckbox.setText("Zumba");
        zumbaCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zumbaCheckboxActionPerformed(evt);
            }
        });

        jumpCheckbox.setText("Jump");
        jumpCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumpCheckboxActionPerformed(evt);
            }
        });

        yogaCheckbox.setText("Yoga");
        yogaCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yogaCheckboxActionPerformed(evt);
            }
        });

        spinningCheckbox.setText("Spinning");
        spinningCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spinningCheckboxActionPerformed(evt);
            }
        });

        Text_Email3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Text_Email3.setText("Permitido:");

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "Data Nascimento"
            }
        ));
        tblClientes.setToolTipText("");
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblClientes);

        jScrollPane2.setViewportView(jScrollPane1);

        Texto_idCliente.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Texto_idCliente.setText("ID:");
        Texto_idCliente.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Text_titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Text_Email)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_medico))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Text_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_usuario))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Text_Email1)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BotaoDecadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pilatesCheckbox)
                            .addComponent(jumpCheckbox)
                            .addComponent(zumbaCheckbox)
                            .addComponent(spinningCheckbox)
                            .addComponent(yogaCheckbox)
                            .addComponent(Text_Email3))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Texto_idCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_IdClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Text_titulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_usuario)
                            .addComponent(Campo_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto_idCliente)
                            .addComponent(Campo_IdClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Text_Email)
                            .addComponent(Campo_medico, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addComponent(Text_Email1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Text_Email3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yogaCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pilatesCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jumpCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(zumbaCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinningCheckbox)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoDecadastro)
                        .addGap(15, 15, 15))))
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
        int id_cliente = Integer.parseInt(Campo_IdClientes.getText());
        int id_medico = medicoId;
        
        int yoga = 0;
        if (yogaCheckbox.isSelected()){yoga = 1;}
        else yoga = 0;
        
        int pilates = 0;
        if (pilatesCheckbox.isSelected()){pilates = 1;}
        else pilates = 0;
        
        int spinning = 0;
        if (spinningCheckbox.isSelected()){spinning = 1;}
        else spinning = 0;
        
        int jump = 0;
        if (jumpCheckbox.isSelected()){jump = 1;}
        else jump = 0;
        
        int zumba = 0;
        if (zumbaCheckbox.isSelected()){zumba = 1;}
        else zumba = 0;
        
         try{
                String insert_sql="INSERT INTO `laudo`(`id_Cliente`, `id_Medico`, `yoga`, `pilates`, `spinning`, `jump`, `zumba`) VALUES (" + id_cliente + "," + id_medico + "," + yoga + "," + pilates + "," + spinning + "," + jump + "," + zumba  + ")";
                con_laudo.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                new login_medico().setVisible(true);
                setVisible(false);
            }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(errosql);
            }
        
    }//GEN-LAST:event_BotaoDecadastroActionPerformed

    private void Campo_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_medicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_medicoActionPerformed

    private void pilatesCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilatesCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pilatesCheckboxActionPerformed

    private void zumbaCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zumbaCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zumbaCheckboxActionPerformed

    private void jumpCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumpCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumpCheckboxActionPerformed

    private void yogaCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yogaCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yogaCheckboxActionPerformed

    private void spinningCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spinningCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spinningCheckboxActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        int linha_selecionada = tblClientes.getSelectedRow();
        Campo_IdClientes.setText(tblClientes.getValueAt(linha_selecionada, 0).toString());
        Campo_usuario.setText(tblClientes.getValueAt(linha_selecionada, 1).toString());
    }//GEN-LAST:event_tblClientesMouseClicked

     public void posicionarRegistro() {
        try{
            con_cliente.resultset.first();
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Não foi possível posicionar no primeiro registro: "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }

      public void preencherTabela(){
        tblClientes.getColumnModel().getColumn(0).setPreferredWidth(2);
        tblClientes.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblClientes.getColumnModel().getColumn(3).setPreferredWidth(20);
        
        DefaultTableModel modelo = (DefaultTableModel) tblClientes.getModel();
        modelo.setNumRows(0);
        
        try{
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("id_Cliente"),con_cliente.resultset.getString("nome_Cliente"),con_cliente.resultset.getString("email_Cliente"),con_cliente.resultset.getString("nasc_Cliente")
                });
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n "+erro,"Mensagem do Programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
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
            java.util.logging.Logger.getLogger(criar_laudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(criar_laudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(criar_laudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(criar_laudo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new criar_laudo(16).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoDecadastro;
    private javax.swing.JTextField Campo_IdClientes;
    private javax.swing.JTextField Campo_medico;
    private javax.swing.JTextField Campo_usuario;
    private javax.swing.JLabel Text_Email;
    private javax.swing.JLabel Text_Email1;
    private javax.swing.JLabel Text_Email3;
    private javax.swing.JLabel Text_titulo;
    private javax.swing.JLabel Text_usuario;
    private javax.swing.JLabel Texto_idCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox jumpCheckbox;
    private javax.swing.JCheckBox pilatesCheckbox;
    private javax.swing.JCheckBox spinningCheckbox;
    private javax.swing.JTable tblClientes;
    private javax.swing.JCheckBox yogaCheckbox;
    private javax.swing.JCheckBox zumbaCheckbox;
    // End of variables declaration//GEN-END:variables
}
