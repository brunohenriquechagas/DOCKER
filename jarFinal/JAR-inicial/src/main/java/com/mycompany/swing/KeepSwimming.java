
package com.mycompany.swing;

import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPasswordField;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


public class KeepSwimming extends javax.swing.JFrame {
    String EMAIL;
    String SENHA;
   
    public KeepSwimming() {
        Log log = new Log();
        log.criarLog("===============Tela de Login===============");
        log.criarLog("Iniciando tela swing email&senha");
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoEmail = new javax.swing.JTextField();
        CampoSenha = new javax.swing.JPasswordField();
        btnNavegar = new javax.swing.JButton();
        TextoEmail = new javax.swing.JLabel();
        TextoSenha = new javax.swing.JLabel();
        Resultado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Keep Swimming");
        setMinimumSize(new java.awt.Dimension(1210, 716));
        setName("KeepSwimming"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.setForeground(new java.awt.Color(153, 255, 204));

        CampoEmail.setBackground(new java.awt.Color(255, 255, 255));
        CampoEmail.setForeground(new java.awt.Color(0, 0, 0));
        CampoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEmailActionPerformed(evt);
            }
        });

        CampoSenha.setBackground(new java.awt.Color(255, 255, 255));
        CampoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSenhaActionPerformed(evt);
            }
        });

        btnNavegar.setBackground(new java.awt.Color(255, 255, 255));
        btnNavegar.setForeground(new java.awt.Color(0, 0, 0));
        btnNavegar.setText("Navegar!");
        btnNavegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavegarActionPerformed(evt);
            }
        });

        TextoEmail.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        TextoEmail.setForeground(new java.awt.Color(255, 255, 255));
        TextoEmail.setText("E-mail");

        TextoSenha.setFont(new java.awt.Font("Ubuntu", 2, 24)); // NOI18N
        TextoSenha.setForeground(new java.awt.Color(255, 255, 255));
        TextoSenha.setText("Senha");

        Resultado.setBackground(new java.awt.Color(255, 255, 255));
        Resultado.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextoEmail)
                    .addComponent(TextoSenha)
                    .addComponent(btnNavegar, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(CampoSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(CampoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addComponent(Resultado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(TextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(TextoSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(Resultado)
                .addGap(46, 46, 46)
                .addComponent(btnNavegar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(720, 60, 460, 570);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/bg.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(640, 0, 570, 710);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/Logo Swing.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 10, 480, 190);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/feito-removebg-preview.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 240, 270, 200);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/hero-bg.png"))); // NOI18N
        jLabel5.setText("jLabel1");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 410, 1210, 300);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/hero-bg.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 420, 1210, 290);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/bg.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 650, 710);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavegarActionPerformed
        //////////////Conexão com o banco//////////////
     Log gravar = new Log();
     gravar.criarLog("Fazendo conexão com o Banco...");
        
        
        //Instancia a classe Connection
        //Instancia um objeto Jdbc e pega o retorno getDataSource
        
        Connection config = new Connection();
        JdbcTemplate con = new JdbcTemplate(config.getDatasource());
        List funcionario = new ArrayList();
        Funcionario usuario = new Funcionario();
        BeanPropertyRowMapper Bean = new BeanPropertyRowMapper();
        
        ///////////////////////////////////////////////
        
        EMAIL = (CampoEmail.getText());
        SENHA = (new String(CampoSenha.getPassword()));

        List<Funcionario> Select = con.query("SELECT"
                + " idFuncionario,"
                + " EMAIL, "
                + "SENHA, "
                + "idMaquina AS Maquina "
                + "from [dbo].[FUNCIONARIO] join\n" +
            "[dbo].[Maquina] ON idFuncionario = fkUsuario",
            new BeanPropertyRowMapper(Funcionario.class));

        for (Funcionario func : Select)
        {
            if(func.getEMAIL().equals(EMAIL) && func.getSENHA().equals(SENHA)) {
                Resultado.setText("LOGADO COM SUCESSO!");
                gravar.criarLog("Usuario logado");
        
           //    new EnviaToken().setVisible(true);
           gravar.criarLog("Iniciando tela token...");
               EnviaToken token = new EnviaToken();
               token.setVisible(true);
               token.setIdsFuncionario(func);
               this.dispose();
                 
            } else {
                gravar.criarLog("Erro na autenticação do usuario");
                Resultado.setText("=(");
            }
        }
    }//GEN-LAST:event_btnNavegarActionPerformed

    private void CampoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSenhaActionPerformed

    }//GEN-LAST:event_CampoSenhaActionPerformed

    private void CampoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEmailActionPerformed

    }//GEN-LAST:event_CampoEmailActionPerformed

    public static void main(String args[]) {
                     
       /////////////////Padrão do SWING////////////////////////
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeepSwimming.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeepSwimming().setVisible(true);
            }
        });
        
        /////////////////////////////////////////////////////////////////
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JLabel Resultado;
    private javax.swing.JLabel TextoEmail;
    private javax.swing.JLabel TextoSenha;
    private javax.swing.JButton btnNavegar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
