/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.swing;

import java.util.concurrent.ThreadLocalRandom;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 *
 * @author lucas.alves@VALEMOBI.CORP
 */
public class EnviaToken extends javax.swing.JFrame {
    public Funcionario funcionario;
    private String guardaCodig ="";
    
    Log gravar = new Log();

    public void setIdsFuncionario(Funcionario idsFuncionario)
    {
        this.funcionario = idsFuncionario;
    }
    
    public Boolean getPassou() {
        return passou;
    }

    public void setPassou(Boolean passou) {
        this.passou = passou;
    }
    private Boolean passou = false;

    public String getGuardaCodig() {
        return guardaCodig;
    }

    public void setGuardaCodig(String guardaCodig) {
        this.guardaCodig = guardaCodig;
    }
    /**
     * Creates new form EnviaToken
     */
    public EnviaToken() {
        Log log = new Log();
        log.criarLog("=============Envia Token=============");
        log.criarLog("Iniciando tela do tokem...");
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnReenviaCodigo = new javax.swing.JButton();
        btnConfereToken = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblRespostaToken = new javax.swing.JLabel();
        formToken = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Esqueci minh senha");
        setBackground(new java.awt.Color(102, 0, 153));
        setMinimumSize(new java.awt.Dimension(383, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        btnReenviaCodigo.setBackground(new java.awt.Color(0, 0, 153));
        btnReenviaCodigo.setText("Reenviar codigo");
        btnReenviaCodigo.setBorder(null);
        btnReenviaCodigo.setBorderPainted(false);
        btnReenviaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReenviaCodigoActionPerformed(evt);
            }
        });
        getContentPane().add(btnReenviaCodigo);
        btnReenviaCodigo.setBounds(120, 380, 130, 24);

        btnConfereToken.setText("Enviar ");
        btnConfereToken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfereTokenActionPerformed(evt);
            }
        });
        getContentPane().add(btnConfereToken);
        btnConfereToken.setBounds(140, 250, 83, 24);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Digite seu token para continuar");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 150, 230, 20);
        getContentPane().add(lblRespostaToken);
        lblRespostaToken.setBounds(60, 280, 250, 20);

        formToken.setBackground(new java.awt.Color(255, 255, 255));
        formToken.setForeground(new java.awt.Color(51, 51, 51));
        formToken.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.blue, new java.awt.Color(0, 0, 255), null, null));
        getContentPane().add(formToken);
        formToken.setBounds(30, 180, 320, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/gui/img/TokenSwingg.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(390, 420));
        jLabel1.setMinimumSize(new java.awt.Dimension(390, 420));
        jLabel1.setPreferredSize(new java.awt.Dimension(390, 420));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 390, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReenviaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReenviaCodigoActionPerformed
        Log log = new Log();
        log.criarLog("Emitindo token");
        emiteCodigo();
        System.out.println(getGuardaCodig());
    
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new KeepSwimming_TelegramBot(true));
            KeepSwimming_TelegramBot.sendToTelegramToken(guardaCodig);
            log.criarLog("Token enviado");
                    
        } catch (TelegramApiException e) {
            e.printStackTrace();
            log.criarLog("Houve um erro ao enviar o tokem");
        }        
    }//GEN-LAST:event_btnReenviaCodigoActionPerformed

    private void btnConfereTokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfereTokenActionPerformed
        Log log = new Log();
        
        String usarioDigitou = formToken.getText();
        if ("".equals(usarioDigitou)) {
            lblRespostaToken.setText("Digite um token valido para continuar!!");
        }
        else if(usarioDigitou.equalsIgnoreCase(guardaCodig)){
//           new TelaUsuarioLogado().setVisible(true);
             new TelaPrincipal(funcionario).setVisible(true);
             this.dispose();
             log.criarLog("Login realizado com sucesso");
        }
        
    }//GEN-LAST:event_btnConfereTokenActionPerformed
    public void emiteCodigo (){
        Log log = new Log();
        log.criarLog("Gerando código token");
        
        Integer enviaCodigo = ThreadLocalRandom.current().nextInt(1000, 5000);
        String codigoFormatado = enviaCodigo.toString();
        
        setGuardaCodig(codigoFormatado);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnviaToken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviaToken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviaToken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviaToken.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviaToken().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfereToken;
    private javax.swing.JButton btnReenviaCodigo;
    private javax.swing.JTextField formToken;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblRespostaToken;
    // End of variables declaration//GEN-END:variables
}