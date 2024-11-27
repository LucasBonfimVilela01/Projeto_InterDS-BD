/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package controle;

import conexao.Conexao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FATEC ZONA LESTE
 */
public class Planos extends javax.swing.JFrame {
    
    Conexao con_plano;
    Conexao con_cliente;
    Conexao con_instrutor;
    Conexao con_turma;
    Conexao con_laudo;
    
    private int clienteId;
    
    public Planos(int cliente_id) {
        initComponents();
        this.clienteId = cliente_id;
        
        con_cliente = new Conexao(); // Inicializa o objeto de conexão
        con_cliente.conecta(); // Conecta ao banco
        con_cliente.executaSQL("SELECT nome_Cliente FROM cliente WHERE id_Cliente = " + cliente_id);
        
        con_laudo = new Conexao(); // Inicializa o objeto de conexão
        con_laudo.conecta(); // Conecta ao banco
        con_laudo.executaSQL("SELECT * FROM laudo WHERE id_Cliente = " + cliente_id);
        
        con_turma = new Conexao(); // Inicializa o objeto de conexão
        con_turma.conecta(); // Conecta ao banco
        con_turma.executaSQL("SELECT * FROM turma ORDER BY id_Turma");
        
        con_instrutor = new Conexao(); // Inicializa o objeto de conexão
        con_instrutor.conecta(); // Conecta ao banco
        con_instrutor.executaSQL("SELECT * FROM instrutor ORDER BY id_Instrutor");
        
        con_plano = new Conexao(); // Inicializa o objeto de conexão
        con_plano.conecta(); // Conecta ao banco
        con_plano.executaSQL("SELECT * FROM plano ORDER BY id_plano");
        
        try {
            con_laudo.resultset.first();
            int yoga = Integer.parseInt(con_laudo.resultset.getString("yoga"));
            if(yoga==1){
                System.out.println("Pode fazer Yoga");
                RadioYoga.setSelected(true);
                RadioYoga.addChangeListener(e -> {
                    if (!RadioYoga.isSelected()) {
                        RadioYoga.setSelected(true);
                    }
                });
                preencherTabelaYoga();
                posicionarRegistro();
            }else{
                System.out.println("Não pode fazer Yoga");
                RadioYoga.addChangeListener(e -> {
                    if (RadioYoga.isSelected()) {
                        RadioYoga.setSelected(false);
                    }
                });
            }
            int pilates = Integer.parseInt(con_laudo.resultset.getString("pilates"));
            if(pilates==1){
                System.out.println("Pode fazer pilates");
                RadioPilates.setSelected(true);
                RadioPilates.addChangeListener(e -> {
                    if (!RadioPilates.isSelected()) {
                        RadioPilates.setSelected(true);
                    }
                });
                preencherTabelaPilates();
                posicionarRegistro();
            }else{
                System.out.println("Não pode fazer pilates");
                RadioPilates.addChangeListener(e -> {
                    if (RadioPilates.isSelected()) {
                        RadioPilates.setSelected(false);
                    }
                });
            }
            int spinning = Integer.parseInt(con_laudo.resultset.getString("spinning"));
            if(spinning==1){
                System.out.println("Pode fazer spinning");
                RadioSpinning.setSelected(true);
                RadioSpinning.addChangeListener(e -> {
                    if (!RadioSpinning.isSelected()) {
                        RadioSpinning.setSelected(true);
                    }
                });
                preencherTabelaSpinning();
                posicionarRegistro();
            }else{
                System.out.println("Não pode fazer spinning");
                RadioSpinning.addChangeListener(e -> {
                    if (RadioSpinning.isSelected()) {
                        RadioSpinning.setSelected(false);
                    }
                });
            }
            int jump = Integer.parseInt(con_laudo.resultset.getString("jump"));
            if(jump==1){
                System.out.println("Pode fazer jump");
                RadioJump.setSelected(true);
                RadioJump.addChangeListener(e -> {
                    if (!RadioJump.isSelected()) {
                        RadioJump.setSelected(true);
                    }
                });
                preencherTabelaJump();
                posicionarRegistro();
            }else{
                System.out.println("Não pode fazer jump");
                RadioJump.addChangeListener(e -> {
                    if (RadioJump.isSelected()) {
                        RadioJump.setSelected(false);
                    }
                });
            }
            int zumba = Integer.parseInt(con_laudo.resultset.getString("zumba"));
            if(zumba==1){
                System.out.println("Pode fazer zumba");
                RadioZumba.setSelected(true);
                RadioZumba.addChangeListener(e -> {
                    if (!RadioZumba.isSelected()) {
                        RadioZumba.setSelected(true);
                    }
                });
                preencherTabelaZumba();
                posicionarRegistro();
            }else{
                System.out.println("Não pode fazer zumba");
                RadioZumba.addChangeListener(e -> {
                    if (RadioZumba.isSelected()) {
                        RadioZumba.setSelected(false);
                    }
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse registro:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            Logger.getLogger(Planos.class.getName()).log(Level.SEVERE, null, ex);
        }
    try {
        // Move o cursor para o primeiro registro retornado
        if (con_cliente.resultset.next()) { 
            // Atualiza o campo com o nome do médico
            TextNomeCliente.setText(con_cliente.resultset.getString("nome_Cliente"));
        } else {
            // Exibe mensagem caso nenhum resultado seja encontrado
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        // Trata possíveis erros na manipulação do ResultSet
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Médico:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(criar_laudo.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblYoga = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPilates = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblZumba = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSpinning = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblJump = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Campo_NomePlano = new javax.swing.JTextField();
        Campo_DuracaoPlano = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Campo_Categoria = new javax.swing.JTextField();
        Campo_Horario = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Campo_NomeInstrutor = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Campo_IdInstrutor = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        TextNomeCliente = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        RadioYoga = new javax.swing.JRadioButton();
        RadioPilates = new javax.swing.JRadioButton();
        RadioSpinning = new javax.swing.JRadioButton();
        RadioZumba = new javax.swing.JRadioButton();
        RadioJump = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        Campo_IdTurma = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Campo_IdPlano = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Zumba");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.setRequestFocusEnabled(false);
        jScrollPane6.setViewportView(jTable4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(226, 226, 250));
        jPanel2.setPreferredSize(new java.awt.Dimension(691, 432));
        jPanel2.setRequestFocusEnabled(false);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Planos ");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(226, 226, 250));

        tblYoga.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Duração"
            }
        ));
        tblYoga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblYogaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblYoga);

        jLabel1.setBackground(new java.awt.Color(226, 226, 250));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Yoga");

        tblPilates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Duração"
            }
        ));
        tblPilates.setRequestFocusEnabled(false);
        tblPilates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPilatesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPilates);

        jLabel3.setBackground(new java.awt.Color(226, 226, 250));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Pilates");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Zumba");

        tblZumba.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Duração"
            }
        ));
        tblZumba.setRequestFocusEnabled(false);
        tblZumba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblZumbaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblZumba);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Spinning");

        tblSpinning.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Duração"
            }
        ));
        tblSpinning.setRequestFocusEnabled(false);
        tblSpinning.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSpinningMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblSpinning);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Jump");

        tblJump.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nome", "Duração"
            }
        ));
        tblJump.setRequestFocusEnabled(false);
        tblJump.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblJumpMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblJump);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 65, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setViewportView(jPanel3);

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setText("Assinar");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("Nome do Plano:");

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("Duração:");

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("Horário:");

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("Instrutor:");

        jLabel12.setText("meses");

        jLabel13.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel13.setText("ID do instrutor:");
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setText("Categoria:");

        jLabel15.setText("Logado como: ");

        TextNomeCliente.setText("NomeCliente");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel16.setText("Disponíveis para o usuário:");

        RadioYoga.setText("Yoga");

        RadioPilates.setText("Pilates");

        RadioSpinning.setText("Spinning");

        RadioZumba.setText("Zumba");

        RadioJump.setText("Jump");

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel17.setText("ID da turma:");

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel18.setText("ID do plano:");

        Campo_IdPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_IdPlanoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_DuracaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Campo_Horario))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel14)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Campo_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_IdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_NomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Campo_IdInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(RadioSpinning)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(RadioJump))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(RadioYoga)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RadioPilates)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(RadioZumba)))
                                .addGap(0, 6, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_IdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Campo_NomePlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(Campo_IdPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Campo_DuracaoPlano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(RadioYoga)
                    .addComponent(RadioPilates)
                    .addComponent(RadioZumba))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(Campo_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RadioSpinning)
                    .addComponent(RadioJump))
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Campo_Horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(Campo_IdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(Campo_NomeInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Campo_IdInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextNomeCliente)))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int IdCliente = clienteId;
        String idPlano = Campo_IdPlano.getText();
        String idTurma = Campo_IdTurma.getText();
        String iniciocurso = getCurrentDate();
        String fimcurso = addMonthsToDate(iniciocurso,Integer.parseInt(Campo_DuracaoPlano.getText()));
    
            try{
                String insert_sql="INSERT INTO `assinatura`(`id_Cliente`, `id_Plano`, `id_Turma`, `inicioCurso`, `fimCurso`) VALUES ('" + IdCliente + "','" + idPlano + "','" + idTurma + "','"+iniciocurso+"','"+fimcurso+"')";
                con_instrutor.statement.executeUpdate(insert_sql);
                JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso!!", "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException errosql){
                JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n "+errosql, "Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
                System.out.println(errosql);
            }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblYogaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblYogaMouseClicked
        int linha_selecionada = tblYoga.getSelectedRow();

        Object nomePlano = tblYoga.getValueAt(linha_selecionada, 1);
        Object duracaoPlano = tblYoga.getValueAt(linha_selecionada, 2);
        Object idPlano = tblYoga.getValueAt(linha_selecionada, 0);
        getHorario(idPlano);
        
        if (nomePlano != null) {
            Campo_NomePlano.setText(nomePlano.toString());
        }
        if (duracaoPlano != null) {
            Campo_DuracaoPlano.setText(duracaoPlano.toString());
        }
            
        Campo_Categoria.setText("Yoga");
    }//GEN-LAST:event_tblYogaMouseClicked

    private void tblPilatesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPilatesMouseClicked
        int linha_selecionada = tblPilates.getSelectedRow();
        Object nomePlano = tblPilates.getValueAt(linha_selecionada, 1).toString();
        Object duracaoPlano = tblPilates.getValueAt(linha_selecionada, 2).toString();
        Object idPlano = tblPilates.getValueAt(linha_selecionada, 0);
        getHorario(idPlano);
        
        if (nomePlano != null) {
            Campo_NomePlano.setText(nomePlano.toString());
        }
        if (duracaoPlano != null) {
            Campo_DuracaoPlano.setText(duracaoPlano.toString());
        }
        
        Campo_Categoria.setText("Pilates");  
    }//GEN-LAST:event_tblPilatesMouseClicked

    private void tblZumbaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblZumbaMouseClicked
        int linha_selecionada = tblZumba.getSelectedRow();
        Object nomePlano = tblZumba.getValueAt(linha_selecionada, 1).toString();
        Object duracaoPlano = tblZumba.getValueAt(linha_selecionada, 2).toString();
        Object idPlano = tblZumba.getValueAt(linha_selecionada, 0);
        getHorario(idPlano);
        
        if (nomePlano != null) {
            Campo_NomePlano.setText(nomePlano.toString());
        }
        if (duracaoPlano != null) {
            Campo_DuracaoPlano.setText(duracaoPlano.toString());
        }
        
        Campo_Categoria.setText("Zumba");
    }//GEN-LAST:event_tblZumbaMouseClicked

    private void tblSpinningMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSpinningMouseClicked
        int linha_selecionada = tblSpinning.getSelectedRow();
        Object nomePlano = tblSpinning.getValueAt(linha_selecionada, 1).toString();
        Object duracaoPlano = tblSpinning.getValueAt(linha_selecionada, 2).toString();
        Object idPlano = tblSpinning.getValueAt(linha_selecionada, 0);
        getHorario(idPlano);
        
        if (nomePlano != null) {
            Campo_NomePlano.setText(nomePlano.toString());
        }
        if (duracaoPlano != null) {
            Campo_DuracaoPlano.setText(duracaoPlano.toString());
        }
        
        Campo_Categoria.setText("Spinning");
    }//GEN-LAST:event_tblSpinningMouseClicked

    private void tblJumpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblJumpMouseClicked
        int linha_selecionada = tblJump.getSelectedRow();
        Object nomePlano = tblJump.getValueAt(linha_selecionada, 1).toString();
        Object duracaoPlano = tblJump.getValueAt(linha_selecionada, 2).toString();
        Object idPlano = tblJump.getValueAt(linha_selecionada, 0);
        getHorario(idPlano);
        
        if (nomePlano != null) {
            Campo_NomePlano.setText(nomePlano.toString());
        }
        if (duracaoPlano != null) {
            Campo_DuracaoPlano.setText(duracaoPlano.toString());
        }
        
        Campo_Categoria.setText("Jump");
    }//GEN-LAST:event_tblJumpMouseClicked

    private void Campo_IdPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_IdPlanoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_IdPlanoActionPerformed

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
            java.util.logging.Logger.getLogger(Planos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Planos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Planos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Planos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Planos(3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Campo_Categoria;
    private javax.swing.JTextField Campo_DuracaoPlano;
    private javax.swing.JTextField Campo_Horario;
    private javax.swing.JTextField Campo_IdInstrutor;
    private javax.swing.JTextField Campo_IdPlano;
    private javax.swing.JTextField Campo_IdTurma;
    private javax.swing.JTextField Campo_NomeInstrutor;
    private javax.swing.JTextField Campo_NomePlano;
    private javax.swing.JRadioButton RadioJump;
    private javax.swing.JRadioButton RadioPilates;
    private javax.swing.JRadioButton RadioSpinning;
    private javax.swing.JRadioButton RadioYoga;
    private javax.swing.JRadioButton RadioZumba;
    private javax.swing.JLabel TextNomeCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable tblJump;
    private javax.swing.JTable tblPilates;
    private javax.swing.JTable tblSpinning;
    private javax.swing.JTable tblYoga;
    private javax.swing.JTable tblZumba;
    // End of variables declaration//GEN-END:variables
private void preencherTabela(JTable table, String categoria, int[] columnWidths) {
    for (int i = 0; i < columnWidths.length; i++) {
        table.getColumnModel().getColumn(i).setPreferredWidth(columnWidths[i]);
    }
    
    DefaultTableModel modelo = (DefaultTableModel) table.getModel();
    modelo.setNumRows(0);
    
    try {
        con_plano.executaSQL("SELECT * FROM plano WHERE categoria = '" + categoria + "' ORDER BY id_Plano");
        con_plano.resultset.beforeFirst();
        
        while (con_plano.resultset.next()) {
            modelo.addRow(new Object[]{
                con_plano.resultset.getString("id_Plano"),
                con_plano.resultset.getString("nome_Plano"),
                con_plano.resultset.getString("duracao")
            });
        }
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(
            null,
            "\n Erro ao listar dados da tabela!! :\n " + erro,
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}

private void preencherTabelaYoga() {
    preencherTabela(tblYoga, "Yoga", new int[]{2, 30, 100});
}

private void preencherTabelaPilates() {
    preencherTabela(tblPilates, "Pilates", new int[]{2, 30, 100});
}

private void preencherTabelaSpinning() {
    preencherTabela(tblSpinning, "Spinning", new int[]{2, 30, 100});
}

private void preencherTabelaJump() {
    preencherTabela(tblJump, "Jump", new int[]{2, 30, 100});
}

private void preencherTabelaZumba() {
    preencherTabela(tblZumba, "Zumba", new int[]{2, 30, 100});
}

private void posicionarRegistro() {
    try {
        con_plano.resultset.first();
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(
            null,
            "Não foi possível posicionar no primeiro registro: " + erro,
            "Mensagem do Programa",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}

private void getHorario(Object idPlano) {
    Campo_Horario.setText("");
    Campo_IdPlano.setText(""+idPlano);
    try {
        String sql = "SELECT id_Turma FROM plano WHERE id_Plano = " + idPlano.toString();
        con_plano.executaSQL(sql);

        if (con_plano.resultset.next()) {
            int idturma = con_plano.resultset.getInt("id_Turma");
            if (idturma != 0) {
                Campo_IdTurma.setText(""+idturma);
            }

            String sqlTurma = "SELECT horario FROM turma WHERE id_Turma = " + idturma;
            con_turma.executaSQL(sqlTurma);

            if (con_turma.resultset.next()) {
                Campo_Horario.setText(con_turma.resultset.getString("horario"));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Plano não encontrado para o id_Plano: " + idPlano, "Erro", JOptionPane.ERROR_MESSAGE);
        }

        String idTurmaText = Campo_IdTurma.getText().trim();
        if (!idTurmaText.isEmpty()) {
            int idTurma = Integer.parseInt(idTurmaText);
            String sqlInstrutor = "SELECT `id_ Instrutor` FROM turma WHERE id_Turma = " + idTurma;

            con_turma.executaSQL(sqlInstrutor);
            if (con_turma.resultset.next()) {
                Campo_IdInstrutor.setText(con_turma.resultset.getString("id_ Instrutor"));
            } else {
                JOptionPane.showMessageDialog(null, "Instrutor não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Id da Turma está vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar essa Turma!:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(Planos.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    con_instrutor.executaSQL("SELECT * FROM instrutor WHERE id_Instrutor = " + Campo_IdInstrutor.getText());

    try {
        // Move o cursor para o primeiro registro retornado
        if (con_instrutor.resultset.next()) { 
            // Atualiza o campo com o nome do médico
            Campo_NomeInstrutor.setText(con_instrutor.resultset.getString("nome_Instrutor"));
        } else {
            // Exibe mensagem caso nenhum resultado seja encontrado
            JOptionPane.showMessageDialog(null, "Instrutor não encontrado!", "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException ex) {
        // Trata possíveis erros na manipulação do ResultSet
        JOptionPane.showMessageDialog(null, "\n Não foi possível encontrar esse Instrutor:\n " + ex, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        Logger.getLogger(Turmas_Instrutor.class.getName()).log(Level.SEVERE, null, ex);
    }
}
public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return currentDate.format(formatter);
    }
public static String addMonthsToDate(String date, int monthsToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        
        LocalDate localDate = LocalDate.parse(date, formatter);
        
        LocalDate newDate = localDate.plusMonths(monthsToAdd);
        
        return newDate.format(formatter);
    }



}
    
