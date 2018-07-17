/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.text.Normalizer.Form;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import classes.Servidor;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import static java.lang.System.exit;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 *
 * @author ariel
 */
public class Login extends javax.swing.JFrame {

    private String host;
    private int porta;
    static Socket cliente;
    boolean Status;

    PrintStream saida;

    public Login(boolean Conectado) throws SocketException {
        URL url = this.getClass().getResource("/images/logo.png");
        Image iconeTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(iconeTitulo);
        Status = Conectado;
        this.host = "localhost";
        this.setTitle("iFound - Login de Administrador");
        

        this.porta = 12345;
        //cliente.setSoTimeout(10*1000);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPSideMenu = new javax.swing.JPanel();
        jLLogin = new javax.swing.JLabel();
        jLUsuario = new javax.swing.JLabel();
        jTUsuarioLogin = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTSenhaLogin = new javax.swing.JPasswordField();
        jBEntrar = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelStatus = new javax.swing.JPanel();
        JLStatusIcon = new javax.swing.JLabel();
        jLStatus = new javax.swing.JLabel();
        jPBackground = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPSideMenu.setBackground(new java.awt.Color(255, 255, 255));
        jPSideMenu.setMinimumSize(new java.awt.Dimension(500, 700));
        jPSideMenu.setPreferredSize(new java.awt.Dimension(300, 700));

        jLLogin.setBackground(new java.awt.Color(123, 8, 8));
        jLLogin.setFont(new java.awt.Font("Malgun Gothic Semilight", 0, 28)); // NOI18N
        jLLogin.setForeground(new java.awt.Color(123, 8, 8));
        jLLogin.setText("Login");

        jLUsuario.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLUsuario.setForeground(new java.awt.Color(128, 8, 8));
        jLUsuario.setText("Usuário");

        jTUsuarioLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTUsuarioLogin.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(128, 8, 8));
        jLabel4.setText("Senha");

        jTSenhaLogin.setText("jPasswordField1");
        jTSenhaLogin.setBorder(null);
        jTSenhaLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTSenhaLoginMouseClicked(evt);
            }
        });

        jBEntrar.setBackground(new java.awt.Color(128, 8, 8));
        jBEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBEntrarMouseClicked(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ENTRAR");

        javax.swing.GroupLayout jBEntrarLayout = new javax.swing.GroupLayout(jBEntrar);
        jBEntrar.setLayout(jBEntrarLayout);
        jBEntrarLayout.setHorizontalGroup(
            jBEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBEntrarLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(116, 116, 116))
        );
        jBEntrarLayout.setVerticalGroup(
            jBEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jBEntrarLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jLabel3.setForeground(new java.awt.Color(128, 0, 0));
        jLabel3.setText("Esqueci minha senha");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jPanelStatus.setBackground(new java.awt.Color(255, 255, 255));

        JLStatusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/serverDisconnected.png"))); // NOI18N

        jLStatus.setText("Desconectado");

        javax.swing.GroupLayout jPanelStatusLayout = new javax.swing.GroupLayout(jPanelStatus);
        jPanelStatus.setLayout(jPanelStatusLayout);
        jPanelStatusLayout.setHorizontalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStatusLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(JLStatusIcon)
                .addGap(45, 45, 45)
                .addComponent(jLStatus)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanelStatusLayout.setVerticalGroup(
            jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelStatusLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanelStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLStatusIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLStatus))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPSideMenuLayout = new javax.swing.GroupLayout(jPSideMenu);
        jPSideMenu.setLayout(jPSideMenuLayout);
        jPSideMenuLayout.setHorizontalGroup(
            jPSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSideMenuLayout.createSequentialGroup()
                .addComponent(jPanelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPSideMenuLayout.createSequentialGroup()
                .addGroup(jPSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPSideMenuLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPSideMenuLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(141, 141, 141))
                            .addComponent(jBEntrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTUsuarioLogin)
                            .addComponent(jSeparator1)
                            .addComponent(jTSenhaLogin)
                            .addComponent(jSeparator2)))
                    .addGroup(jPSideMenuLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPSideMenuLayout.setVerticalGroup(
            jPSideMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPSideMenuLayout.createSequentialGroup()
                .addComponent(jPanelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addComponent(jLLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jLUsuario)
                .addGap(18, 18, 18)
                .addComponent(jTUsuarioLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTSenhaLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(62, 62, 62)
                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(47, 47, 47))
        );

        jPBackground.setMaximumSize(new java.awt.Dimension(900, 700));
        jPBackground.setMinimumSize(new java.awt.Dimension(900, 700));
        jPBackground.setPreferredSize(new java.awt.Dimension(900, 700));

        jLabel1.setBackground(new java.awt.Color(255, 153, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background_login_900x700.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(0, 500));
        jLabel1.setMinimumSize(new java.awt.Dimension(900, 700));
        jLabel1.setPreferredSize(new java.awt.Dimension(900, 700));

        javax.swing.GroupLayout jPBackgroundLayout = new javax.swing.GroupLayout(jPBackground);
        jPBackground.setLayout(jPBackgroundLayout);
        jPBackgroundLayout.setHorizontalGroup(
            jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBackgroundLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPBackgroundLayout.setVerticalGroup(
            jPBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPSideMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 352, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
            .addComponent(jPSideMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1273, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (Status) {
            JLStatusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/serverConnected.png")));
            jLStatus.setText("Conectado");
        } else {
            JLStatusIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/serverDisconnected.png")));
            jLStatus.setText("Desconectado");
            jLStatus.setForeground(Color.white);
            jPanelStatus.setBackground(new java.awt.Color(128, 0, 0));
        }
        jTSenhaLogin.setText("");
    }//GEN-LAST:event_formWindowOpened

    private void jBEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBEntrarMouseClicked
        if (Status) {
            String login = jTUsuarioLogin.getText();
            char[] senha = jTSenhaLogin.getPassword();
            String senhaString = String.valueOf(senha);
            String senhaCriptografada = classes.Criptografia.Criptografa(senhaString);
            if (senhaString.equals("") || login.equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Insira o login e senha para continuar");

            } else {
                System.out.println("senha string: " + senhaString);
                System.out.println("senha criptografada: " + senhaCriptografada);
                System.out.println("senha char: " + senha);

                try {
                    Cliente.out.writeObject("login");
                    System.out.println("Enviou comando login ");

                    String resposta;
                    resposta = (String) Cliente.in.readObject();
                    System.out.println("Resposta recebida: " + resposta);
                    if (resposta.equals("ok")) {
                        Cliente.out.writeObject(login);
                        System.out.println("Enviou login");
                        resposta = (String) Cliente.in.readObject();
                        System.out.println("Resposta recebida: " + resposta);
                        if (resposta.equals("ok")) {
                            Cliente.out.writeObject(senhaCriptografada);
                            System.out.println("Enviou senha");

                            resposta = (String) Cliente.in.readObject();
                            if (resposta.equals("ok")) {
                                System.out.println("Recebeu Ok depois da senha");
                                resposta = (String) Cliente.in.readObject();
                                System.out.println("Respost depois do read: " + resposta);
                                if (resposta.equals("ok aluno")) {
                                    System.out.println("Recebeu aluno");
                                    JOptionPane.showMessageDialog(rootPane, "Você inseriu um cadastro de Aluno. Tente novamente com uma conta de administrador.");

                                    //erro
                                } else if (resposta.equals("ok servidor")) {
                                    System.out.println("Recebeu servidor");
                                    Cliente.ServidorLogado = (Servidor) Cliente.in.readObject();
                                    System.out.println("Leu servidor");
                                    Home h = new Home(Cliente.ServidorLogado);
                                    //h.setUndecorated(true);
                                    h.setVisible(true);
                                    dispose();
                                } else if (resposta.equals("nao encontrado")) {
                                    JOptionPane.showMessageDialog(rootPane, "Dados não encontrados.");

                                }
                            }

                        }
                    }
                } catch (IOException ex) {

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Ta saindo");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Você não está conectado. Reinicie o programa e tente novamente");
        }
    }//GEN-LAST:event_jBEntrarMouseClicked

    private void jTSenhaLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTSenhaLoginMouseClicked
        jTSenhaLogin.setText("");
    }//GEN-LAST:event_jTSenhaLoginMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (Status) {
            try {
                Cliente.out.writeObject("fim");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        String email = JOptionPane.showInputDialog("Digite seu e-mail: ");
        try {
            Cliente.out.writeObject("recuperaSenha");
            String resposta = (String) Cliente.in.readObject();
            if (resposta.equals("ok")) {
                Cliente.out.writeObject(email);
                resposta = (String) Cliente.in.readObject();
                if (resposta.equals("ok")) {
                    JOptionPane.showMessageDialog(rootPane, "Foi enviado um email para sua conta cadastrada. Confira para instruções.");
                } else if (resposta.equals("naoEncontrado")) {
                    JOptionPane.showMessageDialog(rootPane, "O e-mail digitado não foi encontrado no sistema");
                } else if (resposta.equals("erro")) {
                    JOptionPane.showMessageDialog(rootPane, "Algo deu errado. Contate um administrador");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Login(true).setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLStatusIcon;
    private javax.swing.JPanel jBEntrar;
    private javax.swing.JLabel jLLogin;
    private javax.swing.JLabel jLStatus;
    private javax.swing.JLabel jLUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPBackground;
    private javax.swing.JPanel jPSideMenu;
    private javax.swing.JPanel jPanelStatus;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPasswordField jTSenhaLogin;
    private javax.swing.JTextField jTUsuarioLogin;
    // End of variables declaration//GEN-END:variables
}